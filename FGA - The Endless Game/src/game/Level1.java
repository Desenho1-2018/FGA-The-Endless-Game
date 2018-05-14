package game;

import jplay.GameImage;
import jplay.Window;

public class Level1 extends Level {

	GameImage backGround = new GameImage("src//recursos//tiles//background_default.png");
	private NPC npc;
	private Scenario cena;
	private GameObject parede;
	private Wall parede1;
	public Level1(Window gameWindow, String name){

		this.window = gameWindow;
		this.scenarioName = name;
		addPlayer(640, 350, "src//recursos//sprite//jogador2.png", 20, window);
		npc = new NPC(300,300);
		parede = new GameObject(600,300, "src//recursos//tiles//wallextended.png", 1, GameObjectType.WALL);
		this.addSceneObjects(parede);
		parede1=new Wall("src//recursos//sprite//parededebaixo3.png",600,580,800,10);
		this.addSceneObjects((GameObject)parede1);
		int i,i2;
		parede1.paredeslateraislabirinto2();
		parede1.labirinto();
		i2=parede1.sizeparedes();
		for(i=0;i<i2;i++) {
			this.addSceneObjects(parede1.getparede(i));
		}
		
	}

	@Override
	public String runScenario(){

		initializeKeyboard();
		this.drawLevel();
		SoundPlayer.stop();
		return "NEXT_LEVEL";
		
	}

	private void drawLevel() {
		
		SoundPlayer.play("src//recursos//audio//doido.mid");
		
		while(true){

			backGround.draw();

			playerInstance.draw();
	
			npc.draw();
			parede.draw();
						
			playerInstance.setCollisionType(this.playerCollision());
			npc.perseguir(playerInstance.x, playerInstance.y);
			//player.caminho(cena , parede);
			npc.caminho(cena,parede);
			playerInstance.move(window);
			parede1.paredesdraw();
		    parede1.draw();	
			parede.update();
			window.update();

		}
	}
}
