package Controller;

import javazoom.jl.player.MP3Player;

public class MusicController {
	MP3Player mp3 = new MP3Player();
	String path = "C:\\Users\\smhrd\\git\\old-people-and-children\\javaMin\\soundhint\\";
	
	public void play(String ans) {
		mp3.play(path+ans);
	}
}
