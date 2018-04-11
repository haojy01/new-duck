package org.donald.duck.algorithms.chapter4;

public class Thread9 extends Thread {

	public void run() {
		try {
			System.out.println(Thread.currentThread().getName() + "doing");
			Thread.sleep(5000);
			System.out.println(Thread.currentThread().getName() + "end");
		} catch (InterruptedException e) {
			System.out.println(Thread.currentThread().getName() + "quit");
			e.printStackTrace();
		}
	}
}
