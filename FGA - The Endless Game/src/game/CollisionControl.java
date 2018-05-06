package game;

import jplay.GameObject;


public class CollisionControl {
	public boolean colisao(GameObject obj, GameObject obj2){
		if(obj.collided(obj2)){
			return true;
			
		}
		return false;
		
	}
	
}
