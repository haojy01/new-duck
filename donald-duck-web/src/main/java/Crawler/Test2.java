package Crawler;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

//react.js
//http://www.ruanyifeng.com/blog/2015/03/react.html

//https://www.cnblogs.com/TTyb/p/5784581.html
public class Test2 {
	public static void Get_Url(String url) {
		try {
			Document doc = Jsoup.connect(url)
					// .data("query", "Java")
					// .userAgent("头部")
					// .cookie("auth", "token")
					// .timeout(3000)
					// .post()
					.get();
			// 得到html的所有东西
			Element content = doc.getElementById("content");
			// 分离出html下<a>...</a>之间的所有东西
			//Elements links = content.getElementsByTag("a");
			 Elements links = doc.select("a[href]");

			for (Element link : links) {
				// 得到<a>...</a>里面的网址
				String linkHref = link.attr("href");
				// 得到<a>...</a>里面的汉字
				String linkText = link.text();
				System.out.println(linkText);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Get_Url("http://www.baidu.com");
	}
}