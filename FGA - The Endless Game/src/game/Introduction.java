package game;

import jplay.GameImage;
import jplay.Parallax;
import jplay.ParallaxLayers;
import jplay.Window;

public class Introduction {
	
	private Window introductionWindow;
	
	GameImage background = new GameImage(("src/recursos/sprite/FGA.jpeg"));
	
	public Introduction(Window window){
		introductionWindow = window;
		
		runBackground0();
		runBackground1();
		runBackground2();
		runBackground3();
		runBackground4();
		runBackground5();
	}

	private void runBackground0(){
		
		int control = 0;
		
		GameImage background0 = new GameImage(("src/recursos/sprite/BemVindo.png"));
		
		while(true){
			background.draw();
			
			background0.draw();
		
			introductionWindow.update();
			control++;
			if(control>2000)
				break;
		}
		
	}
	
	private void runBackground1(){
		
		int control1 = 0;
		
		GameImage background1 = new GameImage(("src/recursos/sprite/Intro1.png"));
		
		while(true){
			background.draw();
			background1.draw();
			
			introductionWindow.update();
			control1++;
			if(control1>3300)
				break;
		}
	}
	
	private void runBackground2(){
		
		int control2 = 0;
		
		GameImage background2 = new GameImage(("src/recursos/sprite/Intro2.png"));
		
		while(true){
			background.draw();
			background2.draw();
			
			introductionWindow.update();
			control2++;
			if(control2>3300)
				break;
		}
	}
	
	private void runBackground3(){
		
		int control3 = 0;
		
		GameImage background3 = new GameImage(("src/recursos/sprite/Intro3.png"));
		
		while(true){
			background.draw();
			background3.draw();
			
			introductionWindow.update();
			control3++;
			if(control3>3300)
				break;
		}
	}
	
	private void runBackground4(){
		
		int control4 = 0;
		
		GameImage background4 = new GameImage(("src/recursos/sprite/Intro4.png"));
		
		while(true){
			background.draw();
			background4.draw();
			
			introductionWindow.update();
			control4++;
			if(control4>3300)
				break;
		}
	}
	
	private void runBackground5(){
		
		GameImage background5 = new GameImage(("src/recursos/sprite/Intro5.png"));
		
		while(true){
			background.draw();
			background5.draw();
			
			introductionWindow.update();
		}
	}
	
}
