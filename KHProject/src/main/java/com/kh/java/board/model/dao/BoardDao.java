package com.kh.java.board.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.java.board.model.vo.Attachment;
import com.kh.java.board.model.vo.Board;
import com.kh.java.board.model.vo.Category;
import com.kh.java.common.vo.PageInfo;

public class BoardDao
{
	public int selectListCount(SqlSession sqlSession)
	{
		return sqlSession.selectOne("boardMapper.selectListCount");
		//내가 조회할게 총 페이지 개수 잖아 셀렉트 할 건데 count 쓸꺼면 어떤 모양 ? 
		//selectListCount잖아 그러면 하나의 배열의 수를 센다는건데 one으로 검색 해야 맞지
	}
	public List<Board> selectBoardList(SqlSession sqlSession, PageInfo pi){
		return sqlSession.selectList("boardMapper.selectBoardList",pi);
	}
	public List<Category>selectCategory(SqlSession sqlSession ){
		return sqlSession.selectList("boardMapper.selectCategory");
	}
	
	public int insertBoard(SqlSession sqlSession , Board board) {
		return sqlSession.insert("boardMapper.insertBoard",board);
	}
	
	public int insertAttachment(SqlSession sqlSession ,Attachment at) {
		return sqlSession.insert("boardMapper,inserAttachment",at);
	}
	public int increaseCount(SqlSession sqlSession, int boardNo) {
		return sqlSession.update("boardMapper.increaseCount",boardNo);
	}
	public Board selectBoard(SqlSession sqlSession, int boardNo) {
		return sqlSession.selectOne("boardMapper.selectBoard", boardNo);
		
	}
	public Attachment selectAttachment(SqlSession sqlSession ,int boardNo) {
		return sqlSession.selectOne("boardMapper.selectAttachment",boardNo);
	}
	public Long selectBoardWriter(SqlSession sqlSession,int boardNo) {
		return sqlSession.selectOne("boardMapper.selectBoardWriter",boardNo);
	}
}

