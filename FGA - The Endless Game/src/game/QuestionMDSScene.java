package game;

import jplay.GameImage;
import jplay.Keyboard;
import jplay.Window;

public class QuestionMDSScene extends Level {

	private GameObject arrow = null;
	private int option = 0;
	private String nextScenario =  null; 
	private int numberQuestion;
	
	//Constroi a cena e
	//adiciona objetos na cena
	public QuestionMDSScene(Window gameWindow, String name, int numberQuestion) {
	
		window = gameWindow;
		scenarioName = name;
		background = new GameImage("src//recursos//sprite//lousa.jpeg");
		arrow = new GameObject(50, 300, "src//recursos//sprite//arrow_transparente.png", 1, GameObjectType.OTHER);
		this.numberQuestion = numberQuestion;
		this.addPlayer(700,50,"src//recursos//sprite//jogador2.png", 20, window);
		
		
		
		if(numberQuestion == 1){
			GameObject limit = new GameObject(50, 50, "src//recursos//sprite//question//rup.jpeg", 1, GameObjectType.OTHER);
			GameObject answer0 = new GameObject(100, 300, "src//recursos//sprite//question//rup3.png", 1, GameObjectType.OTHER);
			GameObject answer1 = new GameObject(100, 350, "src//recursos//sprite//question//rup2.png", 1, GameObjectType.OTHER);
			GameObject answer2 = new GameObject(100, 400, "src//recursos//sprite//question//rup1.png", 1, GameObjectType.OTHER);
			GameObject answer3 = new GameObject(100, 450, "src//recursos//sprite//question//rup4.png", 1, GameObjectType.OTHER);
			
			this.addSceneObjects(answer0);
			this.addSceneObjects(answer1);
			this.addSceneObjects(answer2);
			this.addSceneObjects(answer3);
			this.addSceneObjects(limit);	
		}
		
		else if(numberQuestion == 2){
			GameObject derivada = new GameObject(50, 50, "src//recursos//sprite//question//Scrum.jpeg", 1, GameObjectType.OTHER);
			GameObject answer0 = new GameObject(100, 300, "src//recursos//sprite//question//Scrum4.png", 1, GameObjectType.OTHER);
			GameObject answer1 = new GameObject(100, 350, "src//recursos//sprite//question//Scrum2.png", 1, GameObjectType.OTHER);
			GameObject answer2 = new GameObject(100, 400, "src//recursos//sprite//question//Scrum3.png", 1, GameObjectType.OTHER);
			GameObject answer3 = new GameObject(100, 450, "src//recursos//sprite//question//Scrum1.png", 1, GameObjectType.OTHER);
			
			this.addSceneObjects(answer0);
			this.addSceneObjects(answer1);
			this.addSceneObjects(answer2);
			this.addSceneObjects(answer3);
			this.addSceneObjects(derivada);	
		}
		
		else if(numberQuestion == 3){
			GameObject integral = new GameObject(50, 50, "src//recursos//sprite//question//par.jpeg", 1, GameObjectType.OTHER);
			GameObject answer0 = new GameObject(100, 300, "src//recursos//sprite//question//par4.png", 1, GameObjectType.OTHER);
			GameObject answer1 = new GameObject(100, 350, "src//recursos//sprite//question//par2.png", 1, GameObjectType.OTHER);
			GameObject answer2 = new GameObject(100, 400, "src//recursos//sprite//question//par3.png", 1, GameObjectType.OTHER);
			GameObject answer3 = new GameObject(100, 450, "src//recursos//sprite//question//par1.png", 1, GameObjectType.OTHER);
			
			this.addSceneObjects(answer0);
			this.addSceneObjects(answer1);
			this.addSceneObjects(answer2);
			this.addSceneObjects(answer3);
			this.addSceneObjects(integral);	
		}
		
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
		this.playerInstance.setPreviousLevel("LevelMDS");
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
				new Battle(false, "QuestionMDSScene1");
				   this.playerInstance.setScore(1);
				   waitAtime();
				nextScenario = "BattleScene";
				 break;
			  case 1:
				new Battle(false, "QuestionMDSScene1");
				   this.playerInstance.setScore(1);
				   waitAtime();
				nextScenario = "BattleScene";
				break;	
			  case 2:
				new Battle(true, "QuestionMDSScene1");    
				nextScenario = "BattleScene";
				break;
			  case 3:
				new Battle(false, "QuestionMDSScene1");  
				   this.playerInstance.setScore(1);
				   waitAtime();
				nextScenario = "BattleScene";
				break;	
			}
		  }	
		  else if(numberQuestion == 2){
			switch(option){
			  case 0: 
				new Battle(false, "QuestionMDSScene2");
				   this.playerInstance.setScore(1);
				   waitAtime();
				nextScenario = "BattleScene";
			  break;
			  case 1:
				new Battle(false, "QuestionMDSScene2");
				   this.playerInstance.setScore(1);
				   waitAtime();
				nextScenario = "BattleScene";
			  break;	
			  case 2:
				new Battle(false, "QuestionMDSScene2"); 
				   this.playerInstance.setScore(1);
				   waitAtime();
				nextScenario = "BattleScene";
			  break;
			  case 3:
				new Battle(true, "QuestionMDSScene2");   
				nextScenario = "BattleScene";
			  break;	
			}  
		  }
		  else if(numberQuestion == 3){
			switch(option){
			 case 0: 
			   new Battle(false, "QuestionMDSScene3");
			   this.playerInstance.setScore(1);
			   waitAtime();
			   nextScenario = "BattleScene";
			 break;
			 case 1:
			   new Battle(false, "QuestionMDSScene3");
			   this.playerInstance.setScore(1);
			   waitAtime();
			   nextScenario = "BattleScene";
			 break;	
			 case 2:
			   new Battle(false, "QuestionMDSScene3");
			   this.playerInstance.setScore(1);
			   waitAtime();
			   nextScenario = "BattleScene";
			 break;
			 case 3:
			   new Battle(true, "QuestionMDSScene3");   
			   nextScenario = "BattleScene";
			  break;	
				}  
			  }
		}
	}
	
	private void waitAtime() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
