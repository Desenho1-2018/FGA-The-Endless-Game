package game;

import jplay.Window;

public abstract class Level extends Scenario {
	
	/**
	 * Esta classe é responsável por, somente, as fases do jogo.
	 * A sua diferença de scenario é que ela possui o método de
	 * colisão com todas as paredes do jogo.
	 */
	
	
	//Player
	protected Player playerInstance = null;
	
	
	//Metodos
	protected void addPlayer(int posX, int posY, String spritePath,  int spriteDivision, Window gameWindow){
		this.playerInstance = Player.getPlayerInstance(posX, posY, spritePath, spriteDivision, gameWindow);
	}
	
	protected void colissionWithPlayer() {}
	

}
