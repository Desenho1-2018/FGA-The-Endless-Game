package game;

import jplay.GameImage;
import jplay.Window;

public class Introducao {
	
	private Window janela;
	GameImage background = new GameImage(("src//recursos//sprite//UnbGama.jpg"));
	
	public Introducao(Window window){
		janela = window;
		run();
	}

	private void run(){
		
		while(true){
			background.draw();
			janela.update();
			
		}
		
	}
}

