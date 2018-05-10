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
		this.initializeObjects();
		
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
	
	
	private void initializeObjects() {
		
		String horizontalWall = "src//recursos//sprite//horizontal_wall.png";
		String verticalWall = "src//recursos//sprite//vertical_wall.png";
		String mp_tv = "src//recursos//sprite//mocap_tv.png";
		String mp_border_tv = "src//recursos//sprite//mocap_border_tv.png";
		String mp_table = "src//recursos//sprite//mocap_table.png";
		
		//Parede superiores
		GameObject parede1 = new GameObject(0, 0, horizontalWall, 1, GameObjectType.WALL);
		GameObject parede2 = new GameObject(0, 575, horizontalWall, 1, GameObjectType.WALL);
		GameObject parede3 = new GameObject(0, 25, verticalWall, 1, GameObjectType.WALL);
		GameObject parede4 = new GameObject(775, 25, verticalWall, 1, GameObjectType.WALL);

		//Tv
		GameObject mocap_tv = new GameObject(250, 25, mp_tv, 1, GameObjectType.WALL);
		GameObject mocap_border_tv = new GameObject(220, 25, mp_border_tv, 1, GameObjectType.WALL);
		
		//Mesas da esquerda
		GameObject mocap_table1 = new GameObject(99, 150, mp_table, 1, GameObjectType.WALL);
		GameObject mocap_table2 = new GameObject(99, 250, mp_table, 1, GameObjectType.WALL);
		GameObject mocap_table3 = new GameObject(99, 350, mp_table, 1, GameObjectType.WALL);
		GameObject mocap_table4 = new GameObject(99, 450, mp_table, 1, GameObjectType.WALL);
		
		//Mesas da direita
		GameObject mocap_table5 = new GameObject(500, 150, mp_table, 1, GameObjectType.WALL);
		GameObject mocap_table6 = new GameObject(500, 250, mp_table, 1, GameObjectType.WALL);
		GameObject mocap_table7 = new GameObject(500, 350, mp_table, 1, GameObjectType.WALL);
		GameObject mocap_table8 = new GameObject(500, 450, mp_table, 1, GameObjectType.WALL);
		
		this.addSceneObjects(parede1);
		this.addSceneObjects(parede2);
		this.addSceneObjects(parede3);
		this.addSceneObjects(parede4);
		this.addSceneObjects(mocap_tv);
		this.addSceneObjects(mocap_border_tv);
		this.addSceneObjects(mocap_table1);
		this.addSceneObjects(mocap_table2);
		this.addSceneObjects(mocap_table3);
		this.addSceneObjects(mocap_table4);
		this.addSceneObjects(mocap_table5);
		this.addSceneObjects(mocap_table6);
		this.addSceneObjects(mocap_table7);
		this.addSceneObjects(mocap_table8);

		
	}
}
