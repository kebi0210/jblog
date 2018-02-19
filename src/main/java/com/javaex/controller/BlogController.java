package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.BlogService;
import com.javaex.service.UserService;
import com.javaex.vo.BlogVo;
import com.javaex.vo.UserVo;

@Controller
public class BlogController {
	
	@Autowired
	private BlogService blogService;

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public String blogfrom(@PathVariable(value="id") String id, Model model) {
		//System.out.println("내 블로그 진입");
		UserVo userVo = userService.userno(id);
		BlogVo blogVo = blogService.getlistBlog(userVo);
		//System.out.println("userVo"+userVo);
		
		model.addAttribute("blogVo",blogVo);
		//System.out.println("blogVo"+blogVo);
		return "blog/blog-main";	
	}
	
	@RequestMapping(value="{id}/admin")
	public String management(@PathVariable(value="id") String id) {
		
		System.out.println("내블로그 관리 진입");
		
		return "redirect:/{id}/admin/basic";
		
	}
	
	@RequestMapping(value="/{id}/admin/basic")
	public String blogmanagement(@PathVariable(value="id") String id,HttpSession session,Model model) {
		
		UserVo userVo = userService.userno(id);
		BlogVo blogVo = blogService.getlistBlog(userVo);
		
		model.addAttribute("blogVo",blogVo);
		
		UserVo authUser = (UserVo) session.getAttribute("authUser");
		
		if(authUser == null) {
			
			return "user/loginForm";
			
		}else {
			
			
			//System.out.println("blogVo"+blogVo);
			return "blog/admin/blog-admin-basic";
			
		}
		
	}	
	
	
	@RequestMapping(value="/{id}/admin/update")
	public String blogupdate(@RequestParam(value ="title") String title,
			                 @RequestParam(value ="userno") int userno,
			                 Model model) {
			System.out.println("업데이트 진입");
			
			BlogVo blogVo = blogService.getupdateblog(title,userno);
				System.out.println("blogVo2222"+blogVo);
			//model.addAttribute("blogVo",blogVo);
			//System.out.println(blogVo);
		return "redirect:/{id}/admin/basic";
		
		
	
		
	}	
	
	
	
	
}
