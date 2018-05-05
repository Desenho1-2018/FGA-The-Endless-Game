package game;

import jplay.GameImage;
import jplay.Keyboard;
import jplay.Window;

public class MainMenu extends Scenario {

	private GameImage background = new GameImage("src//recursos//sprite//main_menu.png");
	private GameButton start_button = null;
	private GameButton passoworld_button = null;
	private GameButton arrow = null;
	private Keyboard menuKeyboard = null;
	private int option = 0;
	private String nextScenario =  null; 
	
	public MainMenu(Window gameWindow, String name) {
	
		window = gameWindow;
		scenarioName = name;
		start_button = new GameButton(300, 300, "src//recursos//sprite//iniciar_button.png");
		passoworld_button = new GameButton(308, 350, "src//recursos//sprite//passworld_button.png");
		arrow = new GameButton(250, 300, "src//recursos//sprite//arrow_button.png");
		initializeKeyboard();
		
	}
	
	private void initializeKeyboard() {
		
		if(window != null) {
			menuKeyboard = window.getKeyboard();
		} else {
			System.out.println("The keyboard needs a window to run. The window cannot be null");
		}
		menuKeyboard.setBehavior(Keyboard.DOWN_KEY, Keyboard.DETECT_INITIAL_PRESS_ONLY); 
		menuKeyboard.setBehavior(Keyboard.UP_KEY, Keyboard.DETECT_INITIAL_PRESS_ONLY); 
		menuKeyboard.setBehavior(Keyboard.ENTER_KEY, Keyboard.DETECT_INITIAL_PRESS_ONLY);
	
	}
	
	@Override
	public String run() {
	
		drawLevel();
		System.out.println(nextScenario);
		return nextScenario;
		
	}

	private void drawLevel() {
	
		while(nextScenario == null) {
		
			background.draw();
			start_button.draw();
			passoworld_button.draw();
			arrow.draw();
			
			moveArrow();
			selectOption();
			window.update();
		
		
		}
		
	}
	
	private void moveArrow() {
		
		if(menuKeyboard.keyDown(Keyboard.DOWN_KEY)) {
			if(arrow.y <= 325) {
				arrow.y = arrow.y + 50;
				option = 1;
			} else {
				arrow.y = arrow.y;
			}
			
		}
		
		if(menuKeyboard.keyDown(Keyboard.UP_KEY)) {
			if(arrow.y >= 325) {
				arrow.y = arrow.y - 50;
				option = 0;
			} else {
				arrow.y = arrow.y;
			}
			
		}
		
	}
	
	
	private void selectOption() {
		
		if(menuKeyboard.keyDown(Keyboard.ENTER_KEY)) {

			if(option == 0) {
				nextScenario = "Cenario1";
			} else if (option == 1) {
				nextScenario = "FinishScene";
			}
			
		}
		

	}
	
}