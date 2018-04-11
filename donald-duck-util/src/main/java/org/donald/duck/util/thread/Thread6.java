package org.donald.duck.util.thread;

public class Thread6 extends Thread {

	private Resource r;

	public Thread6(Resource r) {
		super();
		this.r = r;
	}

	public void run() {
		try {
			r.methodA();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
