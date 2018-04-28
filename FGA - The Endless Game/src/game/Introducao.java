package game;

import jplay.GameImage;
import jplay.Parallax;
import jplay.ParallaxLayers;
import jplay.Window;

public class Introducao {
	
	int control, control1, control2, control3, control4, control5 = 0;
	private Window janela;
	
	GameImage background = new GameImage(("src/recursos/sprite/FGA.jpeg"));
	
	public Introducao(Window window){
		janela = window;
		
		run();
		run1();
		run2();
		run3();
		run4();
		run5();
	}

	private void run(){
		
		GameImage background0 = new GameImage(("src/recursos/sprite/BemVindo.png"));
		
		while(true){
			background.draw();
			
			background0.draw();
		
			janela.update();
			control++;
			if(control>2000)
				break;
		}
		
	}
	
	private void run1(){
		
		GameImage background1 = new GameImage(("src/recursos/sprite/Intro1.png"));
		
		while(true){
			background.draw();
			background1.draw();
			
			janela.update();
			control1++;
			if(control1>3300)
				break;
		}
	}
	
	private void run2(){
		
		GameImage background2 = new GameImage(("src/recursos/sprite/Intro2.png"));
		
		while(true){
			background.draw();
			background2.draw();
			
			janela.update();
			control2++;
			if(control2>3300)
				break;
		}
	}
	
	private void run3(){
		
		GameImage background3 = new GameImage(("src/recursos/sprite/Intro3.png"));
		
		while(true){
			background.draw();
			background3.draw();
			
			janela.update();
			control3++;
			if(control3>3300)
				break;
		}
	}
	
	private void run4(){
		
		GameImage background4 = new GameImage(("src/recursos/sprite/Intro4.png"));
		
		while(true){
			background.draw();
			background4.draw();
			
			janela.update();
			control4++;
			if(control4>3300)
				break;
		}
	}
	
	private void run5(){
		
		GameImage background5 = new GameImage(("src/recursos/sprite/Intro5.png"));
		
		while(true){
			background.draw();
			background5.draw();
			
			janela.update();
		}
	}
	
}

