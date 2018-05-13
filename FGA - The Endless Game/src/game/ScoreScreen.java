package game;

import jplay.GameImage;
import jplay.Keyboard;
import jplay.Window;

public class ScoreScreen extends Level {
	
	private GameObject arrow = null;
	private int option = 0;
	private String nextScenario =  null; 
	public ScoreScreen(Window gameWindow, String name) {
		
		  this.window = gameWindow;
		  this.scenarioName = name;
	
	}
	
	public String getScenarioName() {
		
		return this.scenarioName;
	}
	
	private void initializeScoreMenu(){
	
		background = new GameImage("src//recursos//sprite//main_menu1.png");
		GameObject score_button = new GameObject(300, 200, "src//recursos//sprite//iniciar_button.png", 1, GameObjectType.OTHER);
		arrow = new GameObject(270, 210, "src//recursos//sprite//arrow_button.png", 1, GameObjectType.OTHER);
		nextScenario = null;
		
		this.addSceneObjects(score_button);
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
		
		initializeScoreMenu();
		initializeKeyboard();
		drawLevel();
		System.out.println(nextScenario);
		return nextScenario;
		
	}
		
	

	private void drawLevel() {
		
		while(this.nextScenario == null) {
			
			background.draw();
			this.drawObjects();
			playerInstance.getScore();
			
	
			arrow.draw();
			selectOption();
			
			
	
			window.update();
			
		}
		
	}
	
	private void selectOption() {
		
		if(sceneKeyboard.keyDown(Keyboard.ENTER_KEY)) {

			if(option == 0) {
				nextScenario = "IntroductionScene";
			} else if (option == 1) {
				nextScenario = "PasswordMenu";
			}
			
		}
	
	}
	
}