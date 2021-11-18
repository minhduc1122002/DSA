package Collinear;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FastCollinearPoints {

    private final List<LineSegment> lineSegments = new ArrayList<>();

    public FastCollinearPoints(Point[] points) {
        if (points == null) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < points.length; i++) {
            if (points[i] == null) {
                throw new IllegalArgumentException();
            }
        }
        for (int i = 0; i < points.length - 1; i++) {
            if (points[i].compareTo(points[i + 1]) == 0) {
                throw new IllegalArgumentException();
            }
        }
        Point[]clone = points.clone();
        Arrays.sort(clone);
        Point[] temp;
        for (int i = 0; i < clone.length; i++) {
            Point origin = clone[i];
            temp = clone.clone();
            Arrays.sort(temp, origin.slopeOrder());
            for (int j = 0; j < clone.length; ) {
                double slope = origin.slopeTo(temp[j]);
                int k = j;
                while (k + 1 < clone.length && slope == origin.slopeTo(temp[k + 1]) && origin.compareTo(temp[k]) < 0) {
                    k++;
                }
                if (k - j + 1 >= 3) {
                    lineSegments.add(new LineSegment(origin, temp[k]));
                }
                j = k + 1;
            }
        }
    }

    public int numberOfSegments() {
        return lineSegments.size();
    }

    public LineSegment[] segments() {
        return lineSegments.toArray(new LineSegment[lineSegments.size()]);
    }
}
