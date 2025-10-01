package com.kh.java.member.model.service;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.java.common.Template;
import com.kh.java.member.model.dao.MemberDao;
import com.kh.java.member.model.vo.Member;

public class MemberService {
	private MemberDao md = new MemberDao();
	
	
	public Member login(Member member){
		//컨트롤러가 요청 해준거임 로그인 해달라고 
		//
		//로그인 처리를 해야지 근데 혼자 모다니까 =>dao로 보내서 있나없나 확인해서 -> 여기로 결과를 다시 반환하면 받아줌
		//또한 트랜잭션 처리도 해줘야 함 
		//validateMember(member);
		SqlSession sqlSession = Template.getSqlSession();
		//sqlsession은 db와 연결하는 매개체이다.
		//sqlsession은 select,insert,update,deletet같은 메소드를 사용가능하다.
		Member loginMember = md.login(sqlSession,member); //dao에게 보내줘 그리고 조회 성공하면 계쏙 쓸꺼니까 변수에 담아 
		
		sqlSession.close();
		
		return loginMember;
	
	}
	public void validateMember(Member member) {//비즈니스 로직 원래는 이걸 먼저 해야함  
		//아이디 검증 널인지 비어있는지 그리고 한글로 써서 보내는 등 불상사를 일으킬 수 있는 값을 사용자가 입력할 수도 있기 때문에 정규 표현식 적용
		if(member.getUserId()==null||member.getUserId().isEmpty()) {
			return;
		}
		String pattern="^[a-zA-Z0-9]{4,20}$"; //정규 표현식 
		if(member.getUserId().matches(pattern)) {
			return;
		}
		//비밀번호 검증 
	}
	
	public int signUp(Member member) {
		SqlSession sqlSession= Template.getSqlSession();
		
		int result = md.signUp(sqlSession,member);
		if(result>0) {
			sqlSession.commit();
		}
		sqlSession.close();
		
		
		return result;
	}
	public int update(Map<String, String> map) {
		SqlSession session = Template.getSqlSession();
		int result = md.update(session,map);
		
		if(result>0) {
			session.commit();
		}
		session.close();
		
		return result;
	}

	public int delete(Member member) {
		SqlSession session = Template.getSqlSession();
		int result = md.delete(session,member);
		if(result>0) {
			session.commit();
		}
		session.close();
		return result;
	}
	public int updatePwd(Map<String,String>map) {
		SqlSession sqlSession = Template.getSqlSession();
		
		int result = md.updatePwd(sqlSession,map);
		if(result>0) {
			sqlSession.commit();
		}
		sqlSession.close();
		return result;
	}
}
