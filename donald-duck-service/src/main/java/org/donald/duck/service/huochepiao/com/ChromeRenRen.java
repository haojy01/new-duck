package org.donald.duck.service.huochepiao.com;

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeRenRen {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/home/haojy/soft/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--no-sandbox");
		WebDriver driver = new ChromeDriver(options);
		
		/**
		 *  浏览器在request添加cookie要跟当前请求的URL是一个域的 ，webdriver 实例化浏览器的时候 默认给浏览器的URL是：data:.  所以你添加的cookie的域和当前URL不是一个域名下的，所以报错！
		 *  解决办法 ：
		 *  先get你的目标网站 在添加cookie保持域一致：
		 * */
		driver.get("http://www.renren.com/");
		for (Cookie cookie : ChromeRenRen.click("512273389@qq.com", "512273389")) {
			driver.manage().addCookie(cookie);

		}
		driver.manage().window().maximize();
		driver.get("http://www.renren.com/");
		String pageSource = driver.getPageSource();
		System.out.println(pageSource);
	}
	/**
	 * 模拟登录
	 */
	public static Set<Cookie> click(String username, String password) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/home/haojy/soft/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--no-sandbox");
		WebDriver driver = new ChromeDriver(options);
		driver.get("http://www.renren.com/");
		driver.findElement(By.xpath("//*[@id='email']")).clear();
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys(username);
		driver.findElement(By.xpath("//*[@id='password']")).clear();
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id='login']")).click();
		Thread.sleep(1000 * 10);
		Set<Cookie> cookies = driver.manage().getCookies();
		System.out.println("Cookie.size = " + cookies.size());
		driver.close();
		return cookies;
	}

}
