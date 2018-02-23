package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.CategoryVo;
import com.javaex.vo.UserVo;

@Repository
public class CategoryDao {

	@Autowired
	private SqlSession sqlSession;
	
	public int getjoin(UserVo userVo) {

		return sqlSession.insert("category.insertcategory", userVo);
		
	}
	
	
	public int insertCategoryajex(CategoryVo categoryVo) {
		
		int result = sqlSession.insert("category.insertcategoryajex",categoryVo);
		
		return result;
		
	}
	
	public CategoryVo selectcateajax(int cateno){
		
		 
		
		return sqlSession.selectOne("category.listcateajax",cateno);
		
	}
	
	public List<CategoryVo> getlist(int userno){
		
		return sqlSession.selectList("category.listcate", userno);
		
	}
	
}
