package game;

import jplay.GameImage;
import jplay.Sprite;
import jplay.Window;

public class Battle extends Level {

	public static boolean answer;
	public static String currentScene;
	GameImage background = new GameImage(("src/recursos/sprite/UnbGama.png"));
	
	public Battle(Window gameWindow, String name){
	  this.window = gameWindow;
	  this.scenarioName = name;
	  this.addPlayer(700,50,"src//recursos//sprite//jogador2.png", 20, window);
	}
	
	public Battle(boolean answer, String currentScene){
		this.answer = answer;
		this.currentScene = currentScene;
	}
	
	@Override
	public String getScenarioName() {
		
		return this.scenarioName;
	}
	
	@Override
	public String runScenario() {
		
		drawScenario();
		
		if(currentScene == "QuestionCalculo1Scene1")
			return "QuestionCalculo1Scene2";
		  else if(currentScene == "QuestionCalculo1Scene2")
			  return "QuestionCalculo1Scene3"; 
		     else if(currentScene == "QuestionCalculo1Scene3")
			    return "ScoreScreen";	
		     else if(currentScene == "QuestionMDSScene1")
				    return "QuestionMDSScene2";
		     else if(currentScene == "QuestionMDSScene2")
				    return "QuestionMDSScene3";	
		     else if(currentScene == "QuestionMDSScene3")
				    return "ScoreScreen";	
		return "ScoreSceen";
		
	}
	
    public void drawScenario() {
		
		GameImage backgroundBattle = new GameImage(("src/recursos/sprite/UnbGama.png"));
		Sprite missed = new Sprite("src/recursos/sprite/question/errou.png");
		Sprite right = new Sprite("src/recursos/sprite/question/acertou2.png");	
		int control = 0;

		
		
		while(true){
			backgroundBattle.draw();
			playerInstance.getScore();
			  if(answer){	
				  right.draw();	
			  } else{	
				  missed.draw();	
			  }
			window.update();
			control++;
			if(control == 3000){
				break;
			}
			

		}
    }

}

