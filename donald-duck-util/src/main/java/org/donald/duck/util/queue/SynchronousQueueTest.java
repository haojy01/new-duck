package org.donald.duck.util.queue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.Semaphore;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.donald.duck.util.thread.Thread9;

public class SynchronousQueueTest {

	public static void main(String[] args) {

		ExecutorService executor = new ThreadPoolExecutor(2, 4, 60, TimeUnit.SECONDS, new SynchronousQueue<Runnable>(),
				new RejectedExecutionHandler() {
					private Semaphore semap = new Semaphore(1);

					@Override
					public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
						try {
							semap.acquire();
							System.out.println("当前线程" + executor.getThreadFactory().newThread(r).getName());
							System.out.println("当前线程数量" + executor.getActiveCount());
							System.out.println("当前队列的长度　" + executor.getQueue().size());
							semap.release();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				});

		for (int i = 0; i < 10; i++) {
			Thread9 task = new Thread9();
			task.setName("thread+" + i);
			executor.submit(task);
		}
	}
}
