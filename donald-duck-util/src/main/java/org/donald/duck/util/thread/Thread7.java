package org.donald.duck.util.thread;

public class Thread7 extends Thread {
	private Resource r;

	public Thread7(Resource r) {
		super();
		this.r = r;
	}

	public void run() {
		try {
			r.methodB();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
