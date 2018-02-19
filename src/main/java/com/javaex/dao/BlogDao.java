package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BlogVo;
import com.javaex.vo.UserVo;

@Repository
public class BlogDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public int blogjoin(UserVo userVo) {
		
		return sqlSession.insert("blog.insertblog",userVo);
		
	}
	
	public BlogVo listblog(int userno) {
		
		BlogVo blogVo = sqlSession.selectOne("blog.listblog",userno);
		//System.out.println("blocVo.Dao"+blogVo);
		return blogVo;
		
	}
	
	public int updateblog(BlogVo blogVo) {
		
		int update = sqlSession.update("blog.updateblog",blogVo);
		System.out.println("update"+update);
		return update;
		
	}

	

}
