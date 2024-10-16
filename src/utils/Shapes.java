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

    public Shapes(Graphics2D g) {
        this.g = g;
        g.setColor(Color.white);
    }


    public void triangle(int x1, int y1,
            int x2, int y2, int x3, int y3, Colour cor) {
        g.setColor(new Color(cor.r, cor.g, cor.b));
        g.fillPolygon(new int[] { x1, x2, x3 },
                new int[] { y1, y2, y3 },
                3);
    }

    public void triangle(double x1, double y1,
            double x2, double y2, double x3, double y3, Colour cor) {
        triangle((int) Math.round(x1),
                (int) Math.round(y1),
                (int) Math.round(x2),
                (int) Math.round(y2),
                (int) Math.round(x3),
                (int) Math.round(y3), cor);
    }

    public void circulo(int cx, int cy, int raio, Colour cor) {
        g.setColor(new Color(cor.r, cor.g, cor.b));
        g.fillOval(cx - raio, cy - raio, raio * 2, raio * 2);
    }

    public void circulo(double cx, double cy, int raio, Colour cor) {
        circulo((int) Math.round(cx),
                (int) Math.round(cy),
                raio, cor);
    }

    public void square(int x, int y, int lado, Colour cor) {
        g.setColor(new Color(cor.r, cor.g, cor.b));
        g.fillRect(x, y, lado, lado);
    }

    public void square(double x, double y, int lado, Colour cor) {
        square((int) Math.round(x), (int) Math.round(y),
                lado, cor);
    }

    public void rectangle(int x, int y, int largura, int altura, Colour cor) {
        g.setColor(new Color(cor.r, cor.g, cor.b));
        g.fillRect(x, y, largura, altura);
    }

    public void rectangle(double x, double y, int largura, int altura, Colour cor) {
        rectangle((int) Math.round(x), (int) Math.round(y),
                largura, altura, cor);
    }

    public void text(String text, int x, int y, int tamanho, Colour cor) {
        g.setColor(new Color(cor.r, cor.g, cor.b));
        g.setFont(new Font("Arial", Font.BOLD, tamanho));
        g.drawString(text, x, y);
    }

    public void text(String text, double x, double y, int tamanho, Colour cor) {
        text(text, (int) Math.round(x), (int) Math.round(y), tamanho, cor);
    }

    public void image(String file, int xa, int ya, int larg, int alt, double dir, double x, double y) {
        if (!sprites.containsKey(file)) {
            try {
                sprites.put(file, ImageIO.read(new File(file)));
            } catch (java.io.IOException ioex) {
                throw new RuntimeException(ioex);
            }
        }
        AffineTransform trans = g.getTransform();
        g.rotate(dir, x + larg / 2, y + alt / 2);
        g.drawImage(sprites.get(file), (int) Math.round(x), (int) Math.round(y), (int) Math.round(x) + larg,
                (int) Math.round(y) + alt,
                xa, ya, xa + larg, ya + alt, null);
        AffineTransform borderTrans = g.getTransform();
        // Reset the transform
        g.setTransform(trans);
        // Draw the border
        g.drawRect((int) Math.round(x), (int) Math.round(y), larg, alt);
        // Restore the original transform
        g.setTransform(borderTrans);

        g.setTransform(trans);
    }
}
