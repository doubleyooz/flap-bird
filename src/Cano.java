
public class Cano {
	public double vxcano;
	public double x, y;
	public static int HOLESIZE = 90;
	public Hitbox boxcima;
	public Hitbox boxbaixo;
	
	public Cano(double x, double y, double vx) {
		this.x = x;
		this.y = y;
		this.vxcano = vx;
		
		this.boxcima = new Hitbox(x, y -540, x + 52, y);
		this.boxbaixo = new Hitbox(x, y + Cano.HOLESIZE, x + 34, y + 360);
		
	}
	
	public void atualiza(double dt) {
		x += vxcano *dt;
		boxcima.mover(vxcano * dt, 0);
		boxbaixo.mover(vxcano * dt, 0);
	}
	
	public void desenha (Tela t) {
		t.imagem("flappy.png", 604, 0, 52, 270, 0, x, y - 270); //cano de cima
		t.imagem("flappy.png", 604, 0, 52, 135, 0, x, y - 405 ); //cano de cima 2
		t.imagem("flappy.png", 604, 0, 52, 135, 0, x, y - 540 ); //cano de cima 3
		
		t.imagem("flappy.png", 660, 0, 52, 242, 0, x, y + Cano.HOLESIZE); //cano de baixo
		t.imagem("flappy.png", 660, 52, 52, 242, 0, x, y + 225); //cano de baixo 2
		t.imagem("flappy.png", 660, 52, 52, 242, 0, x, y + 360); //cano de baixo 3
		
	}
}
