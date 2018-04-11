package org.donald.duck.service.httpclient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;


/**
 * httpClient 自动保存登录信息，自动管理　cookies
 * 
 * */
public class RenRenWithCookie {

	private static String userName = "512273389@qq.com";
	private static String password = "512273389";
	private static String redirectUrl = "http://photo.renren.com/photo/358995142/albumlist/v7#"; // 要抓取的页面

	private static String login_url = "http://www.renren.com/ajaxLogin/login?1=1&uniqueTimestamp=20171122015791";// 登录url

	private HttpResponse response;
	private CloseableHttpClient httpclient = HttpClients.createDefault();

	private boolean login() {
		HttpPost post = new HttpPost(login_url);

		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		nvps.add(new BasicNameValuePair("email", userName));
		nvps.add(new BasicNameValuePair("password", password));
		try {
			post.setEntity(new UrlEncodedFormEntity(nvps));
			response = httpclient.execute(post);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	private String getText(String redirectLocatio) {
		try {
			HttpGet httpget = new HttpGet(redirectLocatio);
			String responseBody = "";
			response = httpclient.execute(httpget);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				responseBody = EntityUtils.toString(response.getEntity());
			}
			return responseBody;
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void PrinText() {
		if (login()) {
			String redirectLocation = redirectUrl;
			if (redirectLocation != null) {
				System.out.println(getText(redirectLocation));
			}
		}
	}

	public static void main(String[] args) {
		RenRenWithCookie renren = new RenRenWithCookie();
		renren.PrinText();
	}
}
