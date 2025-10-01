package com.kh.java.member.controller;

import java.io.IOException;

import javax.naming.spi.DirStateFactory.Result;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.java.member.model.service.MemberService;
import com.kh.java.member.model.vo.Member;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//매개변수가 2개가 있네
		
		/*
		 * httpservletResponse, httpServletRequest
		 * requset: 서버로 요청 보낼 때의 정보(요청시 전달값 , 요청 전송방식, 사용자정보)가 있다. 
		 * 정보라고 하는 것은 의미가 있는 값 
		 * response: 요청에 대한 응답데이터를 만들 때 사용 
		 * 
		 * 얘가 controller역할을 한다 
		 * controller 하는 일 : 데이터 가공 
		 *절차
		 *1. get/ post => 요청 방식이 post방식이면 인코딩 작업  
		 *2. 요청 시 전달값이 잇나 확인하고 값을 뽑는다.
		 *request.getParameter("키값"): String타입임 무조건
		 *3. 요청처리 해주는 서비스로 넘어감 
		 *4. 응답화면을 지정 해줌 
		 *request속성에 출력할 값 추가 => setAttribute()
		 *RequestDispatcher=> 뷰 지정
		 *RequestDispatcher이용해서 forward() 전달하는  메소드  호출
		 *
		 *실패했다고 가정하고 작업을 하자
		 */
		request.setCharacterEncoding("UTF-8");//얘가 1번 작업 함 post방식이어서 인코딩한것
		String userId =request.getParameter("userId");
		String userPwd=request.getParameter("userPwd");//얘가 2번 작업
		//로그인이니까 사용자가 입력한 아이디와 비밀번호를 요청시 전달값으로 getParameter로 가져와서
		//변수에 대입한다
		
//		System.out.println(userId);//출력까지 해서 잘 됐는지 확인 해봄
//		System.out.println(userPwd);
		//값이 두개니까 어디다 담을꺼임 member vo에 필드 만듬 그 필드에 사용자에게 요청 받은 것을 필드에 담아준다.
		//Member타입의 member에 Member클래스의 주소값을 담는다 그 주소안에는 필드가 있지 
		//그 member에 사용자에게 요청받은 userId롸 Pwd를 setting한다.
		Member member = new Member();
		member.setUserId(userId);
		member.setUserPwd(userPwd);//여기 까지가 2번 다 한거임
		
		
		Member loginMember = new MemberService().login(member);//아이디와 비밀번호가 잇는 member를 서비스로 넘겨줌 어떻게? 인자값으로~~ 그리고 조회 성공하면 담아줘
		//로그인 성공했을경우 : 조회 성공한 컬럼값을 필드에 담은 멤버 객체 추소값
		//로그인 실패했을 경우: null값
		System.out.println(loginMember);
		//로그인에 성공/실패 있음
		//2. 성공/.실패 여부에 따라서 응답 페이지 다르게 보내주기
		
		if(loginMember!=null) {
			//사용자의 정보를 앞단으로 넘길꺼임
			//로그인한 회원의 정보를 로그아웃하거나
			//브라우저를 종료하기 전까지는 계속해서 유지하고 사용할 것이기 때문에
			//session에 담기
			
			//session의 Attribute로 사용자 정보 추가
			//session의 타입 : HttpSession
			//=>현재 요청 보내는 Client의 Session : request에 있음 request.getSession();
			//세션은 사용자가 웹사이트에 접속해서 활동하는 동안 서버가 사용자의 정보를 유지하는 방법입니다.
			//서블릿,jsp에서 세션을 가져오는 방법이다. 
			//session은 사용자의 정보이고 이 값을 가져오는 역할은 request.getParameter 요청한 값을 가져온다라고 해석하면 된다.
			//getSession()에는 내가 이후에 적은 값을 담아놓는다.
			HttpSession session = request.getSession();
			session.setAttribute("userInfo", loginMember);
			//웰컴 파일을 다시 보여줘야지  requestDispatcher get해오고 그걸 전달 해야 하니까 forward
			//request.getRequestDispatcher("/index.jsp").forward(request, response);
			//request.getRequestDispatcher이거는 서버내부를 뜻하고  index.jsp로 사용자가 보낸 요청과 
			//서버가 응답한것을 넘긴다는 의미이다.
			//index.jsp는 웰컴파일임
///클라이언트에게 URL을 다시 요청하게 함
//response 객체를 이용
//response
			session.setAttribute("alertMsg", "로그인에 성공하였습니다");
			response.sendRedirect("/KH"); //이거는 로그인에 성공을 하면 url인 /KH 로 가라는 거임 response는 서버가 응답
			//을 한거고 sendRedirect는 다른 url로 가라는 의미임
		}else { 
			//로그인 실패했어!!!
			request.setAttribute("msg","로그인에 실패했습니다");//msg키값에 로그인에 실패했다고 세팅하고
			request.getRequestDispatcher("/WEB-INF/views/common/result_page.jsp").forward(request, response);//result.jsp에 넘겨줌		
		}
	
		//화면에 나오기는 잘 나온는데 이 결과가 계속 유지가 되어야 돼 그래서 request에 담으면 안될것 같아
		//1.로그인된 사용자의 정보를 어딘가에 담을 것(application,session,request,page)
		/*1)application : 웹 애츨리케이션 전역에서 사용 가능 
		 * (일반 자바 클래스에서 값을 사용 할 수 있따
		 * 2)session: 모든 JSP와Servlet에서 꺼내 쓸 수 있음
		 * 				단, session에 값이 지워지기 전까지 사용 가능
		 * 				세션 종료 시점 : 브라우저 종료 , 서버 멈춤 , 코드로 지움(로그아웃을 의미)
		 * 3)request: 해당 request를 포워딩한 응답 JSP에서만 쓸 수있음 
		 * 	요청부터 응답까지만 딱 쓸 수 있음
		 * 4)page : 값을 담은 JSP에서만 쓸 수 있음
		 * 
		 * => session,request를 많이 사용함
		 */

	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response); //여기서 호출해야  출력 값이 나옴 
	}

}
