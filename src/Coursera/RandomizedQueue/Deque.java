package Coursera.RandomizedQueue;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private class Node {
        Item item;

        Node prev;

        Node next;

        Node(Item item, Node prev, Node next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node first;

    private Node last;

    private int size;

    // construct an empty deque
    public Deque() {
        this.first = null;
        this.last = null;
        size = 0;
    }

    // is the deque empty?
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    // return the number of items on the deque
    public int size() {
        return this.size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        if (first == null) {
            first = new Node(item, null, null);
            last = first;
        } else {
            Node temp = new Node(item, null, first);
            first = temp;
        }
        size++;
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        if (last == null) {
            last = new Node(item, null, null);
            first = last;
        } else {
            Node temp = new Node(item, last, null);
            last = temp;
        }
        size++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Item item = first.item;
        first = first.next;
        size--;
        return item;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Item item = last.item;
        last = last.prev;
        size--;
        return item;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            private Node temp = first;
            @Override
            public boolean hasNext() {
                return temp != null;
            }

            @Override
            public Item next() {
                if (!hasNext()) throw new NoSuchElementException();
                Item item = temp.item;
                temp = temp.next;
                return item;
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    // unit testing (required)
    public static void main(String[] args) {
        StringBuilder expected, actual;

        Deque<Double> deque = new Deque<Double>();
        Double lastNum = StdRandom.uniform() * 100;
        StdOut.printf("%s%.2f%s\n\n", "Adding ", lastNum, " to the rear of the deque...");
        deque.addLast(lastNum);

        Double firstNum = StdRandom.uniform() * 100;
        StdOut.printf("%s%.2f%s\n\n", "Adding ", firstNum, " to the front of the deque...");
        deque.addFirst(firstNum);

        expected = new StringBuilder();
        expected.append(String.format("%.2f %.2f", firstNum, lastNum));
        actual = new StringBuilder();
        for (Double aDouble : deque) actual.append(String.format("%.2f ", aDouble));
        actual.deleteCharAt(actual.length() - 1);
        StdOut.printf("%s\n", "Listing all elements in the deque using interator: ");
        StdOut.printf("%s%s\n", "Expected: ", expected.toString());
        StdOut.printf("%s%s\n", "Actual: ", actual.toString());
        StdOut.printf("%s\n\n", expected.compareTo(actual) == 0 ? "PASSED" : "FAILED");

        StdOut.printf("%s%.2f%s\n", "Removing ", firstNum, " from the deque: ");
        Double popNum = deque.removeFirst();
        StdOut.printf("%s%.2f\n", "Expected: ", firstNum);
        StdOut.printf("%s%.2f\n", "Actual: ", popNum);
        StdOut.printf("%s\n\n", firstNum.compareTo(popNum) == 0 ? "PASSED" : "FAILED");

        StdOut.printf("%s\n", "Checking size of the deque: ");
        StdOut.printf("%s\n", "Expected: 1");
        StdOut.printf("%s%d\n", "Actual: ", deque.size());
        StdOut.printf("%s\n\n", deque.size() == 1 ? "PASSED" : "FAILED");

        StdOut.printf("%s%.2f%s\n", "Removing ", lastNum, " from the deque: ");
        popNum = deque.removeLast();
        StdOut.printf("%s%.2f\n", "Expected: ", lastNum);
        StdOut.printf("%s%.2f\n", "Actual: ", popNum);
        StdOut.printf("%s\n\n", lastNum.compareTo(popNum) == 0 ? "PASSED" : "FAILED");

        StdOut.printf("%s\n", "Checking if deque is empty: ");
        StdOut.printf("%s\n", "Expected: true");
        StdOut.printf("%s%s\n", "Actual: ", deque.isEmpty() ? "true" : "false");
        StdOut.printf("%s\n\n", deque.isEmpty() ? "PASSED" : "FAILED");
    }

}
