package org.donald.duck.util.thread;

public class Thread8 extends Thread {
	private Resource r;

	public Thread8(Resource r) {
		super();
		this.r = r;
	}

	public void run() {
		try {
			r.methodC();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
