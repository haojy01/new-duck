package org.donald.duck.util.thread;


/**
 * join是Thread类的一个方法，启动线程后直接调用，即join()的作用是：“等待该线程终止”，这里需要理解的就是该线程是指的主线程等待子线程的终止。
 * 也就是在子线程调用了join()方法后面的代码，只有等到子线程结束了才能执行。
 * */
public class Thread3 implements Runnable {
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
		System.out.println(Thread.currentThread().getName() + "运行 结束");
	}

	public static void main(String[] args) throws InterruptedException {
		System.out.println("主线程运行开始");
		Thread3 my = new Thread3();
		Thread t1 = new Thread(my, "A");
		Thread t2 = new Thread(my, "B");
		Thread t3 = new Thread(my, "C");
		t1.start();
		t2.start();
		t3.start();
		t1.join();
		t2.join();
		t3.join();
		System.out.println("主线程运行结束");
	}
}
