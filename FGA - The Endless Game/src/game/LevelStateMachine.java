package game;

import java.util.ArrayList;

public class LevelStateMachine {

	private ArrayList<Scenario> scenarios = new ArrayList<Scenario>();
	private String actualScene;
	
	public void addScenario(Scenario scene) {
		
		scenarios.add(scene);
	}
	
	public void removeScenario(String scenarioName) {
		
		for( Scenario scene : scenarios) {
		
			if(scene.getScenarioName() == scenarioName) {
				scenarios.remove(scene);
			}
			
		}
		
	}
	
	public void run(String sceneName) {
		
		this.actualScene = sceneName;
		
		for( Scenario scene : scenarios) {
			
			if(sceneName == scene.getScenarioName()) {
				
				this.actualScene = scene.run();
				this.run(actualScene);
			
			}
			
		}
		
	}
}
