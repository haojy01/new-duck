package org.donald.duck.util.thread;

import java.util.Arrays;

/**
 * 
 * synchronized关键字的作用域有二种： 1）是某个对象实例内，synchronized
 * aMethod(){}可以防止多个线程同时访问这个对象的synchronized方法（如果一个对象有多个synchronized方法，只要一个线程访问了其中的一个synchronized方法，
 * 其它线程不能同时访问这个对象中任何一个synchronized方法）。这时，不同的对象实例的synchronized方法是不相干扰的。也就是说，其它线程照样可以同时访问相同类的另一个对象实例中的synchronized方法；
 * 2）是某个类的范围，synchronized static aStaticMethod{}防止多个线程同时访问这个类中的synchronized
 * static 方法。它可以对类的所有对象实例起作用。
 * 2、除了方法前用synchronized关键字，synchronized关键字还可以用于方法中的某个区块中，表示只对这个区块的资源实行互斥访问。用法是:
 * synchronized(this)}，它的作用域是当前对象；
 * 3、synchronized关键字是不能继承的，也就是说，基类的方法synchronized f(){} 在继承类中并不自动是synchronized
 * f(){}，而是变成了f(){}。 继承类需要你显式的指定它的某个方法为synchronized方法；
 */

public class Resource {

	private String[] lock = new String[] { "123", "1232" };

	public String[] getLock() {
		synchronized (lock) {
			return lock;
		}
		
	}

	public void setLock(String[] lock) {
		synchronized (lock) {
			this.lock = lock;
		}
	}

	public void methodC() throws InterruptedException {
		synchronized (lock) {
			System.out.println("1 lock.size = " + lock.length);
			Thread.sleep(10000);
			System.out.println("2 lock.size = " + lock.length);
		}
	}

	public synchronized void methodA() throws InterruptedException {
		System.out.println(Thread.currentThread().getName() + "methodA");
		methodB();
		Thread.sleep(10000);
	}

	public synchronized void methodB() throws InterruptedException {
		System.out.println(Thread.currentThread().getName() + "methodB");
	}

	public static void main(String[] args) throws InterruptedException {

		Resource r = new Resource();
		Thread7 t7 = new Thread7(r);
		t7.setName("t7");
		Thread6 t6 = new Thread6(r);
		t6.setName("t6");
		t6.start();
		Thread.sleep(100);
		t7.start();

		Resource r1 = new Resource();
		Thread7 t8 = new Thread7(r1);
		t8.setName("t8");
		t8.start();

		Thread8 t9 = new Thread8(r1);
		t9.start();
		Thread.sleep(100);
		System.out.println(Arrays.asList(r1.lock));

	}
}
