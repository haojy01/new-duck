package org.donald.duck.service.jsoup;

import java.io.IOException;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.http.HttpEntity;

public class MyHttpProxy {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		DefaultHttpClient httpClient = new DefaultHttpClient();
		httpClient.getCredentialsProvider().setCredentials(new AuthScope("127.0.0.1", 1080),
				new UsernamePasswordCredentials("", ""));

		HttpHost targetHost = new HttpHost("http://www.lietu.com", 80, "http");
		HttpHost proxy = new HttpHost("baidu.unblockwebproxysites.com", 80);
		httpClient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, proxy);
		HttpGet httpGet = new HttpGet();
		System.out.println("exextuing request: " + httpGet.getRequestLine());
		System.out.println("via proxy: " + proxy);
		System.out.println("to target:" + targetHost);
		
		HttpResponse response = httpClient.execute(targetHost,httpGet);
		HttpEntity entity = (HttpEntity) response.getEntity();
		System.out.println(response.getStatusLine());
	}
}
