package game;

import jplay.GameImage;
import jplay.Window;

public class Encerrar {
	
	private Window encerrarWindow;
	
	GameImage background = new GameImage(("src/recursos/sprite/FGA1.jpeg"));
	
	public Encerrar(Window window){
		encerrarWindow = window;
		
		runBackground0();
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

}
