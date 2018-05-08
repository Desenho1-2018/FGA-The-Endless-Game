package game;

public abstract class Level extends Scenario {
	
	/**
	 * Esta classe é responsável por, somente, as fases do jogo.
	 * A sua diferença de scenario é que ela possui o método de
	 * colisão com todas as paredes do jogo.
	 */
	
	
	//Player
	protected Player gamer = null;
	
	
	//Metodos
	protected void colissionWithPlayer() {}
	

}
