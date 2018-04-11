package org.donald.duck.bean.responce;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.View;

public class JspBeanResult implements View {
	private String prefix = "views";
	private String suffix = ".html";

	private String viewName;

	public JspBeanResult(String viewName) {
		this.viewName = viewName;
	}

	public String getViewName() {
		return viewName;
	}

	@Override
	public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String path = prefix + viewName + suffix;
		request.getRequestDispatcher(path).forward(request, response);
	}

	@Override
	public String getContentType() {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
		//System.out.println("\\");
	}
}
