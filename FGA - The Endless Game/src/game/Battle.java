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
		return scenarioName;
		
	}
	
    public void drawScenario() {
		
		GameImage backgroundBattle = new GameImage(("src/recursos/sprite/UnbGama.png"));
		Sprite professor = new Sprite("src/recursos/sprite/professor.png");
		Sprite student = new Sprite("src/recursos/sprite/universitario.png");
		Sprite battle = new Sprite("src/recursos/sprite/Batalha.png");
		Sprite note = new Sprite("src/recursos/sprite/nota.png");
		int control = 0;
		
		battle.x = 100;
		battle.y = 0;		
		professor.x = 0;
		professor.y = 300;		
		student.x = 700;
		student.y = 300;
		note.x = 350;
		note.y = 500;
		
		while(true){
			backgroundBattle.draw();
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
			}
				
		}
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
		  playerInstance.setScore(-1);
	  }
    }

}

