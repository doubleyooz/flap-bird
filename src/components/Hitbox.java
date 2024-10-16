package components;

public class Hitbox {

    private double x1 = Double.NEGATIVE_INFINITY, y1 = Double.NEGATIVE_INFINITY, x2 = Double.NEGATIVE_INFINITY,
            y2 = Double.NEGATIVE_INFINITY;

    public double[] getCoordinates() {
        return new double[] { x1, y1, x2, y2 };
    }

    public Hitbox(double x1, double y1, double x2, double y2) {
        this.move(x1, y1, x2, y2);
    }

    public void move(double x1, double y1, double x2, double y2) {
        this.x1 = Math.min(x1, x2);
        this.x2 = Math.max(x1, x2);
        this.y1 = Math.min(y1, y2);
        this.y2 = Math.max(y1, y2);
    }

    public void move(double dx, double dy) {
        this.x1 += dx;
        this.x2 += dx;
        this.y1 += dy;
        this.y2 += dy;
    }

    // Returns true if two hitboxes intersect
    public boolean intersection(Hitbox hb) {

        return (this.x1 < hb.x2 && this.x2 > hb.x1 &&
                this.y1 < hb.y2 && this.y2 > hb.y1);

    }

}