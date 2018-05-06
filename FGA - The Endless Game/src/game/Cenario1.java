package game;

import jplay.GameImage;
import jplay.Window;

public class Cenario1 extends Scenario {
	
	private Jogador jogador;
	GameImage backGround = new GameImage("src//recursos//tiles//background_default.png");
	private NPC npc;
	private Scenario cena;
	private GameObject parede;
	public Cenario1(Window gameWindow, String name){
		
		this.window = gameWindow;
		this.scenarioName = name;
		jogador = new Jogador(640, 350, window);
		npc = new NPC(300,300);
		parede = new GameObject(600,300, "src//recursos//tiles//wallextended.png");
	}

	@Override 
	public String runScenario(){
		
		this.drawLevel();
		return "NEXT_LEVEL";
	}
	
	private void drawLevel() {
		while(true){

			backGround.draw();
			jogador.draw();
			npc.perseguir(jogador.x, jogador.y);
			npc.draw();
			parede.draw();
			
			jogador.caminho(cena , parede);
			npc.caminho(cena,parede);
			jogador.mover(window);
			parede.update();
			window.update();
			
		}		
	}
}
