package utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.HashMap;
import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.geom.AffineTransform;

/**
 * Screen para desenho.
 * 
 */
public class Shapes {
    Graphics2D g;

    public static HashMap<String, BufferedImage> sprites = new HashMap<>();
    private boolean showBorder = true;
    public Shapes(Graphics2D g) {
        this.g = g;
        g.setColor(Color.white);
    }

    public void triangle(int x1, int y1,
            int x2, int y2, int x3, int y3, Colour colour) {
        g.setColor(new Color(colour.r, colour.g, colour.b));
        g.fillPolygon(new int[] { x1, x2, x3 },
                new int[] { y1, y2, y3 },
                3);
    }

    public void triangle(double x1, double y1,
            double x2, double y2, double x3, double y3, Colour colour) {
        triangle((int) Math.round(x1),
                (int) Math.round(y1),
                (int) Math.round(x2),
                (int) Math.round(y2),
                (int) Math.round(x3),
                (int) Math.round(y3), colour);
    }

    public void circle(int cx, int cy, int raio, Colour colour) {
        g.setColor(new Color(colour.r, colour.g, colour.b));
        g.fillOval(cx - raio, cy - raio, raio * 2, raio * 2);
    }

    public void circle(double cx, double cy, int raio, Colour colour) {
        circle((int) Math.round(cx),
                (int) Math.round(cy),
                raio, colour);
    }

    public void square(int x, int y, int lado, Colour colour) {
        g.setColor(new Color(colour.r, colour.g, colour.b));
        g.fillRect(x, y, lado, lado);
    }

    public void square(double x, double y, int lado, Colour colour) {
        square((int) Math.round(x), (int) Math.round(y),
                lado, colour);
    }

    public void rectangle(int x, int y, int width, int height, Colour colour) {
        g.setColor(new Color(colour.r, colour.g, colour.b));
        g.fillRect(x, y, width, height);
    }

    public void rectangle(double x, double y, int width, int height, Colour colour) {
        rectangle((int) Math.round(x), (int) Math.round(y),
                width, height, colour);
    }

    public void text(String text, int x, int y, int size, Colour colour) {
        g.setColor(new Color(colour.r, colour.g, colour.b));
        g.setFont(new Font("Arial", Font.BOLD, size));
        g.drawString(text, x, y);
    }

    public void text(String text, double x, double y, int size, Colour colour) {
        text(text, (int) Math.round(x), (int) Math.round(y), size, colour);
    }

    public void image(String file, int xa, int ya, int width, int height, double radius, double x, double y ) {
        if (!sprites.containsKey(file)) {
            try {
                sprites.put(file, ImageIO.read(new File(file)));
            } catch (java.io.IOException ioex) {
                throw new RuntimeException(ioex);
            }
        }
        AffineTransform trans = g.getTransform();
        g.rotate(radius, x + width / 2, y + height / 2);
        g.drawImage(sprites.get(file), (int) Math.round(x), (int) Math.round(y), (int) Math.round(x) + width,
                (int) Math.round(y) + height,
                xa, ya, xa + width, ya + height, null);

     

        if (showBorder) {
            // Draw the border
            AffineTransform borderTrans = g.getTransform();
            g.drawRect((int) Math.round(x), (int) Math.round(y), width, height);

            // Restore the original transform
            g.setTransform(borderTrans);
        }

        // Reset the transform
        g.setTransform(trans);

        g.setTransform(trans);
    }
}
