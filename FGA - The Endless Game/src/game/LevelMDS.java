package game;

import jplay.GameImage;
import jplay.Keyboard;
import jplay.Window;

public class LevelMDS extends Level {

	 private GameObject arrow = null;
	 private NPC npc1, npc2, npc3;
	 private Scenario cena;
	 private int option = 0, numberQuestion;
	 
	 public LevelMDS(Window gameWindow, String name){

		  this.window = gameWindow;
		  this.scenarioName = name;
		  this.background = new GameImage("src//recursos//sprite//ground_mds.png");
		  		  
		  addPlayer(400, 500, "src//recursos//sprite//jogador2.png", 20, window);
		  
		  npc1 = new NPC(300,300);
		  npc2 = new NPC(400,400);
		  npc3 = new NPC(500,500);
		  this.initializeKeyboard();
		  this.initializeObjects();
		  
		  if(numberQuestion == 1){
				GameObject limit = new GameObject(50, 50, "src//recursos//sprite//question//limite.jpeg", 1, GameObjectType.OTHER);
				GameObject answer0 = new GameObject(100, 300, "src//recursos//sprite//question//27.png", 1, GameObjectType.OTHER);
				GameObject answer1 = new GameObject(100, 350, "src//recursos//sprite//question//36.png", 1, GameObjectType.OTHER);
				GameObject answer2 = new GameObject(100, 400, "src//recursos//sprite//question//45.png", 1, GameObjectType.OTHER);
				GameObject answer3 = new GameObject(100, 450, "src//recursos//sprite//question//54.png", 1, GameObjectType.OTHER);
				
				this.addSceneObjects(answer0);
				this.addSceneObjects(answer1);
				this.addSceneObjects(answer2);
				this.addSceneObjects(answer3);
				this.addSceneObjects(limit);	
			}
			
			else if(numberQuestion == 2){
				GameObject derivada = new GameObject(50, 50, "src//recursos//sprite//question//derivada.jpeg", 1, GameObjectType.OTHER);
				GameObject answer0 = new GameObject(100, 300, "src//recursos//sprite//question//d3.png", 1, GameObjectType.OTHER);
				GameObject answer1 = new GameObject(100, 350, "src//recursos//sprite//question//d2.png", 1, GameObjectType.OTHER);
				GameObject answer2 = new GameObject(100, 400, "src//recursos//sprite//question//d1.png", 1, GameObjectType.OTHER);
				GameObject answer3 = new GameObject(100, 450, "src//recursos//sprite//question//d4.png", 1, GameObjectType.OTHER);
				
				this.addSceneObjects(answer0);
				this.addSceneObjects(answer1);
				this.addSceneObjects(answer2);
				this.addSceneObjects(answer3);
				this.addSceneObjects(derivada);	
			}
			
			else if(numberQuestion == 3){
				GameObject integral = new GameObject(50, 50, "src//recursos//sprite//question//integral.jpeg", 1, GameObjectType.OTHER);
				GameObject answer0 = new GameObject(100, 300, "src//recursos//sprite//question//0.png", 1, GameObjectType.OTHER);
				GameObject answer1 = new GameObject(100, 350, "src//recursos//sprite//question//1.png", 1, GameObjectType.OTHER);
				GameObject answer2 = new GameObject(100, 400, "src//recursos//sprite//question//2.png", 1, GameObjectType.OTHER);
				GameObject answer3 = new GameObject(100, 450, "src//recursos//sprite//question//3.png", 1, GameObjectType.OTHER);
				
				this.addSceneObjects(answer0);
				this.addSceneObjects(answer1);
				this.addSceneObjects(answer2);
				this.addSceneObjects(answer3);
				this.addSceneObjects(integral);	
			}
	  
	 }

	 @Override
	 public String runScenario(){

		  initializeKeyboard();
		  this.drawLevel();
		  return "NEXT_LEVEL";

	 }

	 private void drawLevel() {
		 while(true){

		   this.drawObjects();
	
		   playerInstance.draw();
		 
		   npc1.draw();
		   npc2.draw();
		   npc3.draw();
		      
		   playerInstance.setCollisionType(this.playerCollision());
		   npc1.perseguir(playerInstance.x, playerInstance.y);
		   //player.caminho(cena , parede);
		   npc1.caminho(cena, npc3);
		   npc1.caminho(cena, npc2);		   
		   
		   npc2.perseguir(playerInstance.x, playerInstance.y);
		   //player.caminho(cena , parede);
		   npc2.caminho(cena, npc1);
		   npc2.caminho(cena, npc3);
		   
		   npc3.perseguir(playerInstance.x, playerInstance.y);
		   //player.caminho(cena , parede);
		   npc3.caminho(cena, npc1);
		   npc3.caminho(cena, npc2);
		   
		   playerInstance.move(window);
		   
		   if (playerInstance.collided(npc1) == true){
			   System.out.println("1\n");
			   npc1.fall();
			   npc1.velocidade = 0.0;
			   runBackground0();
		   }
		   
		   else if (playerInstance.collided(npc2) == true){
			   System.out.println("2\n");
			   npc2.fall();
			   npc2.velocidade = 0.0;
			   runBackground1();
		   }
		   
		   else if (playerInstance.collided(npc3) == true){
			   System.out.println("3\n");
			   npc3.fall();
			   npc3.velocidade = 0.0;
			   runBackground2();
		   }
		   
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
	 
	 private void runBackground0(){
			
			int control = 0;
			
			GameImage background0 = new GameImage(("src/recursos/sprite/lousaGIT.jpg"));
			GameObject start_button = new GameObject(300, 300, "src//recursos//sprite//iniciar_button.png", 1, GameObjectType.OTHER);
			GameObject passworld_button = new GameObject(300, 350, "src//recursos//sprite//passworld_button.png", 1,GameObjectType.OTHER);
			arrow = new GameObject(250, 300, "src//recursos//sprite//arrow_button.png", 1, GameObjectType.OTHER);
			
			while(true){
				
				background0.draw();
				start_button.draw();
				passworld_button.draw();
				arrow.draw();
				moveArrow();
				selectOption();
			
				window.update();
				control++;
				if(control>2000)
					break;
			}
			
		}
	 
	 private void runBackground1(){
			
			int control = 0;
			
			GameImage background0 = new GameImage(("src/recursos/sprite/lousaR1.jpg"));
			
			while(true){
				
				background0.draw();
			
				window.update();
				control++;
				if(control>2000)
					break;
			}
			
		}
	 
	 private void runBackground2(){
			
			int control = 0;
			
			GameImage background0 = new GameImage(("src/recursos/sprite/lousaR2.jpg"));
			
			while(true){
				
				background0.draw();
			
				window.update();
				control++;
				if(control>2000)
					break;
			}
			
		}
		
	 private void moveArrow() {
			
			if(sceneKeyboard.keyDown(Keyboard.DOWN_KEY)) {
				if(arrow.y <= 325) {
					arrow.y = arrow.y + 50;
					option = 1;
				} else {
					arrow.y = arrow.y;
				}
				
			}
			
			if(sceneKeyboard.keyDown(Keyboard.UP_KEY)) {
				if(arrow.y >= 325) {
					arrow.y = arrow.y - 50;
					option = 0;
				} else {
					arrow.y = arrow.y;
				}
				
			}
			
		}
		
		
		private void selectOption() {
			
			if(sceneKeyboard.keyDown(Keyboard.ENTER_KEY)) {

				if(option == 0) {
					nextScenario = "IntroductionScene";
				} else if (option == 1) {
					nextScenario = "FinishScene";
				}
				
			}
			

		}

}

