package game;

import jplay.GameImage;
import jplay.Sprite;
import jplay.Window;
import game.GameButton;

public class Reintegracao {
	static Window janela = new Window(800, 600);
	static GameImage background = new GameImage("src//recursos//sprite//reint.png");
	static Sprite numbers = new Sprite("src//recursos//sprite//continue");
	static GameButton continue_button = new GameButton(240, 400, "src//recursos//sprite//continuebutton1.png");
	
	public static void main(String[] args) {
		int count = 9;

		
		numbers.x = 350;
		numbers.y = 230;
		
		
		
		for (int i = 0; i <= count; ++i) {
			numbers.loadImage("src//recursos//sprite//continue//num" + String.valueOf(count - i) + ".png");
			background.draw();
			continue_button.draw();
			numbers.draw();
			janela.update();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("Não foi possível abrir a tela de Reintegração");
				e.printStackTrace();
			}
		}
		
		janela.exit();


    }
	
	
}


