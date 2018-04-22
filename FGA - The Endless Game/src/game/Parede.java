package game;
import jplay.Sprite;

public class Parede extends Sprite {
	int x;
    int y;
    int width;
    int heigh;
  
	public Parede(String nome,int x,int y, int width, int heigh) { 
	    	super(("src//recursos//sprite//parede(1).png"), 1);
	        this.x=x;
	        this.y=y;
	        this.width=width;
	        this.heigh=heigh;
	}
	
}
