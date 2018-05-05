package game;

import jplay.Window;

public class Main {
	
	public static void main(String[] args){
		Window gameWindow = new Window(800, 600);
		
		MainMenu startMenu = new MainMenu(gameWindow);
		//Encerrar finishScene = new Encerrar(gameWindow);
		//Introduction introScene = new Introduction(gameWindow);
		//Cenario1 cenario1 = new Cenario1(gameWindow);
		
		while(true){ 
			
			startMenu.run();			
		
		}
	}
	
}
