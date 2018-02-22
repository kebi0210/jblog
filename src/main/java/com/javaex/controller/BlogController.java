package com.javaex.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.BlogService;
import com.javaex.service.CategoryService;
import com.javaex.service.PostService;
import com.javaex.service.UserService;
import com.javaex.vo.BlogVo;
import com.javaex.vo.CategoryVo;
import com.javaex.vo.PostVo;
import com.javaex.vo.UserVo;

@Controller
public class BlogController {
	
	@Autowired
	private BlogService blogService;

	@Autowired
	private UserService userService;
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public String blogfrom(@PathVariable(value="id") String id, Model model) {
		//System.out.println("내 블로그 진입");
		UserVo userVo = userService.userno(id);
		BlogVo blogVo = blogService.getlistBlog(userVo);
		//System.out.println("userVo"+userVo);
		
		model.addAttribute("blogVo",blogVo);
		String url = "upload/";
		model.addAttribute("url",url);
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
		
		String url = "upload/";
		model.addAttribute("url",url);
		
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
			                 @RequestParam(value="logo-file") MultipartFile file,
			                 Model model) {
			//System.out.println("업데이트 진입");
			//System.out.println(file);
			blogService.getupdateblog(title, userno, file);
			
		return "redirect:/{id}/admin/basic";	
	}	
	
	@RequestMapping(value="/{id}/admin/cate")
	public String categoryform(@PathVariable(value="id") String id,HttpSession session,Model model) {
		UserVo userVo = userService.userno(id);
		BlogVo blogVo = blogService.getlistBlog(userVo);
		
		model.addAttribute("blogVo",blogVo);
		
		return "blog/admin/blog-admin-cate";
		
	}
	
	@RequestMapping(value="/{id}/admin/write")
	public String writeform(@PathVariable(value="id") String id,HttpSession session,Model model) {
		UserVo userVo = userService.userno(id);
		BlogVo blogVo = blogService.getlistBlog(userVo);
		

		model.addAttribute("blogVo",blogVo);
		
		List<CategoryVo> listcate = categoryService.list(userVo.getUserno());
		
		//System.out.println(listcate);
		
		model.addAttribute("listcate",listcate);
		
		return "blog/admin/blog-admin-write";
		
	}
	
	@RequestMapping(value="/{id}/admin/insert")
	public String insert(@ModelAttribute PostVo postVo) {
		
		//System.out.println("insert 진입");
		//System.out.println(postVo);
		postService.insertpost(postVo);
		
		return "redirect:/{id}/admin/write";
		
	}
	
}
