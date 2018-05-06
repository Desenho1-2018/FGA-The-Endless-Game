package game;

import jplay.GameImage;
import jplay.Sprite;
import jplay.Window;

public class Battle extends Scenario {

	
	GameImage background = new GameImage(("src/recursos/sprite/UnbGama.png"));
	
	public Battle(Window gameWindow, String name){
	
	  this.window = gameWindow;
	  this.scenarioName = name;
	
	}
	
	@Override
	public String getScenarioName() {
		
		return this.scenarioName;
	}
	
	@Override
	public String runScenario() {
		
		drawScenario();
		
		return "FinishScene";
	
	}
	
    public void drawScenario() {
		
		GameImage backgroundBattle = new GameImage(("src/recursos/sprite/UnbGama.png"));
		Sprite professor = new Sprite("src/recursos/sprite/professor.png");
		Sprite student = new Sprite("src/recursos/sprite/universitario.png");
		Sprite battle = new Sprite("src/recursos/sprite/Batalha.png");
		Sprite note = new Sprite("src/recursos/sprite/nota.png");
		
		battle.x = 100;
		battle.y = 0;		
		professor.x = 0;
		professor.y = 300;		
		student.x = 700;
		student.y = 300;
		note.x = 350;
		note.y = 500;
		
		boolean answer = false;
		
		while(true){
			backgroundBattle.draw();
			battle.draw();
			professor.draw();
			student.draw();
			note.draw();
			
			collision(answer, professor, student, note);
			window.update();
		}
    }
	
    public void collision(boolean answer, Sprite professor, Sprite student, Sprite note){
	
	  Sprite wrong = new Sprite("src/recursos/sprite/errou.png");
	  Sprite correct = new Sprite("src/recursos/sprite/acertou.png");
	
	  wrong.x = 400;
	  wrong.y = 400;
	  correct.x = 400;
	  correct.y = 400;
	
	  if(answer == true){
		note.moveTo(professor.x, professor.y, 0.3);
		correct.draw();
	  } else{
		  note.moveTo(student.x, student.y, 0.3);
		  wrong.draw();
	  }
    }

}

