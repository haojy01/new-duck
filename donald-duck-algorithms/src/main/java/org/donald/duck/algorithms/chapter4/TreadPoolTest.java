package org.donald.duck.algorithms.chapter4;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TreadPoolTest {
	public static void main(String[] args) throws InterruptedException {
		Listener listener = new Listener();

		ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 3, 200, TimeUnit.MINUTES,
				new ArrayBlockingQueue<Runnable>(6), new RejectedExecutionHandler() {
					@Override
					public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
						System.out.println("执行拒绝策略");
					}
				});
		for (int i = 0; i < 10; i++) {
			Thread9 task = new Thread9();
			task.setName("" + i);
			listener.addListener(task);
			//executor.execute(task);
			task.start();
			
			// Thread.sleep(1000);
			// System.out.println("线程池worker" + " " +
			// executor.getActiveCount());
			// System.out.println("线程池队里大小" + " " + executor.getQueue().size());
		}

		System.out.println("任务已经添加完毕");

		listener.fireStopSingal();
	}
}
