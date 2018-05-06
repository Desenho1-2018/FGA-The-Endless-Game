package game;

import jplay.Window;

public class Main {
	
	public static void main(String[] args){
		Window gameWindow = new Window(800, 600);
		LevelStateMachine levelStateMachine = new LevelStateMachine();
		
		MainMenu startMenu = new MainMenu(gameWindow, "StartMenu");
		Encerrar finishScene = new Encerrar(gameWindow, "FinishScene");
		Introduction introScene = new Introduction(gameWindow, "IntroductionScene");
		Battle battleScene = new Battle(gameWindow, "BattleScene");
		Cenario1 cenario1 = new Cenario1(gameWindow, "Cenario1");
		
		levelStateMachine.addScenario(startMenu);
		levelStateMachine.addScenario(finishScene);
		levelStateMachine.addScenario(introScene);
		levelStateMachine.addScenario(battleScene);
		levelStateMachine.addScenario(cenario1);
		
		levelStateMachine.run("StartMenu");
		
	}
	
}
