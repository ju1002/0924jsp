package com.kh.java.member.model.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.java.member.model.vo.Member;

public class MemberDao {
	public Member login(SqlSession sqlSession , Member member) {
		//여기서는 다시 서비스로 뭘 돌려줄 건지 생각을 해야 함
		//로그인이 되는지 안되는지 즉 내가 가입 했을 때 썼던 나의 정보가 일치 하는 지 확인 하고 그 값들을 다시 보여주기 위해 반환을 해줘야지 
		//우리는 전달 받은 모든 정보를 다 반환 해줄 거야 그니까 반환 형은 Member야
		//내가 sql문을 실행할 거를 select 해야함  어디가서 SQL문 실행해 mapper에 login 가서 할꺼니까 경로 쓰고 , 내가 실행할 값을 적어 뭘 해? member을 실행할 꺼지
		return sqlSession.selectOne("MemberMapper.login",member);
		//결과가 한 행이냐 여러 행이냐 에 따하 one, list결정됨
	}
	
	
	public int signUp(SqlSession sqlSession, Member member) {
		
		return sqlSession.insert("MemberMapper.signUp",member);
	}
	
	public int update(SqlSession sqlSession, Map<String,String>map) {
		return sqlSession.update("MemberMapper.update", map);
	}
	
	public int delete(SqlSession sqlSession, Member member) {
		return sqlSession.update("MemberMapper.delete",member);
	}
	public int updatePwd(SqlSession sqlSession, Map<String,String>map) {
		return sqlSession.update("MemberMapper.updatePwd",map);
	}
	
	
	

}
