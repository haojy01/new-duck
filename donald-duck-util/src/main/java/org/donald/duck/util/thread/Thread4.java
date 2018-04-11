package org.donald.duck.util.thread;

import java.util.concurrent.Semaphore;

/**
 * 
 * ③yield():暂停当前正在执行的线程对象，并执行其他线程。 Thread.yield()方法作用是：暂停当前正在执行的线程对象，并执行其他线程。
 * yield()应该做的是让当前运行线程回到可运行状态，以允许具有相同优先级的其他线程获得运行机会。
 * 因此，使用yield()的目的是让相同优先级的线程之间能适当的轮转执行。
 * 但是，实际中无法保证yield()达到让步目的，因为让步的线程还有可能被线程调度程序再次选中。
 * 
 * sleep()和yield()的区别
 * sleep()和yield()的区别):sleep()使当前线程进入停滞状态，所以执行sleep()的线程在指定的时间内肯定不会被执行；
 * yield()只是使当前线程重新回到可执行状态，所以执行yield()的线程有可能在进入到可执行状态后马上又被执行。并且不会释放锁资源
 * sleep 方法使当前运行中的线程睡眼一段时间，进入不可运行状态，这段时间的长短是由程序设定的，yield 方法使当前线程让出 CPU 占有权，但让出的时间是不可设定的。
 * 实际上，yield()方法对应了如下操作：先检测当前是否有相同优先级的线程处于同可运行状态，如有，则把 CPU  的占有权交给此线程，
 * 否则，继续运行原来的线程。所以yield()方法称为“退让”，它把运行机会让给了同等优先级的其他线程
 * 另外，sleep 方法允许较低优先级的线程获得运行机会，但 yield()方法执行时，当前线程仍处在可运行状态，
 * 所以，不可能让出较低优先级的线程些时获得 CPU 占有权。在一个运行系统中，如果较高优先级的线程没有调用 sleep 方法，又没有受到 I\O 阻塞，
 * 那么，较低优先级线程只能等待所有较高优先级的线程运行结束，才有机会运行
 */
public class Thread4 extends Thread {
	private int count = 15;
	private Semaphore semap = new Semaphore(1);
	@SuppressWarnings("static-access")
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName() + "运行 count=" + count-- +", i = "+i);
			if (i == 2) {
				try {
					semap.acquire();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				this.yield();
				System.out.println(Thread.currentThread().getName()+"让步");
				semap.release();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread4 my = new Thread4();
		Thread t1 = new Thread(my, "A");
		Thread t2 = new Thread(my, "B");
		Thread t3 = new Thread(my, "C");
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.MIN_PRIORITY);
		t1.start();
		t2.start();
		t3.start();
	}
}
