package game;

import jplay.Scene;

import jplay.Window;
import jplay.URL;

public class Cenario1 {
	
	private Window janela;
	private Scene  cena;
	private Jogador jogador;
	private Parede parede1;
	
	public Cenario1(Window window){
		
		janela = window;
		cena = new Scene();
		cena.loadFromFile(URL.scenario("Cenario1.scn")); //carregando o arquivo com o mapa
		jogador = new Jogador(640, 350);
		parede1=new Parede("abigail",2,2,200,400);
		run();
	}

	private void run(){
		while(true){
			cena.draw();
			jogador.draw();
			parede1.draw();
			jogador.mover();
			janela.update();
			
		}
	}
}
