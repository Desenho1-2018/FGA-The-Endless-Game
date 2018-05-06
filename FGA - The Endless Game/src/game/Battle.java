package game;

import jplay.GameImage;
import jplay.Window;

public class Battle extends Scenario {

	
	GameImage background = new GameImage(("src/recursos/sprite/UnbGama.png"));
	
	public Battle(Window gameWindow, String name){
	
	  this.window = gameWindow;
	  this.scenarioName = name;
	
	}

	@Override
	public String runScenario() {
		
		runBackground0();
		
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
		
		boolean answer = true;
		
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
	
	
	private void runBackground0(){
		
		int control = 0;
		
		GameImage background0 = new GameImage(("src/recursos/sprite/BemVindo.png"));
		
		while(true){
			background.draw();
			
			background0.draw();
		
			window.update();
			control++;
			if(control>2000)
				break;
		}
		
	}
	
}

