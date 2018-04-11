package org.donald.duck.util.thread;

public class Thread2 implements Runnable {
	private int count = 15;

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName() + "运行 count=" + count--);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		Thread2 my = new Thread2();
		Thread t1 = new Thread(my, "A");
		Thread t2 = new Thread(my, "B");
		Thread t3 = new Thread(my, "C");
		t1.start();
		t2.start();
		t3.start();
	}
}
