package game;

import jplay.Sprite;

public class GameObject extends Sprite{
	
	private String gameObjectName = "";
	private String spritePath = "";
	
	public GameObject(int x, int y, String spritePath){
	
		super((spritePath), 1); // img and frame number
		this.spritePath = spritePath;
		this.x = x;
		this.y = y;
	
	}

	public void setGameObjectName(String name) {
		gameObjectName = name;
	}
	
	public String getGameObjectName() {
		return gameObjectName;
	}
	
	public void setSpritePath(String path) {
		spritePath = path;
	}
	

}


