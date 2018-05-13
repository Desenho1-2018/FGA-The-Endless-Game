package game;

import jplay.Keyboard;
import jplay.Window;

public class Player extends GameObject{

	public static int score = 3;
	private double speed = 0.3;
	private int direction = 3;
	private Keyboard playerKeyboard;
	private boolean isMoving = false;
	private static Player instancePlayer = null;
	private GameObjectType collisionType = null;
	private String previousLevel = null;
	
	
	private Player(int x, int y, String spritePath, int spriteDivision, Window gameWindow) { // parameters that set the player initial location
		
		super(x, y, spritePath, spriteDivision, GameObjectType.PLAYER); // img and frame number
		this.x = x; // setting the x and y to the passed cordinates
		this.y = y;
		this.setTotalDuration(2000); //millisecconds
		
	}
	
	public void move(Window janela){ //public because it's being acessed in the scenario
		
		System.out.println(collisionType);
		
		if(collisionType != GameObjectType.WALL) {
			if(playerKeyboard == null){
				playerKeyboard = janela.getKeyboard(); // se nao tiver teclado adicionar um
				
			}
			
			if(playerKeyboard.keyDown(Keyboard.LEFT_KEY)){
				if(this.x >0){
					this.x -= speed; //evitando o jogador sair da tela
				}
				if(direction !=1){
					setSequence(4,8); // definindo sprites esquerda
					direction =1 ;
				} isMoving = true;
			}else if(playerKeyboard.keyDown(Keyboard.RIGHT_KEY)){
				if(this.x < janela.getWidth() - 60 ){ // 60 pixeis do jogador
					this.x += speed; //evitando o jogador sair da tela
				}
				if(direction !=2){
					setSequence(8,12); // definindo sprites direita
					direction =2 ;
				} isMoving = true;
			}else if(playerKeyboard.keyDown(Keyboard.UP_KEY)){
				
				if(this.y >0){
					this.y -= speed; //evitando o jogador sair da tela
				}
				if(direction !=3){
					setSequence(12,16); // definindo sprites subindo
					direction = 3 ;
				} isMoving = true;
			}else if(playerKeyboard.keyDown(Keyboard.DOWN_KEY)){
				if(this.y < janela.getHeight() - 60){
					this.y += speed; //evitando o jogador sair da tela
				}
				if(direction !=4){
					setSequence(0,4); // definindo sprites descendo
					direction =4 ;
				} isMoving = true;
				
			}
			if(isMoving == true){
				update(); //updating the sprites
				isMoving = false;
			}
		} else {
			if(direction == 1) {
				this.x = this.x + speed;
			} else if(direction == 2) {
				this.x = this.x - speed;				
			} else if(direction == 3) {
				this.y = this.y + speed;				
			} else if(direction == 4) {
				this.y = this.y - speed;				
			}
		}
	
	}
	
	
	//metodo singleton
	public static Player getPlayerInstance(int posX, int posY, String spritePath,  int spriteDivision, Window gameWindow){
		
		if(instancePlayer == null) {
			
			instancePlayer = new Player(posX, posY, spritePath, spriteDivision, gameWindow);
			return instancePlayer;
		} else {
			instancePlayer.x = posX;
			instancePlayer.y = posY;
			return instancePlayer;
			
		}
		
	}

	
	public void setCollisionType(GameObjectType cType) {
		this.collisionType = cType;
	}
	
	public GameObjectType getCollisionType() {
		return this.collisionType;
	}
	
	public int getScore(){
		return score;
		
	}
	
	public void setScore(int sc){
		this.score = sc;
	}
	
	public String getPreviousLevel() {
		return this.previousLevel;
	}
	
	public void setPreviousLevel(String level) {
		this.previousLevel = level;
	}
	
}