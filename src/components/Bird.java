package components;
import constants.Image;
import utils.Shapes;

public class Bird {

	public double initX, initY;
	public double x, y;
	private double vy = 0;
	
	public static double G = 800; //gravity
	public static double FLAP = -250;

	public final int BIRD_WIDTH = 34;
	public final int BIRD_HEIGHT = 24;
	
	public Hitbox box;
	
	public Bird(double x, double y) {
		this.initX = x;
		this.initY = y;
		startPosition();
	}
	

	public void update(double dt) {
		this.vy += G * dt;
		y += this.vy * dt;
		box.move(0, this.vy * dt, Math.atan(this.vy/300));
	}

	public void startPosition() {
		this.box =  new Hitbox(this.initX, this.initY, x + BIRD_WIDTH, this.initY + BIRD_HEIGHT);
		this.x = this.initX;
		this.y = this.initY;
		this.vy = 0;
	}
	
	public void flap() {
		this.vy = FLAP;
	}
	public void draw(Shapes t) {
		t.image(Image.FLAPPY, 528, 128, BIRD_WIDTH, BIRD_HEIGHT, Math.atan(this.vy/300), this.x, this.y);
	}

}
 