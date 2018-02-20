package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.UserService;
import com.javaex.vo.UserVo;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService; 
	
	@RequestMapping(value="user/joinform",method=RequestMethod.GET)
	public String joinform() {
		
		//System.out.println("joinform 진입");
		
		return "user/joinForm";
		
	}
	
	@RequestMapping(value="/user/join",method=RequestMethod.POST)
	public String insert(@ModelAttribute UserVo uesrVo) {
		//System.out.println("join 진입");
		
		userService.join(uesrVo);
		
		//System.out.println(uesrVo);
		
		return "user/joinSuccess";
		
	}
	
	@RequestMapping(value="user/loginForm",method=RequestMethod.GET)
	public String loginform() {
		System.out.println("loginform 진입");
		
		return "user/loginForm";
		
	}
	
	@RequestMapping(value="/user/login",method=RequestMethod.POST)
	public String login(@RequestParam("id") String id,
			            @RequestParam("password") String password,
			            HttpSession session) {
						
		UserVo authUser = userService.login(id, password); 
		
		if(authUser != null) {
		
			session.setAttribute("authUser", authUser);
			return "main/index";
		
		}else {
			
			return "redirect:/user/loginForm?result=fail";
		}
		
	}
	
	@RequestMapping(value="/user/logout",method=RequestMethod.GET)
	public String logout(HttpSession session) {
		
		session.removeAttribute("authUser");
		session.invalidate();
		
		return "main/index";
		
	}
	
		@ResponseBody 
	 	@RequestMapping(value="/user/idCheck") 
	 	public boolean idCheck(@RequestParam("id") String id) { 
	 		
		boolean result = userService.idCheck(id); 
	
	 		return result;    
	 	} 

	
}
