package com.kh.subway.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.subway.model.service.SubwayService;
import com.kh.subway.model.vo.Subway;

@WebServlet("/order.do") //이 페이지에 오면 이걸 먼저 확인하고 바꿔줘야 함 jsp파일 가서 form태그의 action과 method부분을 보고 바꿔줘야 함 
//action부분에 /가 없는 상대지정 방식이면 /뒤에 저절로 들어옴
public class OrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public OrderController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//요청 전송방식이 뭐지 먼저 생각 GET? / POST?  WHY? POST는 인코딩을 해야하기 때문
		//1)요청시 전달값이 있는가? 따로 넘어오는 값이 있는지 생각해 봐야지 => 값이 있다 => 값뽑기
		//값뽑기 => request.getParameter("키값") , request.getParameterValue("키값")
		//값을 뽑아서 변수에 대입할꺼임 
		//주문자정보
		String name = request.getParameter("userName");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String message = request.getParameter("message");
		
		//주문 정보
		String sandwich = request.getParameter("sandwich");
		//checkbox영역이어서 배열로 받음 ==체크된게 하나도 없을 시 null값
		//checkbox영역은 내가 고를 수 있기 때문이다.
		String[] vegetable = request.getParameterValues("vegetable");
		String[] sauce = request.getParameterValues("sauce");
		String [] cookie = request.getParameterValues("cookie");
		String payment = request.getParameter("payment");
		
		//2. 가공 -> VO클래스를 객체로 생성해서 필드에 담기 요청을 전달
		Subway order = new Subway();
		order.setName(name);
		order.setPhone(phone);
		order.setAddress(address);
		order.setRequest(message);
		order.setSandwich(sandwich);
		order.setVegetable(vegetable != null ? 
				String.join("," , vegetable) :"선택안함");//null이 아닐 때만 넣고 싶다
		order.setCookie(cookie !=null ?
				String.join(",", cookie):"선택안함" );
		order.setSauce(sauce !=null ?
				String.join(",", sauce):"선택안함" );
		order.setPayment(payment);
		
		System.out.println(order);
		
		
		//3. 전달된 요청을 처리->Service 호출
		//new SubwayService().insertOrder(order);
		int result = new SubwayService().insertOrder(order);
		
		
		if(result>0) {
			//response.getWriter().append("succes:)");
			//1.사용자에게 응답시 출력해줄 데이터가 있다면 어딘가에 속성으로 추가해주게
			//request객체에 Attribute로 세팅
			request.setAttribute("order",order);
			//2.응답 뷰 지정
			RequestDispatcher view = request.getRequestDispatcher("/views/result.jsp");
			view.forward(request, response);
		}else {
			response.getWriter().append("fail:)");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
