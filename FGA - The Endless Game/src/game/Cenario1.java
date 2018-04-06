package game;

import jplay.Scene;
import jplay.Window;
import jplay.URL;

public class Cenario1 {
	
	private Window janela;
	private Scene  cena;
	private Jogador jogador;
	
	public Cenario1(Window window){
		
		janela = window;
		cena = new Scene();
		cena.loadFromFile(URL.scenario("Cenario1.scn")); //carregando o arquivo com o mapa
		jogador = new Jogador(640, 350);
		run();
	}

	private void run(){
		while(true){
			cena.draw();
			jogador.draw();
			jogador.mover();
			janela.update();
			
		}
	}
}
