package Coursera.Puzzle;

import edu.princeton.cs.algs4.MinPQ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solver {

    private class Node implements Comparable<Node> {
        private final Board current;
        private final Node previous;
        private final int moves;
        private final int priority;

        private Node(Board current, Node previous) {
            this.current = current;
            this.previous = previous;
            if (previous == null) {
                moves = 0;
            } else {
                moves = previous.moves + 1;
            }
            priority = this.moves + this.current.manhattan();
        }

        private Board getCurrent() {
            return current;
        }

        public Node getPrevious() {
            return previous;
        }

        @Override
        public int compareTo(Node that) {
            if (that.priority > this.priority)
                return -1;
            else if (that.priority == this.priority) {
                return this.getCurrent().manhattan() - that.getCurrent().manhattan();
            } else {
                return 1;
            }
        }
    }

    private Node current;

    public Solver(Board initial) {
        if (initial == null) {
            throw new IllegalArgumentException();
        }
        MinPQ<Node>queue = new MinPQ<>();
        MinPQ<Node>queue2 = new MinPQ<>();
        current = new Node(initial, null);
        Node twin = new Node(initial.twin(), null);
        queue.insert(current);
        queue2.insert(twin);
        while (true) {
            current = queue.delMin();
            twin = queue2.delMin();
            if (current.getCurrent().isGoal() || twin.getCurrent().isGoal()) {
                break;
            }
            for (Board board: current.getCurrent().neighbors()) {
                if (current.getPrevious() == null || !board.equals(current.getPrevious().getCurrent())) {
                    queue.insert(new Node(board, current));
                }
            }
            for (Board board: twin.getCurrent().neighbors()) {
                if (twin.getPrevious() == null || !board.equals(twin.getPrevious().getCurrent())) {
                    queue2.insert(new Node(board, twin));
                }
            }
        }
    }

    // is the initial board solvable? (see below)
    public boolean isSolvable() {
        return current.getCurrent().isGoal();
    }

    // min number of moves to solve initial board; -1 if unsolvable
    public int moves() {
        if (!isSolvable()) {
            return -1;
        }
        return current.moves;
    }

    // sequence of boards in a shortest solution; null if unsolvable
    public Iterable<Board> solution() {
        if (!isSolvable()) {
            return null;
        }
        Node temp = current;
        List<Board>boards = new ArrayList<>();
        while (temp != null) {
            boards.add(temp.getCurrent());
            temp = temp.getPrevious();
        }
        Collections.reverse(boards);
        return boards;
    }
}
