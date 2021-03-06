package com.javaex.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.CategoryService;
import com.javaex.vo.CategoryVo;

@Controller
public class ApiCategoryController {

	@Autowired
	private CategoryService categroyService;
	
	@ResponseBody
	@RequestMapping(value="/api/catelist")
	public List<CategoryVo> catelist(@RequestParam("userno") int userno){
		
		List<CategoryVo> catelist = categroyService.list(userno);
		
		return catelist;
		
	}
	
	
	@ResponseBody
	@RequestMapping(value="/api/insertajex")
	public CategoryVo insertcategoryajex(@ModelAttribute("CategoryVo") CategoryVo categoryVo) {
		System.out.println(categoryVo.toString());
			 categroyService.ajaxCategory(categoryVo);
			System.out.println("list"+categoryVo.toString());
			
		return categoryVo;
	}
	
	@ResponseBody
	@RequestMapping("/api/listcate")
	public List<CategoryVo> getListCate(@RequestParam int userno){
		List<CategoryVo> cateList = categroyService.list(userno);
		return cateList;
	}
} 
