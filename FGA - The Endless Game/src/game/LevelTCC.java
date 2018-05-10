package game;

import java.awt.Color;
import java.awt.Font;

import jplay.GameImage;
import jplay.Time;
import jplay.Window;

public class LevelTCC extends Level {

	GameObject book = new GameObject(100, 200, "src//recursos//sprite//livro.gif", 1, GameObjectType.REFERENCE_ITEM);
	GameObject canudo = new GameObject(400, 400, "src//recursos//sprite//canudol.gif", 1,
			GameObjectType.REFERENCE_ITEM);
	GameObject coffee = new GameObject(400, 100, "src//recursos//sprite//coffe.gif", 1, GameObjectType.REFERENCE_ITEM);
	Time tempo = new Time(640, 50, false);

	public LevelTCC(Window gameWindow, String name) {

		this.window = gameWindow;
		this.scenarioName = name;
		this.background = new GameImage("src//recursos//tiles/planofundo.png");
		addPlayer(100, 100, "src//recursos//sprite//jogador2.png", 20, window);
		this.addSceneObjects(book);
		this.addSceneObjects(canudo);
		this.addSceneObjects(coffee);

	}

	@Override
	public String runScenario() {

		// initializeKeyboard();
		this.drawLevel();
		return nextScenario;

	}

	private void drawLevel() {
		boolean coletaItem1 = false;
		boolean coletaItem2 = false;
		boolean coletaItem3 = false;
		
		tempo.setColor(Color.WHITE);
		tempo.setFont(new Font("sansserif", Font.TRUETYPE_FONT, 15));
		tempo.setTime(0, 0, 30);

		while (this.nextScenario == null) {
			background.draw();
			tempo.draw("Time: ");
			book.draw();
			canudo.draw();
			coffee.draw();
			playerInstance.draw();
			playerInstance.setCollisionType(this.playerCollision());
			playerInstance.move(window);
			window.update();
				
				if (playerInstance.collided(book)) {
					book.hide();
					coletaItem1 = true;
				}
				if (playerInstance.collided(canudo)) {
					canudo.hide();
					coletaItem2 = true;
				}
				if (playerInstance.collided(coffee)) {
					coffee.hide();
					coletaItem3 = true;
				}
				if(coletaItem1 == true && coletaItem2 == true && coletaItem3 == true) {
					window.exit();
				}

				if(tempo.getSecond() == 0){
					nextScenario = "Reintegracao";
				}

			}

	}

	@Override
	protected void initializeKeyboard() {

	}
}