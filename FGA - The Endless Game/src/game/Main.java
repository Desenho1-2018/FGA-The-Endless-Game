package game;

import jplay.Window;

public class Main {
	
	public static void main(String[] args){
		Window gameWindow = new Window(800, 600);
		LevelStateMachine levelStateMachine = new LevelStateMachine();
		
		MainMenu startMenu = new MainMenu(gameWindow, "StartMenu");
		Encerrar finishScene = new Encerrar(gameWindow, "FinishScene");
		Introduction introScene = new Introduction(gameWindow, "IntroductionScene");
		Battle battle = new Battle(gameWindow, "BattleScene");
		Question question = new Question(gameWindow, "QuestionScene");
		Cenario1 cenario1 = new Cenario1(gameWindow, "Cenario1");
		
		levelStateMachine.addScenario(startMenu);
		levelStateMachine.addScenario(finishScene);
		levelStateMachine.addScenario(introScene);
		levelStateMachine.addScenario(battle);
		levelStateMachine.addScenario(question);
		levelStateMachine.addScenario(cenario1);
		
		levelStateMachine.run("QuestionScene");
		
	}
	
}
