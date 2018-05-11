package game;

import jplay.GameImage;
import jplay.Keyboard;
import jplay.Window;

public class MenuGenderSelector extends Scenario {

	private GameObject arrow = null;
	private int option = 0;
	private String nextScenario =  null; 
	
	//Constroi a cena e
	//adiciona objetos na cena
	public MenuGenderSelector(Window gameWindow, String name) {
	
		window = gameWindow;
		scenarioName = name;
		background = new GameImage("src//recursos//sprite//menu_gender.png");
	
	}
	
	private void initializeGenderMenu(){
		
		
		GameObject garoto_button = new GameObject(300, 300, "src//recursos//sprite//garoto_button.png", 1, GameObjectType.OTHER);
		GameObject garota_button = new GameObject(308, 350, "src//recursos//sprite//garota_button.png", 1,GameObjectType.OTHER);
		arrow = new GameObject(250, 300, "src//recursos//sprite//arrow_button.png", 1, GameObjectType.OTHER);
		nextScenario = null;
		option = 0;
		
		this.addSceneObjects(garoto_button);
		this.addSceneObjects(garota_button);
	}

	//Atualiza os quadros da cena
	protected void updateScenario() {
		
		while(nextScenario == null) {
			
			drawObjects();
	
			arrow.draw();
			moveArrow();
			selectOption();
			
			window.update();
		
		
		}
		
	}
	
	protected void initializeKeyboard() {
		
		if(window != null) {
			sceneKeyboard = window.getKeyboard();
		} else {
			System.out.println("The keyboard needs a window to run. The window cannot be null");
		}
		sceneKeyboard.setBehavior(Keyboard.DOWN_KEY, Keyboard.DETECT_INITIAL_PRESS_ONLY); 
		sceneKeyboard.setBehavior(Keyboard.UP_KEY, Keyboard.DETECT_INITIAL_PRESS_ONLY); 
		sceneKeyboard.setBehavior(Keyboard.ENTER_KEY, Keyboard.DETECT_INITIAL_PRESS_ONLY);
	
	}
	
	public String runScenario() {
		
		initializeGenderMenu();
		initializeKeyboard();
		updateScenario();
		System.out.println(nextScenario);
		return nextScenario;
		
	}

	
	private void moveArrow() {
		
		if(sceneKeyboard.keyDown(Keyboard.DOWN_KEY)) {
			if(arrow.y <= 325) {
				arrow.y = arrow.y + 50;
				option = 1;
			} else {
				arrow.y = arrow.y;
			}
			
		}
		
		if(sceneKeyboard.keyDown(Keyboard.UP_KEY)) {
			if(arrow.y >= 325) {
				arrow.y = arrow.y - 50;
				option = 0;
			} else {
				arrow.y = arrow.y;
			}
			
		}
		
	}
	
	
	private void selectOption() {
		
		if(sceneKeyboard.keyDown(Keyboard.ENTER_KEY)) {

			if(option == 0) {
				//TODO Assign boy sprites to player here
				nextScenario = "IntroductionScene";
			} else if (option == 1) {
				//TODO Assign boy sprites to player here
				nextScenario = "IntroductionScene";
			}
			
		}
	
	}
	
}