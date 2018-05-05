package game;

import jplay.GameImage;
//import jplay.Scene;
import jplay.Window;

public class Cenario1 {
	
	private Window janela;
	//private Scene  cena;
	private Jogador jogador;
	GameImage backGround = new GameImage("src//recursos//tiles//background_default.png");
	private GameObject wall;
	private NPC npc;
	public Cenario1(Window window){
		
		janela = window;
		//cena = new Scene();
		//cena.loadFromFile(URL.scenario("Cenario1.scn")); //carregando o arquivo com o mapa
		jogador = new Jogador(640, 350);
		wall = new GameObject(630,340);
		npc = new NPC(300,300);
		run();
	}

	private void run(){
		
		while(true){
			//cena.draw();
			backGround.draw();
			jogador.draw();
			npc.perseguir(jogador.x, jogador.y);
			npc.draw();
			wall.draw();
			jogador.mover(janela);
			janela.update();
			
		}
		
	}
}
