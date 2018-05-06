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
	public String run() {
		
		drawScenario();
		
		return "FinishScene";
	
	}
	
	
	public void drawScenario() {
		
		GameImage backgroundBattle = new GameImage(("src/recursos/sprite/UnbGama.png"));
		Sprite professor = new Sprite("src/recursos/sprite/professor.png");
		Sprite student = new Sprite("src/recursos/sprite/universitario.png");
		Sprite battle = new Sprite("src/recursos/sprite/Batalha.png");
		
		battle.x = 100;
		battle.y = 0;		
		professor.x = 0;
		professor.y = 300;		
		student.x = 700;
		student.y = 300;
		
		while(true){
			
			backgroundBattle.draw();
			battle.draw();
			professor.draw();
			student.draw();
			window.update();
		}
	}
	
	@Override
	public String getScenarioName() {
		
		return this.scenarioName;
	}
	
}

