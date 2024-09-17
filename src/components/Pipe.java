package components;

import constants.Image;
import utils.Shapes;

public class Pipe {
	public double vxpipe;
	public double x, y;
	public static int HOLESIZE = 90;
	public Hitbox boxcima;
	public Hitbox boxbaixo;
	
	public Pipe(double x, double y, double vx) {
		this.x = x;
		this.y = y;
		this.vxpipe = vx;
		
		this.boxcima = new Hitbox(x, y -540, x + 52, y);
		this.boxbaixo = new Hitbox(x, y + Pipe.HOLESIZE, x + 34, y + 360);
		
	}
	
	public void update(double dt) {
		x += vxpipe *dt;
		boxcima.move(vxpipe * dt, 0);
		boxbaixo.move(vxpipe * dt, 0);
	}
	
	public void draw (Shapes t) {
		t.image(Image.FLAPPY, 604, 0, 52, 270, 0, x, y - 270); //pipe de cima
		t.image(Image.FLAPPY, 604, 0, 52, 135, 0, x, y - 405 ); //pipe de cima 2
		t.image(Image.FLAPPY, 604, 0, 52, 135, 0, x, y - 540 ); //pipe de cima 3
		
		t.image(Image.FLAPPY, 660, 0, 52, 242, 0, x, y + Pipe.HOLESIZE); //pipe de baixo
		t.image(Image.FLAPPY, 660, 52, 52, 242, 0, x, y + 225); //pipe de baixo 2
		t.image(Image.FLAPPY, 660, 52, 52, 242, 0, x, y + 360); //pipe de baixo 3
		
	}
}
