package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BlogDao;
import com.javaex.dao.CategoryDao;
import com.javaex.dao.UserDao;
import com.javaex.vo.UserVo;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private BlogDao blogDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
	public void join(UserVo userVo) {
		
		userDao.getjoin(userVo);
		blogDao.blogjoin(userVo);
		categoryDao.getjoin(userVo);
		
	}
	
	public UserVo login(String id, String password) {
		
		return userDao.getlogin(id,password);
		
	}
	
	public UserVo userno(String id) {
		
		return userDao.getuserno(id);
		
	}
	
	public Boolean idCheck(String id) {
	
		UserVo userVo = userDao.idCheck(id);
		//System.out.println(userVo);
		if(userVo != null) {
			
			return  false;
			
		} else {
			
			return  true;
			
		}
		
		
		
}

}