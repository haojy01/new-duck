package org.donald.duck.util.queue;

import java.util.concurrent.PriorityBlockingQueue;

/** 一个支持优先级排序的无界阻塞队列。 */
public class PriorityBlockingQueueTest {
	public static void main(String[] args) {
		PriorityBlockingQueue<String> p = new PriorityBlockingQueue<String>(2);
		p.add("1");
		p.add("2");
		p.add("3");
		System.out.println(p);

	}
}
