package game;

import jplay.GameImage;
import jplay.Window;

public class Level1 extends Level {

	GameImage backGround = new GameImage("src//recursos//tiles//background_default.png");
	private NPC npc;
	private Scenario cena;
	private GameObject parede;
	CollisionControl colisaonpc = new CollisionControl();
	public boolean enemyFought = false;
	public Level1(Window gameWindow, String name){

		this.window = gameWindow;
		this.scenarioName = name;
		addPlayer(640, 350, "src//recursos//sprite//jogador2.png", 20, window);
		npc = new NPC(300,300);
		parede = new GameObject(600,300, "src//recursos//tiles//wallextended.png", 1, GameObjectType.WALL);
		this.addSceneObjects(parede);
	}

	public String runScenario() {

		initializeKeyboard();
		this.drawLevel();
		return nextScenario;

	}

	private void drawLevel() {
		
		SoundPlayer.play("src//recursos//audio//doido.mid");
		
		while (this.nextScenario == null) {

			backGround.draw();
			playerInstance.draw();
			npc.draw();
			parede.draw();
			playerInstance.setCollisionType(this.playerCollision());
			npc.perseguir(playerInstance.x, playerInstance.y);
			npc.caminho(cena,parede);
			playerInstance.move(window);
			parede.update();
			window.update();
			if(enemyFought == false){
				if(colisaonpc.colisao(playerInstance, npc) == true){
					nextScenario = "QuestionCalculo1Scene";
					enemyFought = true;
			}
				
			}		
		}
	}
}
