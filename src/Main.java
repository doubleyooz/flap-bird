import constants.Image;
import constants.MainScreen;
import interfaces.Action;
import interfaces.Game;
import utils.Shapes;
import utils.Timer;

import java.util.ArrayList;
import java.util.Random;

import components.Bird;
import components.Pipe;

public class Main implements Game{
	
		
	public double ground_offset = 0;
	public double gvx = 50;//velocidade do chão
	
	public double background_offset = 0;
	public double gvx2 = 15; //velocidade do fudno
	
	private final int GAP = 112;
	private boolean gameover = false;

	public Bird bird;
	public ArrayList<Pipe> pipes = new ArrayList<Pipe>();
	public Random gerador = new Random();
	public Timer timer_pipe;
	

	private int width = MainScreen.GAME_WIDTH;
	private int height = MainScreen.GAME_HEIGHT;


	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public String getTitle(){
		return MainScreen.GAME_TITLE;
	}

	public Main() {
		bird = new Bird(35, (MainScreen.GAME_WIDTH - GAP) / 1.5);
		timer_pipe = new Timer(3, true, addPipe()); // gera o pipes na ela
		
	}
	
	private Action addPipe() {
		return new Action() {

			public void run() {
				pipes.add(new Pipe(MainScreen.GAME_HEIGHT, gerador.nextInt(MainScreen.GAME_HEIGHT - GAP  - Pipe.HOLESIZE), -gvx));
			}
		};
	}
	
    public void key(String key) {
    	if (key.equals(" "))
    			bird.flap();
    }

    public void tick(java.util.Set<String> keys, double dt) {
		if(gameover) return;
    	ground_offset += dt * gvx;
    	ground_offset = ground_offset%MainScreen.GROUND_WIDTH;
    	
    	background_offset += dt * gvx2;
    	background_offset = background_offset%MainScreen.BG_WIDTH;
    	
    	timer_pipe.tick(dt);
    	
		
    	bird.update(dt);
    	for (Pipe pipe: pipes) {
    		pipe.update(dt);
    		if (bird.box.intersecao(pipe.boxcima) != 0 || bird.box.intersecao(pipe.boxbaixo) != 0) {
    			System.out.println(MainScreen.GAME_OVER);
				gameover = true;
    			//gameover
    		}
    	}
    	
    	if (pipes.size() > 0 && pipes.get(0).x < -60) {
    		pipes.remove(0);
    		
    	}
    	if (bird.y + 24 >= MainScreen.GAME_HEIGHT - GAP || bird.y <= 0 ) {
    		System.out.println(MainScreen.GAME_OVER);
			gameover = true;
    	}
  
    		
    }
    
    public void draw(Shapes t) {
    	//background
    	t.image(Image.FLAPPY, 0, 0, MainScreen.BG_WIDTH, MainScreen.GAME_HEIGHT, 0, -background_offset, 0);
    	t.image(Image.FLAPPY, 0, 0, MainScreen.BG_WIDTH, MainScreen.GAME_HEIGHT, 0, MainScreen.BG_WIDTH - background_offset, 0);
    	t.image(Image.FLAPPY, 0, 0, MainScreen.BG_WIDTH, MainScreen.GAME_HEIGHT, 0, MainScreen.BG_WIDTH * 2 - background_offset, 0);
    	
    	for (Pipe pipe: pipes) {
    		pipe.draw(t);
    	}
    	
    	//ground
    	t.image(Image.FLAPPY, 292, 0, MainScreen.GROUND_WIDTH, GAP, 0, -ground_offset, MainScreen.GAME_HEIGHT - GAP);
    	t.image(Image.FLAPPY, 292, 0, MainScreen.GROUND_WIDTH, GAP, 0, MainScreen.GROUND_WIDTH - ground_offset, MainScreen.GAME_HEIGHT - GAP);
    	t.image(Image.FLAPPY, 292, 0, MainScreen.GROUND_WIDTH, GAP, 0, MainScreen.GROUND_WIDTH * 2 - ground_offset, MainScreen.GAME_HEIGHT - GAP);
    	
    	
    	bird.draw(t);
    }
	
	public static void main(String[]args) {
		new Motor (new Main());
	}
}
