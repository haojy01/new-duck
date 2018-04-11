package org.donald.duck.bean.responce;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.View;

import com.alibaba.fastjson.JSON;

public class JsonBeanResult implements View {

	Object object;

	public JsonBeanResult(Object object) {
		this.object = object;
	}

	@Override
	public String getContentType() {
		return "application/json;charset=UTF-8";
	}

	@Override
	public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	
		String jsonResult = JSON.toJSONString(object);
		response.setHeader("Content-type", "application/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.getOutputStream().write(jsonResult.getBytes("UTF-8"));
	}

}
