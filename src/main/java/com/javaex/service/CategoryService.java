package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.CategoryDao;
import com.javaex.vo.CategoryVo;

@Service
public class CategoryService {

	
	@Autowired
	private CategoryDao categoryDao;
	
	public List<CategoryVo> list(int userno){
		
		
		return categoryDao.getlist(userno);
		
	}
	
	public CategoryVo ajaxCategory(CategoryVo categoryVo) {
		
		int result = categoryDao.insertCategoryajex(categoryVo);
		System.out.println(result);
		System.out.println("list"+categoryVo.toString());
		
		 
		
		return categoryDao.selectcateajax(categoryVo.getUserno());
		
	}
}
