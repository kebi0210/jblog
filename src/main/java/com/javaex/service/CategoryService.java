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
	
	public List<CategoryVo> ajaxCategory(CategoryVo categoryVo) {
		
		int result = categoryDao.insertCategoryajex(categoryVo);
		System.out.println(result);
		
		List<CategoryVo> cateajaxlist  = categoryDao.selectcateajax(categoryVo.getUserno());
		
		return cateajaxlist;
		
	}
}
