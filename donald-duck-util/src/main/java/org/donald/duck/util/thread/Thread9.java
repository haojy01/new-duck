package org.donald.duck.util.thread;

public class Thread9 extends Thread {

	public void run() {
		try {
			System.out.println("thread-name " + Thread.currentThread().getName()+" start");
			Thread.sleep(10000);
			System.out.println("thread-name " + Thread.currentThread().getName()+" end");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
