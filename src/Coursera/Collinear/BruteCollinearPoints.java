package Collinear;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BruteCollinearPoints {

    private final List<LineSegment> lineSegments = new ArrayList<>();

    public BruteCollinearPoints(Point[] points) {
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
        for (int i = 0; i < clone.length; i++) {
            for (int j = i + 1; j < clone.length; j++) {
                double slop1 = clone[i].slopeTo(clone[j]);
                for (int k = j + 1; k < clone.length; k++) {
                    double slop2 = clone[i].slopeTo(clone[k]);
                    for (int l = k + 1; l < clone.length; l++) {
                        double slop3 = clone[i].slopeTo(clone[l]);
                        if (slop1 == slop2 && slop2 == slop3) {
                            lineSegments.add(new LineSegment(clone[i], clone[l]));
                        }
                    }
                }
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
