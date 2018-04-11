package Crawler;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

//react.js
//http://www.ruanyifeng.com/blog/2015/03/react.html

//https://www.cnblogs.com/TTyb/p/5784581.html
public class Test1 {
	public static void Get_Url(String url) {
		try {
			Document doc = Jsoup.connect(url)
					// .data("query", "Java")
					// .userAgent("头部")
					// .cookie("auth", "token")
					// .timeout(3000)
					// .post()
					.get();
			System.out.println(doc);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Get_Url("http://www.baidu.com");
	}
}