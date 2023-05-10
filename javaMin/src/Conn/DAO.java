package Conn;

import java.util.Timer;
import java.util.TimerTask;

public class DAO {
	int count = 6;

	public void time() { // 타이머
		Timer m = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				if (count > 0) {
					System.out.println("[" + count + "0" + "초 남았습니다." + "]");
					count--;
				} else {
					System.out.println("실패");
					m.cancel();
				}
			}
		};
		m.schedule(task, 10 * 100, 10000);
	}//<-- time

}
