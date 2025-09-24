package com.kh.first.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/post.do")
public class RequestPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RequestPostServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1.데이터 값 뽑기
		// 2. 요청처리-> 오늘은 패스
		// 3. 응답화면 지정
		// 0단계
		// POST방식일 경우 인코딩 설정이 ISO-8859-1방식으로 바뀌기 때문에
		// 값을 뽑기전에 미리 UTF-8방식으로 변경
		request.setCharacterEncoding("UTF-8");
		// 1단계 값 뽑아서 변수에 대입하고 출력해보기
		// request.getParameter("키값") 또는 request.getParameterValues("키값")

		String name = request.getParameter("name");
		System.out.println(name);

		String gender = request.getParameter("gender");
		System.out.println(gender);

		int age = Integer.parseInt(request.getParameter("age"));
		System.out.println(age);

		String city = request.getParameter("city");
		System.out.println(city);

		double height = Double.parseDouble(request.getParameter("height"));
		// Double.parseDouble 문자열을 실수로 강제변환 하는 함수
		System.out.println(height);
		int realHeight = (int) height;

		String[] foods = request.getParameterValues("food");
		System.out.println(foods);

		// 2단계 요청 처리
		// Service => DAO-=> DB
		// List/VO / Int
		// 3단계 응답데이터

		// JSP을 이용해서 응답 페이지 만들기
		// Java Server Page 에서 바 뀜 Jakarta Server Page
		// Java기반의 서버 사이드 웹 페이지 생성 기숳
//특징 : 서버에서 실행되어 동적으로 웹페이지를 생성할 수 있음

//응답데이터 생성과정을 JSP에게 위임(배정)
//배정 시 필요한 객체 : RequestDispatcher
//디스패칭을 컴퓨터 공학에서 cpu가 하는 중요한 업무 중에 하나라고 하는데 그중 배정을 한다.
//응답을 만들어낸것을 배정하는 일을 한다.

//JSP(응답화면)에서 필요한 데이터을 넘겨줄것 (request에 담아서)
//parameter(매개변수) 값을 뽑을 때는 getParameter("키값") 은 가능하다
//setter은 가능하지 않는다.
//	attribute =>키 -벨류 세트로 묶어서 값을 만들언낼 수 있음
//request에 새로운걸 세팅하고 싶은데 뭘 세팅해? attribute를 세팅 request.setAttribute("키","벨류");
//key값은 무조건 String 벨류값은 뭐가 오든 상관 없음
		request.setAttribute("msg","요청처리에 성공했습니다.");
		request.setAttribute("name", name);
		request.setAttribute("gender", gender);
		request.setAttribute("age", age);
		request.setAttribute("city", city);
		request.setAttribute("height",height);
		request.setAttribute("foods",foods);
		
//request.getResquestDispatcher("JSP파일의 경로");request메소드에서 디스패치를 가져올꺼니까 get사용
		// /를 사용해서 시작함 webapp/을 의미
		RequestDispatcher view = request.getRequestDispatcher("/views/response_page.jsp");
		// 변수에 담아서 사용
		// 사용자의 정보와 , response응답 객체를 전달을 해줘야 한다.
		view.forward(request, response);
		// forward 전달할 때 쓰는 메소드임

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
