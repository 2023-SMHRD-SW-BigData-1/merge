package Conn;

import java.util.Timer;
import java.util.TimerTask;

public class DAO {
	int countmain = 6;
	int countfirst = 5;
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
	}//<-- time

	public void TimeFirst() {
		Timer m = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				if (countfirst > 0) {
					System.out.println("[ " + countfirst + " ]");
					countfirst--;
				} else {
					System.out.println("시작!");
					countfirst = 5;
					m.cancel();
				}
			}
		};
		m.schedule(task, 0, 1000);
	}//<-- TimeFirst
		
	
}
