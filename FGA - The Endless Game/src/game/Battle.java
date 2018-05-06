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
	public String run() {
		
		drawScenario();
		
		return "FinishScene";
	
	}
	
	
	public void drawScenario() {
		
		GameImage backgroundBattle = new GameImage(("src/recursos/sprite/UnbGama.png"));
		
		while(true){
			backgroundBattle.draw();
			window.update();
		}
	}
	
	@Override
	public String getScenarioName() {
		
		return this.scenarioName;
	}
	
}

