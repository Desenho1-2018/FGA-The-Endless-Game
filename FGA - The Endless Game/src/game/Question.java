package game;

import jplay.GameImage;
import jplay.Keyboard;
import jplay.Window;

public class Question extends Scenario {

	private GameObject arrow = null;
	private int option = 0;
	private String nextScenario =  null; 
	private int numberQuestion;
	
	//Constroi a cena e
	//adiciona objetos na cena
	public Question(Window gameWindow, String name, int numberQuestion) {
	
		window = gameWindow;
		scenarioName = name;
		background = new GameImage("src//recursos//sprite//lousa.jpeg");
<<<<<<< 5aa9a0a24f06a6163189045bb4096351ef611c87

		GameObject start_button = new GameObject(300, 300, "src//recursos//sprite//iniciar_button.png", 1, GameObjectType.OTHER);
		GameObject passworld_button = new GameObject(300, 350, "src//recursos//sprite//passworld_button.png", 1, GameObjectType.OTHER);
		GameObject mirando = new GameObject(300, 400, "src//recursos//sprite//mirando.png", 1, GameObjectType.OTHER);
		arrow = new GameObject(250, 300, "src//recursos//sprite//arrow_button.png", 1, GameObjectType.OTHER);

		this.addSceneObjects(start_button);
		this.addSceneObjects(passworld_button);
		this.addSceneObjects(mirando);
=======
		arrow = new GameObject(50, 300, "src//recursos//sprite//arrow_transparente.png");
		this.numberQuestion = numberQuestion;
		
		if(numberQuestion == 1){
			GameObject limit = new GameObject(50, 50, "src//recursos//sprite//question//limite.jpeg");
			GameObject answer0 = new GameObject(100, 300, "src//recursos//sprite//question//27.png");
			GameObject answer1 = new GameObject(100, 350, "src//recursos//sprite//question//36.png");
			GameObject answer2 = new GameObject(100, 400, "src//recursos//sprite//question//45.png");
			GameObject answer3 = new GameObject(100, 450, "src//recursos//sprite//question//54.png");
			
			this.addSceneObjects(answer0);
			this.addSceneObjects(answer1);
			this.addSceneObjects(answer2);
			this.addSceneObjects(answer3);
			this.addSceneObjects(limit);	
		}
		
		if(numberQuestion == 2){
			GameObject integral = new GameObject(50, 50, "src//recursos//sprite//question//integral.jpeg");
			GameObject answer0 = new GameObject(100, 300, "src//recursos//sprite//question//0.png");
			GameObject answer1 = new GameObject(100, 350, "src//recursos//sprite//question//1.png");
			GameObject answer2 = new GameObject(100, 400, "src//recursos//sprite//question//2.png");
			GameObject answer3 = new GameObject(100, 450, "src//recursos//sprite//question//3.png");
			
			this.addSceneObjects(answer0);
			this.addSceneObjects(answer1);
			this.addSceneObjects(answer2);
			this.addSceneObjects(answer3);
			this.addSceneObjects(integral);	
		}
	
>>>>>>> Creation question about limit in calculo 1 class
		
	}

	//Atualiza os quadros da cena
	protected void updateScenario() {
		
		while(nextScenario == null) {
		
			drawObjects();
	
			//Arrow n�o esta na lista de objetos por ser um objeto especifico com movimento.
			//fica como TO DO o que fazer para generalizar objetos desse tipo tamb�m.
			arrow.draw();
			moveArrow();
			selectOption(numberQuestion);
			
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
				
		} else if(sceneKeyboard.keyDown(Keyboard.UP_KEY)) {
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
		
	private void selectOption(int numberQuestion) {
	
		if(sceneKeyboard.keyDown(Keyboard.ENTER_KEY)) {
		  if(numberQuestion == 1){
			switch(option){
			  case 0: 
				new Battle(true);
				nextScenario = "BattleScene";
				 break;
			  case 1:
				new Battle(false);
				nextScenario = "BattleScene";
				break;	
			  case 2:
				new Battle(false);    
				nextScenario = "BattleScene";
				break;
			  case 3:
				new Battle(false);   
				nextScenario = "BattleScene";
				break;	
			}
		  }	
		  else if(numberQuestion == 2){
			switch(option){
			  case 0: 
				new Battle(false);
				nextScenario = "BattleScene";
			  break;
			  case 1:
				new Battle(true);
				nextScenario = "BattleScene";
			  break;	
			  case 2:
				new Battle(false);    
				nextScenario = "BattleScene";
			  break;
			  case 3:
				new Battle(false);   
				nextScenario = "BattleScene";
			  break;	
			}  
		  }
		}
	}
	
}