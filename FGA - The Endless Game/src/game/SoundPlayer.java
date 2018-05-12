package game;

import jplay.Sound;

public class SoundPlayer {
	private static Sound musica;
	public static void play(String audio){
		stop();
		musica = new Sound(audio);
		SoundPlayer.musica.play();
		SoundPlayer.musica.setRepeat(true);
		
		
	}
	public static void stop(){
		if(SoundPlayer.musica != null){
			musica.stop();
		}
	}
}
