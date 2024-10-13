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
        if (x1 < x2) {
            this.x1 = x1;
            this.x2 = x2;
        } else {
            this.x1 = x2;
            this.x2 = x1;
        }
        if (y1 < y2) {
            this.y1 = y1;
            this.y2 = y2;
        } else {
            this.y1 = y2;
            this.y2 = y1;
        }
    }

    public void move(double dx, double dy) {
        this.x1 += dx;
        this.x2 += dx;
        this.y1 += dy;
        this.y2 += dy;
    }

    // Returns true if two hitboxes intersect
    public boolean intersection(Hitbox hb) {
        double[] theseCoordinates = this.getCoordinates();
        double[] hbCoordinates = hb.getCoordinates();

        System.out.printf("theseCoordinates: (%.2f %.2f) (%.2f %.2f)\n", theseCoordinates[0], theseCoordinates[1],
                theseCoordinates[2], theseCoordinates[3]);
        System.out.printf("hbCoordinates: (%.2f %.2f) (%.2f %.2f)\n\n", hbCoordinates[0], hbCoordinates[1],
                hbCoordinates[2], hbCoordinates[3]);

        System.out.println("First Condition: " + (this.x1 < hb.x2));
        System.out.println("Second Condition: " + (this.x2 > hb.x1));
        System.out.println("Third Condition: " + (this.y1 < hb.y2));
        System.out.println("Fourth Condition: " + (this.y2 > hb.y1));

        return (this.x1 < hb.x2 && this.x2 > hb.x1 &&
                this.y1 < hb.y2 && this.y2 > hb.y1);

    }

}