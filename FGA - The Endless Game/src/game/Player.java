package game;

import jplay.Keyboard;
import jplay.Window;

public class Player extends CharacterParent{

	private double velocidade = 0.3;
	private int direcao = 3;
	private Keyboard playerKeyboard;
	private boolean movendo = false;
	
	
	
	public Player(int x, int y, Window gameWindow) { // parameters that set the player initial location
		
		super(("src//recursos//sprite//jogador2.png"), 20); // img and frame number
		this.x = x; // setting the x and y to the passed cordinates
		this.y = y;
		this.setTotalDuration(2000); //millisecconds
		this.initializeKeyboard(gameWindow);
		
	}
	
	public void mover(Window janela){ //public because it's being acessed in the scenario
		if(playerKeyboard == null){
			playerKeyboard = janela.getKeyboard(); // se nao tiver teclado adicionar um
			
		}
		
		if(playerKeyboard.keyDown(Keyboard.LEFT_KEY)){
			if(this.x >0){
				this.x -= velocidade; //evitando o jogador sair da tela
			}
			if(direcao !=1){
				setSequence(4,8); // definindo sprites esquerda
				direcao =1 ;
			} movendo = true;
		}else if(playerKeyboard.keyDown(Keyboard.RIGHT_KEY)){
			if(this.x < janela.getWidth() - 60 ){ // 60 pixeis do jogador
				this.x += velocidade; //evitando o jogador sair da tela
			}
			if(direcao !=2){
				setSequence(8,12); // definindo sprites direita
				direcao =2 ;
			} movendo = true;
		}else if(playerKeyboard.keyDown(Keyboard.UP_KEY)){
			
			if(this.y >0){
				this.y -= velocidade; //evitando o jogador sair da tela
			}
			if(direcao !=4){
				setSequence(12,16); // definindo sprites subindo
				direcao = 4 ;
			} movendo = true;
		}else if(playerKeyboard.keyDown(Keyboard.DOWN_KEY)){
			if(this.y < janela.getHeight() - 60){
				this.y += velocidade; //evitando o jogador sair da tela
			}
			if(direcao !=5){
				setSequence(0,4); // definindo sprites descendo
				direcao =5 ;
			} movendo = true;
			
		}
		if(movendo == true){
			update(); //updating the sprites
			movendo = false;
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
	
}