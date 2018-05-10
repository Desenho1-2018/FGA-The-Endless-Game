package game;

import java.awt.Color;
import java.awt.Font;

import jplay.GameImage;
import jplay.Time;
import jplay.Window;

public class LevelTCC extends Level {

	GameObject book = new GameObject(100, 200, "src//recursos//sprite//livro.gif", 1, GameObjectType.REFERENCE_ITEM);
	GameObject pencil = new GameObject(400, 400, "src//recursos//sprite//canudol.gif", 1,
			GameObjectType.REFERENCE_ITEM);
	GameObject coffe = new GameObject(400, 100, "src//recursos//sprite//coffe.gif", 1, GameObjectType.REFERENCE_ITEM);
	Time tempo = new Time(640, 50, false);

	public LevelTCC(Window gameWindow, String name) {

		this.window = gameWindow;
		this.scenarioName = name;
		this.background = new GameImage("src//recursos//tiles/planofundo.png");
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
		tempo.setColor(Color.WHITE);
		tempo.setFont(new Font("sansserif", Font.TRUETYPE_FONT, 15));
		tempo.setTime(0, 0, 30);

		while (this.nextScenario == null) {

			background.draw();
			tempo.draw("Time: ");
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