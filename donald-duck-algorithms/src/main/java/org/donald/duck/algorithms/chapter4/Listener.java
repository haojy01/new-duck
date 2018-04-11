package org.donald.duck.algorithms.chapter4;

import java.util.ArrayList;
import java.util.List;

public class Listener {

	private List<Thread> listener = new ArrayList<Thread>();

	public void addListener(Thread r) {

		listener.add(r);
	}

	public void fireStopSingal() {

		System.out.println("发送停止信号");
		for (Thread r : listener) {
			System.out.println("主线程停止线程" + r.getName());
			r.interrupt();
		}
	}

}
