package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PostVo;

@Repository
public class PostDao {

	
	@Autowired
	private SqlSession sqlSession;
	
	public int getinsert(PostVo postVo) {
		
		//System.out.println("getinsert 진입");
		
		return sqlSession.insert("post.insertpost",postVo);
		
	}
	
}
