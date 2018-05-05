package game;

import jplay.GameImage;
import jplay.Window;

public class Cenario1 extends Scenario {
	
	private Jogador jogador;
	GameImage backGround = new GameImage("src//recursos//tiles//background_default.png");
	private GameObject wall;
	private NPC npc;
	public Cenario1(Window gameWindow, String name){
		
		this.window = gameWindow;
		this.scenarioName = name;
		jogador = new Jogador(640, 350, window);
		wall = new GameObject(630,340);
		npc = new NPC(300,300);
	}

	@Override 
	public String run(){
		
		this.drawLevel();
		return "NEXT_LEVEL";
	}
	
	private void drawLevel() {
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
