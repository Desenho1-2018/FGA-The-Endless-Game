package game;

import jplay.Scene;
import jplay.Window;

public abstract class Scenario extends Scene {

		protected String scenarioName;
		protected Window window;
		
	
		public String run() {
		
			return "LEVEL_DONT_FOUND";
		
		};
		
		public String getScenarioName() {
			
			return this.scenarioName;
		}

}
