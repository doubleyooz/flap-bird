package components;

import constants.Image;
import constants.MainScreen;
import utils.Shapes;

public class Pipe {
	public double speed;
	public double x, y;
	private final int UPPER_X = 604;
	private final int LOWER_X = 660;
	private final int WIDTH = 52;
	public static int HOLESIZE = 90;

	public Hitbox upper;
	public Hitbox lower;

	public Pipe(double x, double y, double vx) {
		this.x = x;
		this.y = y;
		this.speed = vx;

		System.out.printf("Upper: %.2f / %d / %.2f / %.2f\n", x, 0, x + this.WIDTH, y);
		System.out.printf("Lower: %.2f / %.2f / %.2f / %d\n\n", x, y + Pipe.HOLESIZE, x + this.WIDTH, MainScreen.GROUND_HEIGHT
		);

		// this.upper = new Hitbox(x, y + Pipe.HOLESIZE, x + this.WIDTH, MainScreen.GROUND_HEIGHT);
		this.lower = new Hitbox(x, y + Pipe.HOLESIZE, x + this.WIDTH, MainScreen.GROUND_HEIGHT);
		this.upper = new Hitbox(x, 0, x + this.WIDTH, y);
	}

	public void update(double dt) {
		x += this.speed * dt;
		upper.move(this.speed * dt, 0);
		lower.move(this.speed * dt, 0);
	}

	public void draw(Shapes t) {
		// upper pipe
		t.image(Image.FLAPPY, this.UPPER_X, 0, this.WIDTH, 270, 0, this.x, this.y -
				270); //
		t.image(Image.FLAPPY, this.UPPER_X, 0, this.WIDTH, 135, 0, this.x, this.y -
				405); // 2
		t.image(Image.FLAPPY, this.UPPER_X, 0, this.WIDTH, 135, 0, this.x, this.y -
				540); // 3

		// lower pipe
		t.image(Image.FLAPPY, this.LOWER_X, 0, this.WIDTH, 242, 0, this.x, this.y + Pipe.HOLESIZE);
		t.image(Image.FLAPPY, this.LOWER_X, 52, this.WIDTH, 242, 0, this.x, this.y + 225); // 2
		t.image(Image.FLAPPY, this.LOWER_X, 52, this.WIDTH, 242, 0, this.x, this.y + 360); // 3

	}
}
