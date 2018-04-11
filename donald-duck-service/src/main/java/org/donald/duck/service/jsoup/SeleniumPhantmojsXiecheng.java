package org.donald.duck.service.jsoup;

import java.util.concurrent.TimeUnit;

import org.donald.duck.bean.DonaldDuckFlyPlan;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.alibaba.fastjson.JSONObject;

public class SeleniumPhantmojsXiecheng {

	public static void main(String[] args) throws InterruptedException {

		DesiredCapabilities dcaps = new DesiredCapabilities();
		dcaps.setCapability("acceptSslCerts", true);
		dcaps.setCapability("takesScreenshot", true);
		dcaps.setCapability("cssSelectorsEnabled", true);
		dcaps.setJavascriptEnabled(true);
		dcaps.setCapability("phantomjs.binary.path",
				"/home/haojy/soft/_phantmojs/phantomjs-2.1.1-linux-x86_64/bin/phantomjs");
		PhantomJSDriver driver = new PhantomJSDriver(dcaps);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		driver.get("http://flights.ctrip.com/booking/bjs-ckg-day-1.html?ddate1=2017-11-30");
		for (int i = 0; i < 10; i++) {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()",
					driver.findElement(By.id("flight_pagefooter")));
		}
		String html = driver.getPageSource();
		Document document = Jsoup.parse(html);
		Elements select = document.select("#J_flightlist2");
		Elements list = select.select("div[id~=^flight_]");
		for (Element temp : list) {
			Elements tr = temp.select("table").select("tbody").select("tr");

			DonaldDuckFlyPlan fly = new DonaldDuckFlyPlan();
			// 航空公司
			fly.setAirlineCompany(tr.select("td.logo").select("div.clearfix.J_flight_no").select("strong").text());
			// 飞机编号
			Elements flight_no = tr.select("td.logo").select("div.clearfix.J_flight_no").select("span");
			fly.setAircraftNo(flight_no.text());
			// 飞机型号
			fly.setAircraftType(tr.select("td.logo").select("div.low_text").select("span").text());
			// 备注（共享）
			fly.setRemark(flight_no.select("span.shared_flight").attr("data-content"));
			// 起飞时间
			fly.setTakeOffTime(tr.select("td.right").select("div:nth-child(1)").select("strong").text());
			// 起飞机场
			fly.setTakeOffAirport(tr.select("td.right").select("div:nth-child(2)").text());
			// 经停
			fly.setGoThrough(tr.select("td.center").select("div.stopover").text());
			// 降落时间
			fly.setLaddingTime(tr.select("td.left").select("div:nth-child(1)").select("strong").text());
			// 落地机场
			fly.setLandlingAirport(tr.select("td.left").select("div:nth-child(2)").text());
			// 准点率
			fly.setPunctualityRate(tr.select("td.service").select("div").select("span").text());
			// 礼品
			fly.setGift(tr.select("td.label").text());
			// 最低价格
			fly.setFloorPrice(tr.select("td.price").text());

			System.out.println(JSONObject.toJSONString(fly));
		}
	}
}
