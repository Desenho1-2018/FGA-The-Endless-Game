package game;

import jplay.GameImage;
import jplay.Keyboard;
import jplay.Sprite;
import jplay.Window;
import game.GameButton;

public class Reintegracao extends Scenario {

	GameImage background = new GameImage("src//recursos//sprite//reint.png");
	Sprite numbers = new Sprite("src//recursos//sprite//continue");
	GameButton continue_button = new GameButton(240, 400, "src//recursos//sprite//continuebutton1.png");
	int count = 9;
	String faseAtual;

	public Reintegracao(Window gameWindow, String name, String faseAtual) {
		this.window = gameWindow;
		this.scenarioName = name;
		this.faseAtual = faseAtual;
	}

	@Override
	public String runScenario() {
		Keyboard keyboard = window.getKeyboard();
		numbers.x = 350;
		numbers.y = 230;

		for (int i = 0; i <= count; ++i) {
			numbers.loadImage("src//recursos//sprite//continue//num" + String.valueOf(count - i) + ".png");
			background.draw();
			continue_button.draw();
			numbers.draw();
			window.update();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("Não foi possível abrir a tela de Reintegração");
				e.printStackTrace();
			}
			if (count == 9) {
				nextScenario = "GameOver";
			}
			if (keyboard.keyDown(Keyboard.ENTER_KEY)) {
				nextScenario = faseAtual;
				break;
			} else if (keyboard.keyDown(Keyboard.ESCAPE_KEY)) {
				nextScenario = "GameOver";
				break;
			}

		}
		return nextScenario;
	}

}
