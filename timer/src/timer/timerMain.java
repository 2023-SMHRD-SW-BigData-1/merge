package timer;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ScheduledExecutorService;

public class timerMain {
	public static int count;

	public static void main(String[] args) {
		count = 5;
		Timer m = new Timer();
		System.out.print("Count Down : ");
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				if (count > 0) {
					System.out.print(count + "..  ");
					count--;
				} else {
					System.out.println("실패");
					m.cancel();
				}
			}
		};
		m.schedule(task, 10 * 200, 1000);

	}// <-- main

}// <-- class
