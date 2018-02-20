package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

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
	
	public BlogVo getupdateblog(String title, int userno, MultipartFile file) {
		
		String logofile = "";
		
		if(StringUtils.isEmpty(file)) {
			logofile = blogDao.listblog(userno).getLogofile();
		} else {
			logofile = restore(file);
		}
		System.out.println(logofile);
		
		BlogVo blogVo = new BlogVo();
		blogVo.setBolgtitle(title);
		blogVo.setUserno(userno);
		blogVo.setLogofile(logofile);
		System.out.println("blogVo.servic"+blogVo);
		
		blogDao.updateblog(blogVo);
		
		BlogVo listblog = blogDao.listblog(userno); 
		
		return listblog;
	}
	
	public String restore(MultipartFile file) {
		
		String saveDir = "D:\\javaStudy\\upload";
		
		//파일 정보 수집
			
		
		//원 파일 이름
		String orgName = file.getOriginalFilename();
		//System.out.println("원파일이름"+orgName);
		//확장자
		String exName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		//System.out.println("확장자"+exName);
		//중복 파일 이름
		String saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + exName;
		//System.out.println("중복파일"+saveName);
		//파일 위치(패스)
		String filePath = saveDir + "\\" + saveName;
		//System.out.println("파일 위치"+filePath);
		//파일 사이즈
		long fileSize = file.getSize();
		//System.out.println("파일사이즈"+fileSize);
		//파일 카피
		try {
			byte[] fileData = file.getBytes();
			OutputStream out = new FileOutputStream(saveDir + "/" + saveName);
			BufferedOutputStream bout = new BufferedOutputStream(out);
			
			bout.write(fileData);
			
			bout.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return saveName;
	}
	
}
