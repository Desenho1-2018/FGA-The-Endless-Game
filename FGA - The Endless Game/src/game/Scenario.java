package game;

import java.util.ArrayList;

import jplay.GameImage;
import jplay.Keyboard;
import jplay.Scene;
import jplay.Window;

public abstract class Scenario extends Scene {

		protected String scenarioName;
		protected Window window;
		protected GameImage background;
		protected Keyboard sceneKeyboard = null;
		protected String nextScenario =  null;
		protected String previousScenario = null;
		protected ArrayList<GameObject> sceneObjects = new ArrayList<GameObject>();
		
	
		//Depois que o level terminar o m�todo run deve retornar o nome da proxima 
		//fase cadastrada na LevelStateMachine
		public String runScenario() {
		
			return "LEVEL_DONT_FOUND";
		
		};
		
		
		//Dentro desse m�todo deve haver um while(condi��o) para rodar a fase
		//Dentro do while deve haver todos os objtos que devem ser desenhados
		//E no fim do while deve haver um .update();
		protected void updateScenario() {}
		
		
		//Toda fase possui comandos especificos, logo dentro desse m�todo
		//deve haver a implementa��o do teclado espec�fico da cena
		protected void initializeKeyboard() {
			 if(window != null) {
				   sceneKeyboard = window.getKeyboard();
				  } else {
				   System.out.println("The keyboard needs a window to run. The window cannot be null");
				  }
				  sceneKeyboard.setBehavior(Keyboard.DOWN_KEY, Keyboard.DETECT_EVERY_PRESS); 
				  sceneKeyboard.setBehavior(Keyboard.UP_KEY, Keyboard.DETECT_EVERY_PRESS); 
				  sceneKeyboard.setBehavior(Keyboard.LEFT_KEY, Keyboard.DETECT_EVERY_PRESS);
				  sceneKeyboard.setBehavior(Keyboard.RIGHT_KEY, Keyboard.DETECT_EVERY_PRESS);
			
		}
		
		
		//Desenha o background e os objetos presentes
		//na lsita de objetos
		protected void drawObjects() {
			
			background.draw();
			
			for( GameObject obj : sceneObjects ) {
				
				obj.draw();
				
			}
			
		}
		
		public String getScenarioName() {
			
			return this.scenarioName;
		}
		

		//Adiciona objetos na lista de objetos
		public void addSceneObjects(GameObject obj) {
			
			sceneObjects.add(obj);
			
		}
		
		//Remove objetos da lista de objetos
		public void removeSceneObjects(GameObject obj) {
			
			sceneObjects.remove(obj);			
		
		}
		
}
