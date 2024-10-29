package utils;

import java.util.ArrayList;

public class Polygon {
    private class Line {
        public Point p1;
        public Point p2;

        public Line(Point p1, Point p2) {
            this.p1 = p1;
            this.p2 = p2;
        }

        public Line(double x1, double y1, double x2, double y2) {
            this.p1 = new Point(x1, y1);
            this.p2 = new Point(x2, y2);
        }

        public boolean intersect(Line line) {
            double x1 = p1.x, y1 = p1.y, x2 = p2.x, y2 = p2.y;
            double x3 = line.p1.x, y3 = line.p1.y, x4 = line.p2.x, y4 = line.p2.y;

            double uA = (x4 - x3) * (y1 - y3) - (y4 - y3) * (x1 - x3);
            double uB = (x2 - x1) * (y1 - y3) - (y2 - y1) * (x1 - x3);
            double denominator = (y4 - y3) * (x2 - x1) - (x4 - x3) * (y2 - y1);

            if (denominator == 0) { // Lines are parallel
                return false;
            }

            double ua = uA / denominator;
            double ub = uB / denominator;

            return (ua >= 0 && ua <= 1 && ub >= 0 && ub <= 1);
        }
    }

    private ArrayList<Line> lines = new ArrayList<Line>();
    public double radius = 0;

    public Polygon(Point p1, Point p2, Point p3, Point p4) {

        lines.add(new Line(p1, p2));
        lines.add(new Line(p2, p3));
        lines.add(new Line(p3, p4));
        lines.add(new Line(p4, p1));
    }

    public Polygon(Point p1, Point p2, Point p3) {
        lines.add(new Line(p1, p2));
        lines.add(new Line(p2, p3));
        lines.add(new Line(p3, p1));
    }

    // Returns true if two hitboxes intersect
    public boolean intersect(Polygon other) {
        for (Line line : lines) {
            for (Line line2 : other.lines) {
                if (line.intersect(line2)) {
                    return true;
                }
            }
        }
        return false;
    }
}
