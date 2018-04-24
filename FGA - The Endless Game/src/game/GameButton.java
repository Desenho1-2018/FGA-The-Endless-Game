package game;

import jplay.Sprite;

public class GameButton extends Sprite {

	public String image_path;
	
	public GameButton(int x, int y, String image_path) {
		super((image_path), 20);
		this.x = x;
		this.y = y;
		
	}
	
	public void setButtonImage(String image_path) {
		this.image_path = image_path;
	}
	
	
}
