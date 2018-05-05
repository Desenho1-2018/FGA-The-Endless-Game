package game;

import jplay.GameImage;
import jplay.Keyboard;
import jplay.URL;
import jplay.Window;

public class Main {
	
	public static void main(String[] args){
		Window janela = new Window(800, 600);
		GameImage plano = new GameImage(("src//recursos//sprite//menu2.png"));
		Keyboard teclado = janela.getKeyboard();
		
		while(true){ 
			plano.draw();
			janela.update();
			
			if(teclado.keyDown(Keyboard.ENTER_KEY)){
				new Cenario1(janela); //chamando cenario passando a janela como parametro
				
			}
			
		}
	}
	
}
