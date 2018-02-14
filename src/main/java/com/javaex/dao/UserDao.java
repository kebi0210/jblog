package com.javaex.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class UserDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public int getjoin(UserVo userVo) {
		
		return sqlSession.insert("join",userVo);
		
	}
	
	public UserVo getlogin(String id, String password) {
		
		Map<String, Object> map = new HashMap<String,Object>();
		 
		map.put("id", id);
		map.put("password", password);
		
		return sqlSession.selectOne("userLogin",map);
	}
	
	public int getuserno(String id) {
		
		return sqlSession.selectOne("userid",id);
		
	}
}
