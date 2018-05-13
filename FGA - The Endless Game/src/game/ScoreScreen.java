package game;

import jplay.GameImage;
import jplay.Keyboard;
import jplay.Window;

public class ScoreScreen extends Level {

	private int option = 0;
	private String nextScenario =  null; 
	private GameObject[] mencao = new GameObject[6];
	private GameObject[] password = new GameObject[5];
	
	public ScoreScreen(Window gameWindow, String name) {
		
		  this.window = gameWindow;
		  this.scenarioName = name;
	
	}
	
	public String getScenarioName() {
		
		return this.scenarioName;
	}
	
	private void initializeScoreMenu(){
	
		this.addPlayer(700,50,"src//recursos//sprite//jogador2.png", 20, window);
		background = new GameImage("src//recursos//sprite//scorescreen//score_background.png");
		nextScenario = null;
		this.addPlayer(700,50,"src//recursos//sprite//jogador2.png", 20, window);
		
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
	
	protected void initializeObjects(){
		
		mencao[0] = new GameObject(135, 260, "src//recursos//sprite//scorescreen//SR.png", 1, GameObjectType.OTHER);
		mencao[1] = new GameObject(135, 260, "src//recursos//sprite//scorescreen//II.png", 1, GameObjectType.OTHER);
		mencao[2] = new GameObject(220, 260, "src//recursos//sprite//scorescreen//MI.png", 1, GameObjectType.OTHER);
		mencao[3] = new GameObject(170, 260, "src//recursos//sprite//scorescreen//MM.png", 1, GameObjectType.OTHER);
		mencao[4] = new GameObject(190, 260, "src//recursos//sprite//scorescreen//MS.png", 1, GameObjectType.OTHER);
		mencao[5] = new GameObject(210, 260, "src//recursos//sprite//scorescreen//SS.png", 1, GameObjectType.OTHER);
		
		password[0] = new GameObject(250, 560, "src//recursos//sprite//scorescreen//password_c1.png", 1, GameObjectType.OTHER);
		password[1] = new GameObject(250, 560, "src//recursos//sprite//scorescreen//password_mds.png", 1, GameObjectType.OTHER);
		password[2] = new GameObject(250, 560, "src//recursos//sprite//scorescreen//password_tcc.png", 1, GameObjectType.OTHER);
		password[3] = new GameObject(250, 560, "src//recursos//sprite//scorescreen//password_end.png", 1, GameObjectType.OTHER);
		
	}
	
	
	public String runScenario() {
		
		initializeScoreMenu();
		initializeKeyboard();
		initializeObjects();
		drawLevel();
		System.out.println(nextScenario);
		return nextScenario;
		
	}
		
	

	private void drawLevel() {
		
		while(this.nextScenario == null) {
			
			background.draw();
			this.drawScore();
			this.drawPassword();
			
	
			enterNextScreen();
			
			
			window.update();
			
		}
		
	}
	
	private void drawScore() {
		
		switch(this.playerInstance.getScore()) {
		case(3):
			mencao[5].draw();
			break;
		case(2):
			mencao[4].draw();
			break;
		case(1):
			mencao[3].draw();
			break;
		case(0):
			mencao[2].draw();
			break;
		case(-1):
			mencao[1].draw();
			break;
		case(-2):
			mencao[0].draw();
			break;
		}
	}
	
	private void drawPassword() {
		
		playerInstance.setPreviousLevel("LevelC1");
		
		switch(this.playerInstance.getPreviousLevel()) {
		case("LevelC1"):
			password[0].draw();
			break;
		case("LevelMDS"):
			password[1].draw();
			break;
		case("LevelTCC"):
			password[2].draw();
			break;
		case("FinishScene"):
			password[3].draw();
			break;
		}
		
	}
	
	private void enterNextScreen() {
		if(sceneKeyboard.keyDown(Keyboard.ENTER_KEY)) {

			if(option == 0) {
				nextScenario = "IntroductionScene";
			} else if (option == 1) {
				nextScenario = "PasswordMenu";
			}
			
		}
	}
	
}