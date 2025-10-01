package com.kh.java.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.java.member.model.service.MemberService;
import com.kh.java.member.model.vo.Member;

@WebServlet("/members")
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SignUpController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	//Post방식
	//인코딩
		request.setCharacterEncoding("UTF-8");
	//request객체로부터 요청 시 전달값 받기
		String userId =request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String userName = request.getParameter("userName");
		String email = request.getParameter("email");
	//member
		Member member = new Member();
		member.setUserId(userId);
		member.setUserPwd(userPwd);
		member.setUserName(userName);
		member.setEmail(email);
		
		
		//서비스로 감
		int result= new MemberService().signUp(member);
		
		//5. 회원가입 성공했는지 안했는지에 따라서 
		//응답화면을 다르게 지정
		
		if(result>0) {
			//성공했다
			HttpSession session =request.getSession();
			session.setAttribute("alertMsg","회원가입 성공");
			response.sendRedirect(request.getContextPath());
			
			
			
		}else {
			//실패했다
			//실패 페이지로 forwarding하기로 함 그전 에 msg하는 Key로 
			 request.setAttribute("msg", "회원가입에 실패하셨습니다.");
			 request.getRequestDispatcher("/WEB-INF/views/common/result_page.jsp").forward(request, response);
			
		}
		
		
		
		
		
	
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
