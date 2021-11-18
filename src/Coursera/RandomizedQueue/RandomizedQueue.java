package RandomizedQueue;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] items;

    private int size;
    // construct an empty randomized queue
    public RandomizedQueue() {
        this.items = (Item[]) new Object[1];
        this.size = 0;
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    // return the number of items on the randomized queue
    public int size() {
        return size;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) throw new IllegalArgumentException();
        if (size == items.length) {
            resize(2 * items.length);
        }
        items[size] = item;
        size++;
    }

    // remove and return a random item
    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        int x = StdRandom.uniform(size);
        Item temp = items[x];
        items[x] = items[--size];
        items[size] = null;
        if (size > 0 && size == items.length / 4) resize(items.length/2);
        return  temp;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        int x = StdRandom.uniform(size);
        return items[x];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RandomOrder();
    }

    private class RandomOrder implements Iterator<Item> {
        private int current;
        private final int[] index;

        private RandomOrder() {
            current = size;
            index = new int[size];
            for (int j = 0; j < size; j++) {
                index[j] = j;
            }
            StdRandom.shuffle(index);
        }

        public boolean hasNext() {
            return current > 0;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return items[index[--current]];
        }
    }


    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        if (size >= 0) System.arraycopy(items, 0, copy, 0, size);
        items = copy;
    }

    // unit testing (required)
    public static void main(String[] args) {
        StringBuilder expected, actual;

        RandomizedQueue<Double> randomizedQueue = new RandomizedQueue<>();
        Double num1 = StdRandom.uniform() * 100;
        StdOut.printf("%s%.2f%s\n\n", "Adding ", num1, " to the queue...");
        randomizedQueue.enqueue(num1);

        StdOut.printf("%s\n", "Getting a random number from the queue: ");
        Double sampleNum = randomizedQueue.sample();
        StdOut.printf("%s%.2f\n", "Expected: ", num1);
        StdOut.printf("%s%.2f\n", "Actual: ", sampleNum);
        StdOut.printf("%s\n\n", num1.compareTo(sampleNum) == 0 ? "PASSED" : "FAILED");

        Double num2 = StdRandom.uniform() * 100;
        StdOut.printf("%s%.2f%s\n\n", "Adding ", num2, " to the queue...");
        randomizedQueue.enqueue(num2);

        Double num3 = StdRandom.uniform() * 100;
        StdOut.printf("%s%.2f%s\n\n", "Adding ", num3, " to the queue...");
        randomizedQueue.enqueue(num3);

        StdOut.printf("%s\n", "Checking size of the queue: ");
        StdOut.printf("%s\n", "Expected: 3");
        StdOut.printf("%s%d\n", "Actual: ", randomizedQueue.size());
        StdOut.printf("%s\n\n", randomizedQueue.size() == 3 ? "PASSED" : "FAILED");

        expected = new StringBuilder();
        expected.append(String.format("%.2f %.2f %.2f", num1, num2, num3));
        actual = new StringBuilder();
        Iterator<Double> iterator = randomizedQueue.iterator();
        boolean checkIterator = true;
        while (iterator.hasNext()) {
            String popNum = String.format("%.2f", iterator.next());
            checkIterator = checkIterator & (expected.indexOf(popNum) != -1);
            actual.append(popNum).append(" ");
        }
        actual.deleteCharAt(actual.length() - 1);
        StdOut.printf("%s\n", "Listing all elements in the queue using interator: ");
        StdOut.printf("%s%s\n", "Expected: ", expected.toString());
        StdOut.printf("%s%s\n", "Actual: ", actual.toString());
        StdOut.printf("%s\n\n", checkIterator ? "PASSED" : "FAILED");

        StdOut.printf("%s%.2f%s\n\n", "Removing ", randomizedQueue.dequeue(), " from the queue...");

        StdOut.printf("%s%.2f%s\n\n", "Removing ", randomizedQueue.dequeue(), " from the queue...");

        StdOut.printf("%s%.2f%s\n\n", "Removing ", randomizedQueue.dequeue(), " from the queue...");

        StdOut.printf("%s\n", "Checking if queue is empty: ");
        StdOut.printf("%s\n", "Expected: true");
        StdOut.printf("%s%s\n", "Actual: ", randomizedQueue.isEmpty() ? "true" : "false");
        StdOut.printf("%s\n\n", randomizedQueue.isEmpty() ? "PASSED" : "FAILED");
    }
}