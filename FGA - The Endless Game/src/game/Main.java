package game;

import jplay.Window;

public class Main {

	public static void main(String[] args){
		Window gameWindow = new Window(800, 600);
		LevelStateMachine levelStateMachine = new LevelStateMachine();

		MainMenu startMenu = new MainMenu(gameWindow, "StartMenu");
		Ending finishScene = new Ending(gameWindow, "FinishScene");
		Introduction introScene = new Introduction(gameWindow, "IntroductionScene");
		Battle battle = new Battle(gameWindow, "BattleScene");
		GameOverMenu gameOver = new GameOverMenu(gameWindow, "GameOver");
		QuestionCalculo1 C1 = new QuestionCalculo1(gameWindow, "QuestionCalculo1Scene", 1);
		Level1 level1 = new Level1(gameWindow, "Level1");
		LevelTCC levelTCC = new LevelTCC(gameWindow, "LevelTCC");
		PasswordMenu passmenu = new PasswordMenu(gameWindow, "PasswordMenu");
		
		QuestionMDSScene MDS = new QuestionMDSScene(gameWindow, "QuestionMDSScene", 1);
		
		LevelC1 LevelC1 = new LevelC1(gameWindow, "LevelC1");
		
		levelStateMachine.addScenario(startMenu);
		levelStateMachine.addScenario(passmenu);
		levelStateMachine.addScenario(finishScene);
		levelStateMachine.addScenario(introScene);
		levelStateMachine.addScenario(battle);
		levelStateMachine.addScenario(gameOver);
		levelStateMachine.addScenario(C1);
		levelStateMachine.addScenario(level1);
		levelStateMachine.addScenario(levelTCC);
		levelStateMachine.addScenario(MDS);
		levelStateMachine.addScenario(LevelC1);
		levelStateMachine.run("LevelC1");
	}

}
