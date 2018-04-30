package game;

import jplay.GameImage;
import jplay.Window;

public class Encerrar {
	
	private Window encerrarWindow;
	
	GameImage background = new GameImage(("src/recursos/sprite/FGA1.jpeg"));
	
	public Encerrar(Window window){
		encerrarWindow = window;
		
		runBackground0();
		runBackground1();
		runBackground2();
	}

	private void runBackground0(){
		
		int control = 0;
		
		GameImage background0 = new GameImage(("src/recursos/sprite/Encerrar.png"));
		
		while(true){
			background.draw();
			
			background0.draw();
		
			encerrarWindow.update();
			control++;
			if(control>2000)
				break;
		}
		
	}
	
	private void runBackground1(){
		
		int control1 = 0;
		
		GameImage background1 = new GameImage(("src/recursos/sprite/Encerrar1.png"));
		
		while(true){
			background.draw();
			background1.draw();
			
			encerrarWindow.update();
			control1++;
			if(control1>2000)
				break;
		}
	}
	
	private void runBackground2(){
		
		int control2 = 0;
		
		GameImage background2 = new GameImage(("src/recursos/sprite/Encerrar2.png"));
		
		while(true){
			background.draw();
			background2.draw();
			
			encerrarWindow.update();
			control2++;
			if(control2>5000)
				break;
		}
	}
	

}
