package org.donald.duck.controller;

import java.util.HashMap;
import java.util.Map;

import org.donald.duck.bean.responce.JsonBeanResult;
import org.donald.duck.bean.responce.JspBeanResult;
import org.donald.duck.service.LoginService;
import org.donald.duck.service.biz.XiechengBizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginservice;
	@Autowired
	private XiechengBizService xiechengService;
	
	

	@RequestMapping("index.do")
	public JspBeanResult testLogin() {
		return new JspBeanResult("/login/login");
	}

	@RequestMapping(value = "/login.do")
	public JsonBeanResult login(@RequestParam(required = true, name = "userName") String userName,
			@RequestParam(value = "password") String password) {
		Map<String, String> result = new HashMap<String, String>();
		boolean verifPassword = loginservice.verifPassword(password, userName);
		if (verifPassword) {
			result.put("code", "1");
		} else {
			result.put("code", "2");
		}
		return new JsonBeanResult(result);
	}

	@RequestMapping("loginError.do")
	public JspBeanResult loginError() {
		return new JspBeanResult("/login//loginError");
	}

	@RequestMapping(value = "signup.do")
	public JspBeanResult signup() {
		return new JspBeanResult("/login/signup");
	}
	@RequestMapping(value = "forgot.do")
	public JspBeanResult forgot() {
		return new JspBeanResult("/login/forgot");
	}
	
	@RequestMapping(value = "loginSuccess.do")
	public JspBeanResult loginSuccess() {
		return new JspBeanResult("/main/index");
	}
	@RequestMapping(value = "left.do")
	public JspBeanResult left() {
		return new JspBeanResult("/main/left");
	}
	@RequestMapping(value = "right.do")
	public JspBeanResult right() {
		return new JspBeanResult("/main/hy_list");
	}
	@RequestMapping(value = "top.do")
	public JspBeanResult top() {
		return new JspBeanResult("/main/top");
	}
	
	@RequestMapping(value = "spider.do")
	public JspBeanResult spider() {
		xiechengService.spider();
		return new JspBeanResult("/main/top");
	}
}
