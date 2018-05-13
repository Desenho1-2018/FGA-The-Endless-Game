package game;

import jplay.GameImage;
import jplay.Sprite;
import jplay.Window;

public class Battle extends Scenario {

	public static boolean answer;
	public static String currentScene;

	GameImage background = new GameImage(("src/recursos/sprite/UnbGama.png"));

	public Battle(Window gameWindow, String name) {
		this.window = gameWindow;
		this.scenarioName = name;
	}

	public Battle(boolean answer, String currentScene) {
		this.answer = answer;
		this.currentScene = currentScene;
	}

	@Override
	public String getScenarioName() {

		return this.scenarioName;
	}

	@Override
	public String runScenario() {

		drawScenario();

		if (currentScene == "QuestionCalculo1Scene1")
			return "QuestionCalculo1Scene2";
		else if (currentScene == "QuestionCalculo1Scene2")
			return "QuestionCalculo1Scene3";
		else if (currentScene == "QuestionCalculo1Scene3")
			return "QuestionMDSScene1";
		else if (currentScene == "QuestionMDSScene1")
			return "QuestionMDSScene2";
		else if (currentScene == "QuestionMDSScene2")
			return "QuestionMDSScene3";
		return scenarioName;

	}

	public void drawScenario() {

		GameImage backgroundBattle = new GameImage(("src/recursos/sprite/UnbGama.png"));
		Sprite missed = new Sprite("src/recursos/sprite/question/errou.png");
		Sprite right = new Sprite("src/recursos/sprite/question/acertou2.png");

		while (true) {
			backgroundBattle.draw();
			if (answer) {
				right.draw();
			} else {
				missed.draw();
			}

			window.update();

		}
	}

}
