package game;

import java.awt.Color;
import java.awt.Font;

import jplay.GameImage;
import jplay.Keyboard;
import jplay.Time;
import jplay.Window;

public class LevelTCC extends Level {

	String horizontalWall = "src//recursos//sprite//LevelC1//horizontal_wall.png";
	String verticalWall = "src//recursos//sprite//LevelC1//vertical_wall.png";
	
	GameObject book = new GameObject(150, 200, "src//recursos//sprite//livro.gif", 1, GameObjectType.REFERENCE_ITEM);
	GameObject canudo = new GameObject(660, 500, "src//recursos//sprite//canudol.gif", 1,
			GameObjectType.REFERENCE_ITEM);
	GameObject coffee = new GameObject(550, 80, "src//recursos//sprite//coffe.gif", 1, GameObjectType.REFERENCE_ITEM);
	Time tempo = new Time(640, 50, false);
	GameObject fga_table_rig0 = new GameObject(600, 500, "src//recursos//sprite//LevelC1//fga_table_rig.png", 1,
			GameObjectType.WALL);
	GameObject fga_table_rig1 = new GameObject(650, 450, "src//recursos//sprite//LevelC1//fga_table_rig.png", 1,
			GameObjectType.WALL);
	GameObject fga_table_rig2 = new GameObject(600, 80, "src//recursos//sprite//LevelC1//fga_table_rig.png", 1,
			GameObjectType.WALL);
	GameObject fga_table_rig3 = new GameObject(550, 130, "src//recursos//sprite//LevelC1//fga_table_rig.png", 1,
			GameObjectType.WALL);
	GameObject fga_table_rig4 = new GameObject(200, 200, "src//recursos//sprite//LevelC1//fga_table_rig.png", 1,
			GameObjectType.WALL);
	GameObject fga_table_rig5 = new GameObject(150, 250, "src//recursos//sprite//LevelC1//fga_table_rig.png", 1,
			GameObjectType.WALL);
	GameObject professor_table = new GameObject(350, 300, "src//recursos//sprite//LevelC1//professor_table.png", 1,
			GameObjectType.WALL);
	GameObject horizontalWallT = new GameObject(0,0, horizontalWall,1, GameObjectType.WALL);
	GameObject horizontalWallB = new GameObject(0,575, horizontalWall,1,GameObjectType.WALL);
	GameObject verticalWallR = new GameObject(0,25, verticalWall,1,GameObjectType.WALL);
	GameObject verticalWallL = new GameObject(775,25, verticalWall,1,GameObjectType.WALL);

	public LevelTCC(Window gameWindow, String name) {

		this.window = gameWindow;
		this.scenarioName = name;
		this.background = new GameImage("src//recursos//tiles/planofundo.png");
		addPlayer(100, 100, "src//recursos//sprite//jogador2.png", 20, window);
		this.addSceneObjects(book);
		this.addSceneObjects(canudo);
		this.addSceneObjects(coffee);
		this.addSceneObjects(fga_table_rig0);
		this.addSceneObjects(fga_table_rig1);
		this.addSceneObjects(fga_table_rig2);
		this.addSceneObjects(fga_table_rig3);
		this.addSceneObjects(fga_table_rig4);
		this.addSceneObjects(fga_table_rig5);
		this.addSceneObjects(professor_table);
		this.addSceneObjects(horizontalWallT);
		this.addSceneObjects(horizontalWallB);
		this.addSceneObjects(verticalWallR);
		this.addSceneObjects(verticalWallL);

	}

	@Override
	public String runScenario() {

		initializeKeyboard();
		this.drawLevel();
		return nextScenario;

	}

	private void drawLevel() {
		boolean coletaItem1 = false;
		boolean coletaItem2 = false;
		boolean coletaItem3 = false;
		
		tempo.setColor(Color.WHITE);
		tempo.setFont(new Font("sansserif", Font.TRUETYPE_FONT, 15));
		tempo.setTime(0, 0, 30);

		while (this.nextScenario == null) {
			background.draw();
			tempo.draw("Time: ");
			book.draw();
			canudo.draw();
			coffee.draw();
			playerInstance.draw();
			playerInstance.setCollisionType(this.playerCollision());
			fga_table_rig0.draw();
			fga_table_rig1.draw();
			fga_table_rig2.draw();
			fga_table_rig3.draw();
			fga_table_rig4.draw();
			fga_table_rig5.draw();
			playerInstance.draw();
			professor_table.draw();
			playerInstance.move(window);
			window.update();
				
				if (playerInstance.collided(book)) {
					book.hide();
					coletaItem1 = true;
				}
				if (playerInstance.collided(canudo)) {
					canudo.hide();
					coletaItem2 = true;
				}
				if (playerInstance.collided(coffee)) {
					coffee.hide();
					coletaItem3 = true;
				}
				if(coletaItem1 == true && coletaItem2 == true && coletaItem3 == true) {
					nextScenario = "FinishScene";
				}

				if(tempo.getSecond() == 0){
					nextScenario = "Reintegracao";
				}

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
}