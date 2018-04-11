package org.donald.duck.service.huochepiao.com;

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TiketOrder {

	public static WebDriver getDerive() {
		System.setProperty("webdriver.chrome.driver", "/home/haojy/soft/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--no-sandbox");
		WebDriver driver = new ChromeDriver(options);
		return driver;
	}

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = getDerive();
		/**
		 * 浏览器在request添加cookie要跟当前请求的URL是一个域的 ，webdriver 实例化浏览器的时候
		 * 默认给浏览器的URL是：data:. 所以你添加的cookie的域和当前URL不是一个域名下的，所以报错！ 解决办法 ：
		 * 先get你的目标网站 在添加cookie保持域一致：
		 */
		driver.get("https://kyfw.12306.cn");
		for (Cookie cookie : TiketOrder.click(driver,"512273389@qq.com", "hjy512273389")) {
			driver.manage().addCookie(cookie);

		}
		driver.manage().window().maximize();
		driver.get("https://kyfw.12306.cn/otn/index/initMy12306");
		String pageSource = driver.getPageSource();
		System.out.println(pageSource);
	}

	/**
	 * 模拟登录
	 * @param driver 
	 */
	public static Set<Cookie> click(WebDriver driver, String username, String password) throws InterruptedException {

		driver.get("https://kyfw.12306.cn/otn/login/init");
		driver.findElement(By.xpath("//*[@id='username']")).clear();
		driver.findElement(By.xpath("//*[@id='username']")).sendKeys(username);
		driver.findElement(By.xpath("//*[@id='password']")).clear();
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys(password);

		Thread.sleep(10000);

		driver.findElement(By.xpath("//*[@id='loginSub']")).click();
		Set<Cookie> cookies = driver.manage().getCookies();
		return cookies;
	}
}
