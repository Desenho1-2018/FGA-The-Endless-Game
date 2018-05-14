package game;

import jplay.GameImage;
import jplay.Sprite;
import jplay.Window;

public class Battle extends Level {

	public static boolean answer;
	public static String currentScene;
<<<<<<< HEAD

	GameImage background = new GameImage(("src/recursos/sprite/UnbGama.png"));

	public Battle(Window gameWindow, String name) {
		this.window = gameWindow;
		this.scenarioName = name;
=======
	GameImage background = new GameImage(("src/recursos/sprite/UnbGama.png"));
	
	public Battle(Window gameWindow, String name){
	  this.window = gameWindow;
	  this.scenarioName = name;
	  this.addPlayer(700,50,"src//recursos//sprite//jogador2.png", 20, window);
>>>>>>> c18e99357190d6439289e98ee4a50ffbe6a1f1d6
	}

	public Battle(boolean answer, String currentScene) {
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

		if (currentScene == "QuestionCalculo1Scene1")
			return "QuestionCalculo1Scene2";
<<<<<<< HEAD
		else if (currentScene == "QuestionCalculo1Scene2")
			return "QuestionCalculo1Scene3";
		else if (currentScene == "QuestionCalculo1Scene3")
			return "QuestionMDSScene1";
		else if (currentScene == "QuestionMDSScene1")
			return "QuestionMDSScene2";
		else if (currentScene == "QuestionMDSScene2")
			return "QuestionMDSScene3";
		return scenarioName;

=======
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
		
>>>>>>> c18e99357190d6439289e98ee4a50ffbe6a1f1d6
	}

	public void drawScenario() {

		GameImage backgroundBattle = new GameImage(("src/recursos/sprite/UnbGama.png"));
		Sprite missed = new Sprite("src/recursos/sprite/question/errou.png");
		Sprite right = new Sprite("src/recursos/sprite/question/acertou2.png");

		while (true) {
			backgroundBattle.draw();
<<<<<<< HEAD
			if (answer) {
				right.draw();
			} else {
				missed.draw();
=======
			battle.draw();
			professor.draw();
			student.draw();
			note.draw();
			playerInstance.getScore();
			collision(professor, student, note);
			window.update();
			
			control++;
			if(control == 3000){
				break;
>>>>>>> c18e99357190d6439289e98ee4a50ffbe6a1f1d6
			}

			window.update();

		}
<<<<<<< HEAD
	}
=======
    }
	
    public void collision(Sprite professor, Sprite student, Sprite note){
	
	  Sprite wrong = new Sprite("src/recursos/sprite/errou.png");
	  Sprite correct = new Sprite("src/recursos/sprite/acertou.png");
	
	  wrong.x = 400;
	  wrong.y = 400;
	  correct.x = 400;
	  correct.y = 400;
	  
	  if(answer){
		note.moveTo(professor.x, professor.y+70, 0.5);
		correct.draw();
		
	  } else{
		  note.moveTo(student.x, student.y+50, 0.5);
		  wrong.draw();
	  }
    }
>>>>>>> c18e99357190d6439289e98ee4a50ffbe6a1f1d6

}
