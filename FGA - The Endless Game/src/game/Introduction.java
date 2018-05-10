package game;

import jplay.GameImage;
import jplay.Window;

public class Introduction extends Scenario {

	
	GameImage background = new GameImage(("src/recursos/sprite/FGA.jpeg"));
	GameObject introductionText = new GameObject(0, 610, "src//recursos//sprite//introduction_text.png", 1, GameObjectType.OTHER);
	String nextScenario = null;
	
	public Introduction(Window gameWindow, String name){
	  this.window = gameWindow;
	  this.scenarioName = name;
	  background = new GameImage(("src/recursos/sprite/FGA.jpeg"));
	  introductionText = new GameObject(0, 610, "src//recursos//sprite//introduction_text.png", 1, GameObjectType.OTHER);
		
	}

	
	@Override
	public String runScenario() {
		
		this.updateScenario();
		return this.nextScenario;
	
	}

	protected void updateScenario(){
		
		while(this.nextScenario == null) {
			if(this.introductionText.y > -1550) {
				background.draw();
				introductionText.draw();
				this.introductionText.y = this.introductionText.y - 0.07;
				window.update();
			
			} else {
				this.nextScenario = "Level1";
			}
		
		}
	}
	
	
	
}

