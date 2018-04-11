package org.donald.duck.service;

import org.donald.duck.dao.DonaldDuckUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

	@Autowired
	private DonaldDuckUserMapper userMapper;

	public boolean verifPassword(String password, String userName) {
		return userMapper.verifPassword(password, userName)!=null;
	}
}
