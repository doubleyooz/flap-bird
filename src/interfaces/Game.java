
package interfaces;

import utils.Shapes;

public interface Game {
    String getTitle();
    int getHeight();
    int getWidth();
    void tick(java.util.Set<String> keys, double dt);
    void key(String key);
    void draw(Shapes shapes);
}