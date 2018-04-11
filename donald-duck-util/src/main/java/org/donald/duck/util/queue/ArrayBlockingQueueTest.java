package org.donald.duck.util.queue;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;

/** 一个由数组结构组成的有界阻塞队列。 */
//先进先出
public class ArrayBlockingQueueTest {
	public static void main(String[] args) throws InterruptedException {
		ArrayBlockingQueue<String> blockQueue = new ArrayBlockingQueue<String>(2);
		boolean add = blockQueue.add("1");
		System.out.println("添加结果" + add + "表尾添加元素，成功返回true，失败抛出异常" + blockQueue);
		boolean offer = blockQueue.offer("2");
		System.out.println("添加结果" + offer + "表尾添加元素，成功返回true，失败返回false　" + blockQueue);
		// blockQueue.add("1");
		blockQueue.offer("1");
		//blockQueue.put("2"); 对尾添加元素，满了的话阻塞
		String peek = blockQueue.peek(); //如果队列为空返回null
		System.out.println("获取表头(不会删除)" + peek + "  blockQueue elements" + blockQueue);
		blockQueue.element();//同peek，如果队列为空抛出异常
		int remainingCapacity = blockQueue.remainingCapacity();
		System.out.println("剩余容量 " + remainingCapacity);
		boolean remove = blockQueue.remove("1");
		System.out.println("删除元素" + remove + "  blockQueue elements" + blockQueue);
		blockQueue.clear();
		System.out.println("清除队列  blockQueue elements" + blockQueue);
		blockQueue.contains("1");
		ArrayList<String> a = new ArrayList<String>();
		blockQueue.add("1");
		blockQueue.drainTo(a);
		System.out.println("元素迁移" + blockQueue + "" + a);
		blockQueue.add("2");
		blockQueue.add("3");
		blockQueue.drainTo(a,1);
		System.out.println("限制个数的元素迁移" + blockQueue + "" + a);
		blockQueue.poll(); //返回头元素并且从队列中删除，如果队列为空，返回null
		blockQueue.clear();
		blockQueue.take(); //返回头元素，如果队列为空，阻塞
		
		System.out.println("'q");
	}
}
