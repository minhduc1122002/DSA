package Coursera.Collinear;

import edu.princeton.cs.algs4.StdDraw;
import java.util.Comparator;

public class Point implements Comparable<Point> {

    private final int x;

    private final int y;

    public Point(int x, int y)  {
        this.x = x;
        this.y = y;
    }

    public void draw() {
        StdDraw.point(x, y);
    }

    public void drawTo(Point that) {
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public int compareTo(Point that) {
        if (y < that.y || (y == that.y && x < that.x)) {
            return -1;
        } else {
            return 1;
        }
    }

    public double slopeTo(Point that) {
        if (this.x == that.x) {
            if (this.y == that.y) {
                return Double.NEGATIVE_INFINITY;
            }
            return Double.POSITIVE_INFINITY;
        } else if (this.y == that.y) {
            return 0;
        }
        return (double) (that.y - this.y) / (that.x - this.x);
    }

    public Comparator<Point> slopeOrder() {
        Comparator<Point> comparator = new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if (slopeTo(o1) < slopeTo(o2)) {
                    return -1;
                } else if (slopeTo(o1) > slopeTo(o2)){
                    return 1;
                } else {
                    return 0;
                }
            }
        };
        return comparator;
    }
}
