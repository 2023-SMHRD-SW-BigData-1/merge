package Controller;

import javazoom.jl.player.MP3Player;

public class MusicController {
	MP3Player mp3 = new MP3Player();
	String path = "C:\\Users\\smhrd\\Desktop\\workspace\\daeun\\soundhint\\감바스알아히요.mp3";
	
	public void play(String ans) {
		mp3.play(path);
	}
}
