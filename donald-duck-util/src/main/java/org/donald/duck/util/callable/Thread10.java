package org.donald.duck.util.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Thread10 implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {

		int sum = 0;
		for (int i = 0; i < 10; i++) {
			sum += i;
		}
		Thread.sleep(10000);
		return sum;
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
		
		//使用Callable+Future获取执行结果
		Thread10 task = new Thread10();
		Future<Integer> submit = newCachedThreadPool.submit(task);
		//newCachedThreadPool.shutdown();
		System.out.println("线程池是否关闭．" + newCachedThreadPool.isShutdown());
		System.out.println("所有任务是否全部执行完成．" + newCachedThreadPool.isTerminated());
		System.out.println("是否执行完成： " + submit.isDone());
		Integer integer=2;
		try {
			//会抛异常，不会返回值．
			integer = submit.get(100, TimeUnit.MILLISECONDS);
		} catch (TimeoutException e) {
		}
		System.out.println("等一秒取值  " + integer);
		System.out.println("取值  " + submit.get());
		System.out.println("是否执行完成  "+submit.isDone());
		
		//阻塞期间不在接受其他任务．
		//newCachedThreadPool.awaitTermination(10, TimeUnit.SECONDS);
		// 使用Callable+FutureTask获取执行结果
		Thread10 task1 = new Thread10();
		FutureTask<Integer> futureTask=new FutureTask<Integer>(task1); 
		newCachedThreadPool.submit(futureTask);
		System.out.println("是否执行完成： " + futureTask.isDone());
		System.out.println("取值  " + futureTask.get());
		System.out.println("取值  " + futureTask.get());
		System.out.println("是否执行完成  "+futureTask.isDone());
	}
}
