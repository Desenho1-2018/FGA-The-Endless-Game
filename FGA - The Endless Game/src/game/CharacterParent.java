package game;

import java.awt.Point;
import java.util.Vector;

import jplay.GameObject;
import jplay.Scene;
import jplay.Sprite;
import jplay.TileInfo;

public class CharacterParent extends Sprite{
	

	protected int direcao = 3;
	protected double velocidade = 1;
	protected boolean movendo = false;
	
	
	public CharacterParent(String fileName, int numFrames) {
		super(fileName, numFrames);
		// TODO Auto-generated constructor stub
	}
		

}
