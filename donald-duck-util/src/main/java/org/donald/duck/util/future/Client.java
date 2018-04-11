package org.donald.duck.util.future;

public class Client {

	public Data request(final String string) {
		final FutureData futureData = new FutureData();

		/* 计算过程比较慢，单独放到一个线程中去 */
		new Thread(new Runnable() {

			public void run() {
				RealData realData = new RealData(string);
				futureData.setResultData(realData);
			}
		}).start();

		return futureData; // 先返回一个“假”的futureData
	}

	public static void main(String[] args) throws InterruptedException {
		Client client = new Client();
		System.out.println("准备计算结果");
		Data data = client.request("hello"); // 立即返回一个“假”的futureData，可以不用阻塞的等待数据返回，转而执行其它任务
		System.out.println("执行其它任务");
		Thread.sleep(3000); // 模拟执行其它任务
		System.out.println("数据的计算结果为：" + data.getResult());
	}
}
