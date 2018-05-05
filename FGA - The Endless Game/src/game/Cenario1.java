package game;

import jplay.GameImage;
import jplay.Window;

public class Cenario1 extends Scenario {
	
	private Jogador jogador;
	GameImage backGround = new GameImage("src//recursos//tiles//background_default.png");
	private GameObject wall;
	private NPC npc;
	public Cenario1(Window window){
		
		this.window = window;
		jogador = new Jogador(640, 350);
		wall = new GameObject(630,340);
		npc = new NPC(300,300);
		run();
	}

	private void run(){
		
		while(true){
			//cena.draw();
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
