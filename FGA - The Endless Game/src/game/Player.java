package game;

import jplay.Keyboard;
import jplay.Window;

public class Player extends CharacterParent{

	private double speed = 0.3;
	private int direction = 3;
	private Keyboard playerKeyboard;
	private boolean isMoving = false;
	private static Player instancePlayer = null;
	
	
	
	
	private Player(int x, int y, Window gameWindow) { // parameters that set the player initial location
		
		super(("src//recursos//sprite//jogador2.png"), 20); // img and frame number
		this.x = x; // setting the x and y to the passed cordinates
		this.y = y;
		this.setTotalDuration(2000); //millisecconds
		this.initializeKeyboard(gameWindow);
		
	}
	
	public void move(Window janela){ //public because it's being acessed in the scenario
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
			if(direction !=4){
				setSequence(12,16); // definindo sprites subindo
				direction = 4 ;
			} isMoving = true;
		}else if(playerKeyboard.keyDown(Keyboard.DOWN_KEY)){
			if(this.y < janela.getHeight() - 60){
				this.y += speed; //evitando o jogador sair da tela
			}
			if(direction !=5){
				setSequence(0,4); // definindo sprites descendo
				direction =5 ;
			} isMoving = true;
			
		}
		if(isMoving == true){
			update(); //updating the sprites
			isMoving = false;
		}
	}

	private void initializeKeyboard(Window window){
		
		if(window != null) {
			playerKeyboard = window.getKeyboard();
		} else {
			System.out.println("The keyboard needs a window to run. The window cannot be null");
		}
		playerKeyboard.setBehavior(Keyboard.DOWN_KEY, Keyboard.DETECT_EVERY_PRESS); 
		playerKeyboard.setBehavior(Keyboard.UP_KEY, Keyboard.DETECT_EVERY_PRESS); 
		playerKeyboard.setBehavior(Keyboard.LEFT_KEY, Keyboard.DETECT_EVERY_PRESS);
		playerKeyboard.setBehavior(Keyboard.RIGHT_KEY, Keyboard.DETECT_EVERY_PRESS);
	
	}
	
	
	//metodo singleton
	public static Player getPlayerInstance(int posX, int posY, Window gameWindow) {
		
		if(instancePlayer == null) {
			
			instancePlayer = new Player(posX, posY, gameWindow);
			return instancePlayer;
		} else {
			instancePlayer.x = posX;
			instancePlayer.y = posY;
			return instancePlayer;
			
		}
		
	}

	
}