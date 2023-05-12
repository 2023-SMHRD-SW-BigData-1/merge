package Conn;

import java.util.Timer;
import java.util.TimerTask;

public class DAO {
	int countmain = 6;
	int countfirst;

	public void timeMain() { // 타이머
		Timer m = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				if (countmain > 0) {
					System.out.println("[" + countmain + "0" + "초 남았습니다." + "]");
					countmain--;
				} else {
					System.out.println("실패");
					countmain = 6;
					m.cancel();
				}
			}
		};
		m.schedule(task, 10 * 100, 10000);
	}// <-- time

	
		
	

	
	
	
}
