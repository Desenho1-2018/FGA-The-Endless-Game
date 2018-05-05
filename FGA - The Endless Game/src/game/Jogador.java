package game;

import jplay.Keyboard;
import jplay.Sprite;
import jplay.Window;

public class Jogador extends CharacterParent{

	private double velocidade = 0.9;
	private int direcao = 3;
	private Keyboard teclado;
	private boolean movendo = false;
	
	
	
	public Jogador(int x, int y) { // parameters that set the player initial location
		super(("src//recursos//sprite//jogador2.png"), 20); // img and frame number
		this.x = x; // setting the x and y to the passed cordinates
		this.y = y;
		this.setTotalDuration(2000); //millisecconds
		
		
	}
	
	public void mover(Window janela){ //public because it's being acessed in the scenario
		if(teclado == null){
			teclado = janela.getKeyboard(); // se nao tiver teclado adicionar um
			
		}
		
		if(teclado.keyDown(Keyboard.LEFT_KEY)){
			if(this.x >0){
				this.x -= velocidade; //evitando o jogador sair da tela
			}
			if(direcao !=1){
				setSequence(4,8); // definindo sprites esquerda
				direcao =1 ;
			} movendo = true;
		}else if(teclado.keyDown(Keyboard.RIGHT_KEY)){
			if(this.x < janela.getWidth() - 60 ){ // 60 pixeis do jogador
				this.x += velocidade; //evitando o jogador sair da tela
			}
			if(direcao !=2){
				setSequence(8,12); // definindo sprites direita
				direcao =2 ;
			} movendo = true;
		}else if(teclado.keyDown(Keyboard.UP_KEY)){
			
			if(this.y >0){
				this.y -= velocidade; //evitando o jogador sair da tela
			}
			if(direcao !=4){
				setSequence(12,16); // definindo sprites subindo
				direcao = 4 ;
			} movendo = true;
		}else if(teclado.keyDown(Keyboard.DOWN_KEY)){
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

}