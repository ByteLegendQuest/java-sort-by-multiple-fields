package com.bytelegend;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Point implements Comparable {
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

    @Override
    public int compareTo(Object o) {
        Point p = (Point) o;
        return this.equals(p) ? 0 : ((this.x > 0 && p.getX() < 0) ? 1 : (this.x < 0 && p.getX() > 0 ? -1 : (this.x == p.getX() ? ((this.y > 0 && p.getY() < 0) ? 1 : ((this.y < 0 && p.getY() > 0) ? -1 : this.y - p.getY())) : this.x - p.getX())));
    }

    /**
     * Sort a list of `Point` in ascending order of `x` first and then `y`. For example, a sorted
     * list: `(-1, 1) (1, -1) (2, -1) (2, 0) (2, 1)`. Hint: you can use `Collections.sort()` method.
     */
    public static List<Point> sort(List<Point> points) {
        points.sort(null);
        return points;
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
