package game;

import jplay.GameImage;
import jplay.Window;

public class MainMenu extends Scenario {

	private GameImage background = new GameImage("src//recursos//sprite//main_menu.png");
	private GameButton start_button;
	private GameButton passoworld_button;
	private GameButton arrow;
	
	public MainMenu(Window gameWindow) {
	
		this.window = gameWindow;
		start_button = new GameButton(300, 300, "src//recursos//sprite//iniciar_button.png");
		passoworld_button = new GameButton(308, 350, "src//recursos//sprite//passworld_button.png");
		arrow = new GameButton(250, 300, "src//recursos//sprite//arrow_button.png");
	}
	
	@Override
	public void run() {
		while(true) {
			background.draw();
			start_button.draw();
			passoworld_button.draw();
			arrow.draw();
			window.update();
		}
	}
	
	
	
}
