package game;

import jplay.GameImage;
import jplay.Window;

public class Ending extends Scenario {
	
	GameImage background = null;
	GameObject endingText = null;
	GameObject endingCredits = null;
	
	String nextScenario = null;
	
	public Ending(Window gameWindow, String name){
	  this.window = gameWindow;
	  this.scenarioName = name;
	  background = new GameImage(("src//recursos//sprite//intro_background.png"));
	  endingText = new GameObject(0, 610, "src//recursos//sprite//ending_text.png", 1, GameObjectType.OTHER);
	  endingCredits = new GameObject(0, 2180, "src//recursos//sprite//ending_credits.png", 1, GameObjectType.OTHER);
		
	}

	
	@Override
	public String runScenario() {
		
		this.updateScenario();
		return this.nextScenario;
	
	}

	protected void updateScenario(){
		
		SoundPlayer.play("src//recursos//audio//sad_song.wav");
		
		while(this.nextScenario == null) {
			if(this.endingText.y > -1570) {
				background.draw();
				endingText.draw();
				endingCredits.draw();
				this.endingText.y = this.endingText.y - 0.03;
				this.endingCredits.y = this.endingCredits.y - 0.03;
				window.update();
			
			} else {
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				this.nextScenario = "Level1";
				SoundPlayer.stop();
			}
		
		}
	}

}
