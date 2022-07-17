package com.bytelegend;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
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
        points.sort((o1, o2) -> {
            if (o1.getX() != o2.getX()) {
                return getSymbol (((long) o1.getX() - (long) o2.getX()));
            }
            return getSymbol((long)o1.getY() - (long) o2.getY());
        });
        return points;
    }

    private static int getSymbol(long value) {
        return (int) (value / Math.abs(value));
    }

    public static void main(String[] args) throws IOException {
        List<Point> points =
                Arrays.asList(
                        new Point(2, 0),
                        new Point(-1, 1),
                        new Point(1, -1),
                        new Point(2, 1),
                        new Point(2, -1));
        System.out.println(Point.sort(points));
    }
}
