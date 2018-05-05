package game;

import jplay.GameImage;
import jplay.Window;

public class Cenario1 extends Scenario {
	
	private Jogador jogador;
	GameImage backGround = new GameImage("src//recursos//tiles//background_default.png");
	private GameObject wall;
	private NPC npc;
	public Cenario1(Window gameWindow){
		
		this.window = gameWindow;
		jogador = new Jogador(640, 350);
		wall = new GameObject(630,340);
		npc = new NPC(300,300);
	}

	@Override 
	public void run(){
		
		while(true){

			backGround.draw();
			jogador.draw();
			npc.perseguir(jogador.x, jogador.y);
			npc.draw();
			wall.draw();
			jogador.mover(window);
			window.update();
			
		}
		
	}
}
