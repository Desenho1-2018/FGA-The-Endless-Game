package game;

import jplay.GameImage;
import jplay.Window;

public class LevelTCC extends Level {

	GameObject book = new GameObject(100, 200, "src//recursos//sprite//livro.gif", 1, GameObjectType.REFERENCE_ITEM);
	GameObject pencil = new GameObject(400, 400, "src//recursos//sprite//canudol.gif", 1,GameObjectType.REFERENCE_ITEM);
	GameObject coffe = new GameObject(400, 100, "src//recursos//sprite//coffe.gif", 1, GameObjectType.REFERENCE_ITEM);

	public LevelTCC(Window gameWindow, String name) {

		this.window = gameWindow;
		this.scenarioName = name;
		this.background = new GameImage("src//recursos//tiles//ground_tcc.png");
		addPlayer(100, 100, "src//recursos//sprite//jogador2.png", 20, window);
		this.addSceneObjects(book);
		this.addSceneObjects(pencil);
		this.addSceneObjects(coffe);

	}

	@Override
	public String runScenario() {

		// initializeKeyboard();
		this.drawLevel();
		return nextScenario;

	}

	private void drawLevel() {
		while (this.nextScenario == null) {

			background.draw();
			book.draw();
			pencil.draw();
			coffe.draw();
			playerInstance.draw();
			playerInstance.setCollisionType(this.playerCollision());
			playerInstance.move(window);
			window.update();

		}
	}

	@Override
	protected void initializeKeyboard() {

	}
}

// public class Level1 extends Level {
//
// GameImage backGround = new
// GameImage("src//recursos//tiles//background_default.png");
// private NPC npc;
// private Scenario cena;
// private GameObject parede;
// public Level1(Window gameWindow, String name){
//
// this.window = gameWindow;
// this.scenarioName = name;
// addPlayer(640, 350, "src//recursos//sprite//jogador2.png", 20, window);
// npc = new NPC(300,300);
// parede = new GameObject(600,300, "src//recursos//tiles//wallextended.png", 1,
// GameObjectType.WALL);
// this.addSceneObjects(parede);
// }