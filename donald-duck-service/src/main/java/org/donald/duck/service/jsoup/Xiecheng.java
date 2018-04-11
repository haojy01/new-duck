package org.donald.duck.service.jsoup;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Xiecheng {
	/// home/haojy/soft/phantomjs/xiecheng.js
	
	

	public static void main(String[] args) throws Exception {
		Runtime rt = Runtime.getRuntime();
		String exec = "/usr/bin/phantomjs /home/haojy/soft/phantomjs/xiecheng.js";
		Process p = rt.exec(exec);
		InputStream is = p.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		StringBuffer sbf = new StringBuffer();
		String tmp = "";
		while ((tmp = br.readLine()) != null) {
			sbf.append(tmp);
		}

		//System.out.println(sbf.toString());

		Document document = Jsoup.parse(sbf.toString());
		Elements select = document.select("#J_flightlist2");
		Elements list = select.select("div[id~=^flight_]");

		for (Element temp : list) {
			// #flight_SC1156 > table > tbody > tr
			Elements table = temp.select("table").select("tbody").select("tr");
			System.out.println(table.text());
		}

	}
}