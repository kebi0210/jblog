package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BlogDao;
import com.javaex.vo.BlogVo;
import com.javaex.vo.UserVo;

@Service
public class BlogService {
	
	@Autowired
	private BlogDao blogDao;
	

	
	public BlogVo getlistBlog(UserVo userVo) {
		int userno = userVo.getUserno();
		
		BlogVo blogVo = blogDao.listblog(userno);
		//System.out.println(userno);
		//System.out.println("blogVo.Service" + blogVo);
		return blogVo;
		
	}
	
	public BlogVo getupdateblog(String title,int userno) {
		
		BlogVo blogVo = new BlogVo();
		blogVo.setBolgtitle(title);
		blogVo.setUserno(userno);
		System.out.println("blogVo.servic"+blogVo);
		
		blogDao.updateblog(blogVo);
		
		BlogVo listblog = blogDao.listblog(userno); 
		
		return listblog;
	}
	
}
