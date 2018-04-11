package org.donald.duck.service.jsoup;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class First {
	public static void main(String[] args) throws IOException {
		// 获取编辑推荐页
		Document document = Jsoup.connect("http://blog.csdn.net/u014798883/article/details/54909951")
				// 模拟火狐浏览器
				.userAgent("Mozilla/4.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0)").get();
		//#rasss
		// #rasss > dl:nth-child(1) > dd > h2 > a
		System.out.println(document.toString());
		Elements url = document.select("#rasss");
		System.out.println(url);
		//Jsoup.parse("html");
		/*for (Element question : url) {
			// 输出href后的值，即主页上每个关注问题的链接
			String URL = question.attr("abs:href");
			// 下载问题链接指向的页面
			Document document2 = Jsoup.connect(URL)
					.userAgent("Mozilla/4.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0)").get();
			// 问题
			Elements title = document2.select("#zh-question-title").select("h2").select("a");
			// 问题描述
			Elements detail = document2.select("#zh-question-detail");
			// 回答
			Elements answer = document2.select("#zh-question-answer-wrap")
					.select("div.zm-item-rich-text.expandable.js-collapse-body")
					.select("div.zm-editable-content.clearfix");
			System.out.println("\n" + "链接：" + URL + "\n" + "标题：" + title.text() + "\n" + "问题描述：" + detail.text() + "\n"
					+ "回答：" + answer.text());
		}*/
	}
}
