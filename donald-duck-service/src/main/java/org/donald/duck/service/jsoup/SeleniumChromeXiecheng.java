package org.donald.duck.service.jsoup;

import java.util.concurrent.TimeUnit;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class SeleniumChromeXiecheng {

	// https://www.cnblogs.com/test-my/p/5942387.html
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/home/haojy/soft/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--no-sandbox");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		driver.get("http://flights.ctrip.com/booking/bjs-ckg-day-1.html?ddate1=2017-11-30");

		Actions action = new Actions(driver);
		action.clickAndHold();
		for (int i = 0; i < 1000; i++) {
			action.sendKeys(Keys.DOWN).perform();
		}
		String html = driver.getPageSource();
		Document document = Jsoup.parse(html);
		Elements select = document.select("#J_flightlist2");
		Elements list = select.select("div[id~=^flight_]");

		for (Element temp : list) {
			Elements table = temp.select("table").select("tbody").select("tr");
			System.out.println(table.text());
		}
	}
}
