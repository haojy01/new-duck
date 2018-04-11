package org.donald.duck.service.jsoup;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class SeleniumTest {

	// https://www.cnblogs.com/test-my/p/5942387.html
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/home/haojy/soft/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--no-sandbox");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		driver.get("https://www.baidu.com");
		//driver.findElement(By.id("kw")).sendKeys("hahhah ");
		//driver.findElement(By.id("su")).click();
		// 关闭并退出浏览器
		//driver.findElements(By.partialLinkText(linkText));
		List<WebElement> findElements = driver.findElements(By.linkText("hao123"));
		for(WebElement temp :findElements ){
			temp.click();
			System.out.println("开始后退");
			driver.navigate().back();
		}
		Thread.sleep(1000);
		System.out.println("开始前进");
		driver.navigate().forward();
		System.out.println("开始刷新");
		driver.navigate().refresh();
		Thread.sleep(1000);
		System.out.println("鼠标悬停");
		Actions action = new Actions(driver);
		//action.clickAndHold(driver.findElement(By.xpath("//*[@id='head-wise']/div/a[1]")));
		Thread.sleep(1000);
		action.click(driver.findElement(By.linkText("登录")));
		
		driver.findElement(By.id("TANGRAM__PSP_10__userName")).clear();
		driver.findElement(By.id("TANGRAM__PSP_10__userName")).sendKeys("haojiuyuan");
		
		driver.findElement(By.id("TANGRAM__PSP_10__password")).clear();
		driver.findElement(By.id("TANGRAM__PSP_10__password")).sendKeys("1324124132");
		
		//driver.findElement(By.xpath("//*[@id='head-wise']/div/a[1]")).ac;
		
		//13.滚动页面至某元素出现
		/*JavascriptExecutor js = (JavascriptExecutor) driver;  
		js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.XX));   */
		
		/*action.clickAndHold();
		for(int i=0;i<20;i++){
			Thread.sleep(500);
			System.out.println("模拟键盘按down");
			action.sendKeys(Keys.DOWN).perform();// 按下 Ctrl 键
		}*/
	}
}
