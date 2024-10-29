package utils;

public class Point {
    public double x;
    public double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
        this.x = Double.NEGATIVE_INFINITY;
        this.y = Double.NEGATIVE_INFINITY;
    }
}
