package game;

import jplay.GameImage;
import jplay.Keyboard;
import jplay.Window;

public class LevelC1 extends Level {
	
	public LevelC1(Window gameWindow, String name) {
		
		this.window = gameWindow;
		this.scenarioName = name;
		this.background = new GameImage("src//recursos//sprite//LevelC1//ground_room.png");
		addPlayer(700,50,"src//recursos//sprite//jogador2.png", 20, window);
		this.initializeKeyboard();
	}

	@Override
	public String runScenario() {
		this.initializeKeyboard();
		this.initializeObjects();
		this.drawLevel();
		return nextScenario;
	}
	
	private void drawLevel() {
		
		SoundPlayer.play("src//recursos//audio//missionImpossible.mid");		
		
		while(this.nextScenario == null) {
			
			background.draw();
			this.drawObjects();
			playerInstance.draw();
			playerInstance.setCollisionType(this.playerCollision());
			playerInstance.move(window);
			playerTranstionToQuestion();
			window.update();
			
		}
		
	}
	
	@Override
	protected void initializeKeyboard(){
		
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
	
	@Override
	protected void initializeObjects() {
		
		String horizontalWall = "src//recursos//sprite//LevelC1//horizontal_wall.png";
		String verticalWall = "src//recursos//sprite//LevelC1//vertical_wall.png";
		String fga_table_rig = "src//recursos//sprite//LevelC1//fga_table_rig.png";
		String fga_table_lef = "src//recursos//sprite//LevelC1//fga_table_lef.png";
		String professor_table = "src//recursos//sprite//LevelC1//professor_table.png";
		String table_of_frame = "src//recursos//sprite//LevelC1//table_of_white_frame.png";
		String white_frame = "src//recursos//sprite//LevelC1//white_frame.png";
		
		GameObject rigTable = null;
		GameObject lefTable = null;
		
		GameObject horizontalWallT = new GameObject(0,0, horizontalWall,1, GameObjectType.WALL);
		GameObject horizontalWallB = new GameObject(0,575, horizontalWall,1,GameObjectType.WALL);
		GameObject verticalWallR = new GameObject(0,25, verticalWall,1,GameObjectType.WALL);
		GameObject verticalWallL = new GameObject(775,25, verticalWall,1,GameObjectType.WALL);
		GameObject whiteFrame = new GameObject(250,25, white_frame, 1, GameObjectType.WALL);
		GameObject whiteFrameTable = new GameObject(250,50, table_of_frame, 1, GameObjectType.TRANSITION);
		GameObject professorTable = new GameObject(25, 90, professor_table, 1, GameObjectType.WALL);
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 3; j++) {	
				rigTable = new GameObject((70 + 115 * j), 180 + (115 * i), fga_table_rig, 1, GameObjectType.WALL);
				lefTable = new GameObject((670 - 115 * j), 180 + (115 * i), fga_table_lef, 1, GameObjectType.WALL);
				this.addSceneObjects(rigTable);
				this.addSceneObjects(lefTable);
			}
		}
		
		this.addSceneObjects(horizontalWallT);
		this.addSceneObjects(horizontalWallB);
		this.addSceneObjects(verticalWallR);
		this.addSceneObjects(verticalWallL);
		this.addSceneObjects(whiteFrame);
		this.addSceneObjects(whiteFrameTable);
		this.addSceneObjects(professorTable);
		
	}
	
	private void playerTranstionToQuestion() {
		
		if(this.playerInstance.getCollisionType() == GameObjectType.TRANSITION) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.nextScenario = "QuestionCalculo1Scene1";
		}
		
	}
	
}
