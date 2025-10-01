package com.kh.java.board.model.service;

import org.apache.ibatis.session.SqlSession;

import com.kh.java.board.model.dao.BoardDao;
import com.kh.java.common.Template;

public class BoardService {
	private BoardDao bd =new BoardDao();
	
	public int selectListCount() {
		SqlSession sqlSession = Template.getSqlSession();
		
		int listCount = bd.selectListCount(sqlSession);
		
		sqlSession.close();
		
		return listCount;
	}
}
