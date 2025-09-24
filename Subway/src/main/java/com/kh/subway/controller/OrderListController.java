package com.kh.subway.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.subway.model.service.SubwayService;
import com.kh.subway.model.vo.Subway;

@WebServlet("/orderList.sandwich")
public class OrderListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public OrderListController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//a태그 요청 == GET방식
		//요청처리 ==
		List<Subway> orderList = new SubwayService().findAll();
		request.setAttribute("orders",orderList);
		request.getRequestDispatcher("/views/list.jsp");
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
