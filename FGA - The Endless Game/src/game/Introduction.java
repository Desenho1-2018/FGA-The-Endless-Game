package game;

import jplay.GameImage;
import jplay.Window;

public class Introduction extends Scenario {

	
	GameImage background = null;
	GameObject introText = null;
	GameObject introWelcome = null;
	
	String nextScenario = null;
	
	public Introduction(Window gameWindow, String name){
	  this.window = gameWindow;
	  this.scenarioName = name;
	  background = new GameImage(("src//recursos//sprite//introduction//intro_background.png"));
	  introText = new GameObject(0, 610, "src//recursos//sprite//introduction//introduction_text.png", 1, GameObjectType.OTHER);
	  introWelcome = new GameObject(0, 2180, "src//recursos//sprite//introduction//intro_welcome.png", 1, GameObjectType.OTHER);
		
	}

	
	@Override
	public String runScenario() {
		
		SoundPlayer.play("src//recursos//audio//star_wars_theme.mid");
		this.updateScenario();
		return this.nextScenario;
	
	}

	protected void updateScenario(){

		
		while(this.nextScenario == null) {
			if(this.introText.y > -1570) {
				background.draw();
				introText.draw();
				introWelcome.draw();
				this.introText.y = this.introText.y - 0.05;
				this.introWelcome.y = this.introWelcome.y - 0.05;
				window.update();
			
			} else {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				this.nextScenario = "LevelC1";
				SoundPlayer.stop();
			}
		
		}
	}
	
	
	
}

