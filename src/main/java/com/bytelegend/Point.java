package com.bytelegend;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Point point = (Point) o;

        if (x != point.x) {
            return false;
        }
        return y == point.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public String toString() {
        return String.format("(%d,%d)", x, y);
    }

    /**
     * Sort a list of `Point` in ascending order of `x` first and then `y`. For example, a sorted
     * list: `(-1, 1) (1, -1) (2, -1) (2, 0) (2, 1)`. Hint: you can use `Collections.sort()` method.
     */
    public static List<Point> sort(List<Point> points) {
        Collections.sort(points, (p1, p2) -> {
            if (p1.getX() == p2.getX()) {
                return valueTest(p1.getY(), p2.getY());
            }
            return valueTest(p1.getX(), p2.getX());
        });
        return points;
    }

    public static int valueTest(int a, int b) {
        long testValue = (long) a - (long) b;
        if (testValue > Integer.MAX_VALUE) {
            return 1;
        } else if (testValue < Integer.MIN_VALUE) {
            return -1;
        } else return 0;
    }

    public static void main(String[] args) throws IOException {
        List<Point> points =
                Arrays.asList(
                        new Point(1234567890, -1234567890),
                        new Point(-1234567890, 1234567890));
        System.out.println(Point.sort(points));
    }
}
