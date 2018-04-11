package org.donald.duck.util.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Thread11 implements Runnable {
	Data data;

	public Thread11(Data data) {
		this.data = data;
	}

	public void run() {
		try {
			Thread.sleep(10000);
			data.setName("haojy");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();

		// 使用Callable+Future获取执行结果
		Data d = new Data();
		Thread11 task = new Thread11(d);
		Future<Data> submit = newCachedThreadPool.submit(task,d);
		// newCachedThreadPool.shutdown();
		System.out.println("线程池是否关闭．" + newCachedThreadPool.isShutdown());
		System.out.println("所有任务是否全部执行完成．" + newCachedThreadPool.isTerminated());
		System.out.println("是否执行完成： " + submit.isDone());
		System.out.println("取值： " + submit.get().getName());
		
		// 使用Callable+Future获取执行结果
		Future<String> submit2 = newCachedThreadPool.submit(task,"w");
		System.out.println("是否执行完成： " + submit2.isDone());
		System.out.println("取值： " + submit2.get());
	}
}
