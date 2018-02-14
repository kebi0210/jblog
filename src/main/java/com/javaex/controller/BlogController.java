package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BlogController {
	
//	@Autowired
//	private BlogService blogService;

//	@Autowired
//	private UserService userService;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public String blogfrom(@PathVariable(value="id") String id) {
		//System.out.println("블로그 진입");
		//System.out.println(id+"id");
	
		return "blog/blog-main";	
	}
	
	@RequestMapping(value="/{id}/admin")
	public String management(@PathVariable(value="id") String id) {
		
		System.out.println("내블로그 관리 진입");
		
		return "redirect:/admin/basic";
		
	}
	
	@RequestMapping(value="/admin/basic")
	public String blogmanagement() {
		
		
		return "blog/admin/blog-admin-basic";
		
	}
}
