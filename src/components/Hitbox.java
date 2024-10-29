package components;

import java.util.ArrayList;


import utils.Point;
import utils.Polygon;

public class Hitbox {

    private ArrayList<Point> points = new ArrayList<Point>();
    private Polygon border;

    public Point[] getCoordinates() {
        return (Point[]) points.toArray();
    }

    public Hitbox(Point p1, Point p2, Point p3, Point p4) {
        this.border = new Polygon(p1, p2, p3, p4);

    }

    public Hitbox(double x1, double y1, double x2, double y2) {
        this.points.add(new Point(x1, y1));
        this.points.add(new Point(x1, y2));
        this.points.add(new Point(x2, y1));
        this.points.add(new Point(x2, y2));

        this.border = new Polygon(points.get(0), points.get(1), points.get(2), points.get(3));
    }

    public void move(Point p1, Point p2, Point p3, Point p4) {
        this.points.clear();
        this.points.add(p1);
        this.points.add(p2);
        this.points.add(p3);
        this.points.add(p4);
        this.border = new Polygon(this.points.get(0), this.points.get(1), this.points.get(2), this.points.get(3));
    }
    

    public void move(double dx, double dy) {
        for (Point p : this.points) {
            p.x += dx;
            p.y += dy;
        }

    }

    public void move(double dx, double dy, double radius) {
        this.move(dx, dy);
        this.border.radius = radius;

    }

    public boolean intersect(Hitbox other) {
        return this.border.intersect(other.border);
    }
}