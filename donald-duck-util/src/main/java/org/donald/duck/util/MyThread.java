package org.donald.duck.util;

public class MyThread extends Thread {

	SemaphoreTest test;

	public MyThread(SemaphoreTest test) {

		this.test = test;
	}

	@Override
	public void run() {
		test.method();
	}
}
