package game;

import jplay.Sprite;

public class Jogador extends Sprite{

	public Jogador(int x, int y) { // parameters that set the player initial location
		super(("src//recursos//sprite//jogador.png"), 20); // img and frame number
		this.x = x; // setting the x and y to the passed cordinates
		this.y = y;
		
	}
	
	public void mover(){ //public because it's being acessed in the scenario
		moveX(0.9); //moving the player and passing the speed movement
		moveY(0.9);
		
	}

}
