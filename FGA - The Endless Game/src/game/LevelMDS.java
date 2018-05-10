package game;

import jplay.GameImage;
import jplay.Keyboard;
import jplay.Window;

public class LevelMDS extends Level {

	public LevelMDS(Window gameWindow, String name) {
		
		this.window = gameWindow;
		this.scenarioName = name;
		this.background = new GameImage("src//recursos//sprite//ground_mds.png");
		addPlayer(300,300,"src//recursos/sprite//jogador2.png", 20, window);
		this.initializeKeyboard();
		this.initializeWalls();
		
	}
	
	
	@Override
	public String runScenario() {
		
		this.drawLevel();
		return nextScenario;
		
	}
	
	private void drawLevel() {
		
		while(this.nextScenario == null) {
			
			background.draw();
			this.drawObjects();
			playerInstance.draw();
			playerInstance.setCollisionType(this.playerCollision());
			playerInstance.move(window);
			window.update();
			
		}
		
	}
	
	@Override
	protected void initializeKeyboard() {
		if(window != null) {
			sceneKeyboard = window.getKeyboard();
		} else {
			System.out.println("The keyboard needs a window to run. The window cannot be null");
		}
		sceneKeyboard.setBehavior(Keyboard.DOWN_KEY, Keyboard.DETECT_EVERY_PRESS); 
		sceneKeyboard.setBehavior(Keyboard.UP_KEY, Keyboard.DETECT_EVERY_PRESS); 
		sceneKeyboard.setBehavior(Keyboard.LEFT_KEY, Keyboard.DETECT_EVERY_PRESS);
		sceneKeyboard.setBehavior(Keyboard.RIGHT_KEY, Keyboard.DETECT_EVERY_PRESS);
	}
	
	
	private void initializeWalls() {
		
		String horizontalWall = "src//recursos//sprite//horizontal_wall.png";
		String verticalWall = "src//recursos//sprite//vertical_wall.png";
		
		//Parede superiores
		GameObject parede1 = new GameObject(0, 0, horizontalWall, 1, GameObjectType.WALL);
		GameObject parede2 = new GameObject(0, 575, horizontalWall, 1, GameObjectType.WALL);
		GameObject parede3 = new GameObject(0, 25, verticalWall, 1, GameObjectType.WALL);
		GameObject parede4 = new GameObject(775, 25, verticalWall, 1, GameObjectType.WALL);

		
		this.addSceneObjects(parede1);
		this.addSceneObjects(parede2);
		this.addSceneObjects(parede3);
		this.addSceneObjects(parede4);

		
	}
}
