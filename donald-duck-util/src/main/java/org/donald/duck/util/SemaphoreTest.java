package org.donald.duck.util;

import java.util.concurrent.Semaphore;

/**
 * Semaphore 是基于一个计数的信号量，可以设定一个阈值，基于此，多个线程竞争获取许可信号量
 * 
 */
public class SemaphoreTest {

	private Semaphore semap = new Semaphore(2);

	public void method() {
		try {
			semap.acquire();
			System.out.println(Thread.currentThread().getName());
			Thread.sleep(5000);
			;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		semap.release();
	}

	public static void main(String[] args) {

		/*
		 * SemaphoreTest a = new SemaphoreTest(); MyThread b1 = new MyThread(a);
		 * MyThread b2 = new MyThread(a); MyThread b3 = new MyThread(a);
		 * b1.start(); b2.start(); b3.start();
		 */

		int i = 0;
		int a[] = new int[] { 1, 2, 3, 4, 5, 6, 7, 8 };
		System.out.println(a[i++]);
		System.out.println(i);
	}
}
