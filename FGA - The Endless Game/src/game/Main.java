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
		QuestionCalculo1 C1 = new QuestionCalculo1(gameWindow, "QuestionCalculo1Scene1", 1);
		QuestionCalculo1 C2 = new QuestionCalculo1(gameWindow, "QuestionCalculo1Scene2", 2);
		QuestionCalculo1 C3 = new QuestionCalculo1(gameWindow, "QuestionCalculo1Scene3", 3);
		Level1 level1 = new Level1(gameWindow, "Level1");
		LevelTCC levelTCC = new LevelTCC(gameWindow, "LevelTCC");
		PasswordMenu passmenu = new PasswordMenu(gameWindow, "PasswordMenu");
		ScoreScreen scorescreen = new ScoreScreen(gameWindow, "ScoreScreen");
		
		QuestionMDSScene MDS1 = new QuestionMDSScene(gameWindow, "QuestionMDSScene1", 1);
		QuestionMDSScene MDS2 = new QuestionMDSScene(gameWindow, "QuestionMDSScene2", 2);
		QuestionMDSScene MDS3 = new QuestionMDSScene(gameWindow, "QuestionMDSScene3", 3);
		
		LevelC1 LevelC1 = new LevelC1(gameWindow, "LevelC1");
		
		levelStateMachine.addScenario(startMenu);
		levelStateMachine.addScenario(passmenu);
		levelStateMachine.addScenario(finishScene);
		levelStateMachine.addScenario(introScene);
		levelStateMachine.addScenario(battle);
		levelStateMachine.addScenario(gameOver);
		levelStateMachine.addScenario(scorescreen);
		levelStateMachine.addScenario(C1);
		levelStateMachine.addScenario(C2);
		levelStateMachine.addScenario(C3);
		levelStateMachine.addScenario(level1);
		levelStateMachine.addScenario(levelTCC);
		levelStateMachine.addScenario(MDS1);
		levelStateMachine.addScenario(MDS2);
		levelStateMachine.addScenario(MDS3);
		levelStateMachine.addScenario(LevelC1);
	
		
		levelStateMachine.run("ScoreScreen");
	}

}
