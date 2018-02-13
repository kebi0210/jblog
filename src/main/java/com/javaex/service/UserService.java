package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.UserDao;
import com.javaex.vo.UserVo;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public int join(UserVo userVo) {
		
		return userDao.getjoin(userVo);
		
	}
	
	public UserVo login(String id, String password) {
		
		return userDao.getlogin(id,password);
		
	}
}
