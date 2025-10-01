package com.kh.java.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/logout")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LogoutController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//로그아웃을 구현해야함
	//session의 userInfo라는 속성을  null이거나  지우거나
	//방법1. request.getSession().removeAttribute("userInfo");
	//방법2. session만료시키는  방법 
		request.getSession().invalidate();
		request.getSession().setAttribute("alertMsg", "데이터 날라감");
	
	//응답데이터 => 웰컴 파일 
	//sendRedirect()
		//System.out.println(request.getContextPath()); /Kh를 뜻함
		response.sendRedirect(request.getContextPath());
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
