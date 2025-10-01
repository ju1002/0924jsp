package com.kh.java.board.model.dao;

import org.apache.ibatis.session.SqlSession;

public class BoardDao
{
	public int selectListCount(SqlSession sqlSession)
	{
		return sqlSession.selectOne("boardMapper.selectListCount");
		//내가 조회할게 총 페이지 개수 잖아 셀렉트 할 건데 count 쓸꺼면 어떤 모양 ? 
		//selectListCount잖아 그러면 하나의 배열의 수를 센다는건데 one으로 검색 해야 맞지
	}
}
