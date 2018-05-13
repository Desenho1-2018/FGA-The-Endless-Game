package game;

import jplay.Sprite;

public class GameObject extends Sprite{
	
	private String gameObjectName = "";
	@SuppressWarnings("unused")
	private String spritePath = "";
	private GameObjectType type;
	
	public GameObject(int x, int y, String spritePath, int spriteDivision, GameObjectType objtype){
	
		super((spritePath), spriteDivision); // img and frame number
		this.spritePath = spritePath;
		this.x = x;
		this.y = y;
		this.type = objtype;
	
	}
    public void setwidth(int big) {
    	this.width=big;
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
	
	public GameObjectType getType() {
		return type;
	}
	

}


