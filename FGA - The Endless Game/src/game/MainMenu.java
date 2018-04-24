package game;

import jplay.GameImage;
import jplay.Window;

public class MainMenu {

	private Window janela;
	private GameImage background = new GameImage("src//recursos//tile//background_menu.png");
	
	public MainMenu(Window window) {
		
		janela = window;
		run();
		
	}
	
	private void run() {
		background.draw();
	}
	
}
