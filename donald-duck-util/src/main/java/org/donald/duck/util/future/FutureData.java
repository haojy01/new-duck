package org.donald.duck.util.future;

public class FutureData implements Data {
	RealData realData = null; // 对RealData的封装，代理了RealData
	boolean isReady = false; // 真实结果是否已经准备好

	public synchronized void setResultData(RealData realData) {
		if (isReady) {
			return;
		}
		this.realData = realData;
		isReady = true;
		notifyAll(); // realData已经被注入到了futureData中，通知getResult方法
	}

	public synchronized String getResult() throws InterruptedException {
		if (!isReady) {
			wait(); // 数据还未计算好，阻塞等待
		}
		return realData.getResult();
	}
}