package game;

import jplay.Sprite;

public class GameObject extends Sprite{

	public GameObject(int x, int y){
	super(("src//recursos//tiles//asfalto.png"), 1); // img and frame number
	this.x = x;
	this.y = y;
	}
}
