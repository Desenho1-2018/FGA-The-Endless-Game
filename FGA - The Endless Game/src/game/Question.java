package game;

import jplay.GameImage;
import jplay.Keyboard;
import jplay.Window;

public class Question extends Scenario {

	private GameObject arrow = null;
	private int option = 0;
	private String nextScenario =  null; 
	
	//Constroi a cena e
	//adiciona objetos na cena
	public Question(Window gameWindow, String name) {
	
		window = gameWindow;
		scenarioName = name;
		background = new GameImage("src//recursos//sprite//lousa.jpeg");
		GameObject enunciado = new GameObject(50, 50, "src//recursos//sprite//question//calculo1.jpeg");
		GameObject answer0 = new GameObject(100, 300, "src//recursos//sprite//question//0.png");
		GameObject answer1 = new GameObject(100, 350, "src//recursos//sprite//question//1.png");
		GameObject answer2 = new GameObject(100, 400, "src//recursos//sprite//question//2.png");
		GameObject answer3 = new GameObject(100, 450, "src//recursos//sprite//question//3.png");
		arrow = new GameObject(50, 300, "src//recursos//sprite//arrow_transparente.png");
		
		this.addSceneObjects(answer0);
		this.addSceneObjects(answer1);
		this.addSceneObjects(answer2);
		this.addSceneObjects(answer3);
		this.addSceneObjects(enunciado);
		
	}
	
	//Atualiza os quadros da cena
	protected void updateScenario() {
		
		while(nextScenario == null) {
		
			drawObjects();
	
			//Arrow n�o esta na lista de objetos por ser um objeto especifico com movimento.
			//fica como TO DO o que fazer para generalizar objetos desse tipo tamb�m.
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
	
		initializeKeyboard();
		updateScenario();
		System.out.println(nextScenario);
		return nextScenario;
		
	}

	
	private void moveArrow() {
		
		if(sceneKeyboard.keyDown(Keyboard.DOWN_KEY)) {
				if(option < 3 )
					option = option + 1;
				
		}	
		else if(sceneKeyboard.keyDown(Keyboard.UP_KEY)) {
			 if(option > 0)
				 option = option - 1;
		}

		switch (option) {
		  case 0:
			arrow.y = 300;
			 break;
		  case 1:
			arrow.y = 350;
			 break;
		  case 2:
			arrow.y = 400;
			 break;
		  case 3:
			arrow.y = 450;
			  break;
		  default:
			//do nothing
			break;
		}
		
	}
		
	private void selectOption() {
		
		if(sceneKeyboard.keyDown(Keyboard.ENTER_KEY)) {

			if(option == 0) {
				nextScenario = "IntroductionScene";
			} else if (option == 1) {
				nextScenario = "FinishScene";
			}
			
		}
		
	}
	
}