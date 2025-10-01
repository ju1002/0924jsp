package com.kh.java.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.java.board.model.service.BoardService;

@WebServlet("/boards")
public class BoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardListController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//페이징 처리
		//필요한 변수
		//총 게시글의 수 한 페이지에 들어갈 수를 말하는 거지
		int listCount;//현재 일반 게시판의 총 게시글 수
		//=> BOARD테이블에서 COUNT(*) (STATUS='Y' AND BOARD_TYPE = 1)조회
		int currentPage; //현재 사용자가 요청한 페이지 요청한 페이지가서 게시글을 조회해야 들고갈 수 있으니까
		//=>어거는 어떻게 알아내 request.getParameter("page")로 알아냄
		int pageLimit; //페이지 하단에 페이지 버튼의 개수=> 5개
		int boardLimit; //한페이지에 보여질 게시글의 최대 개수 => 우리가 직접 정함  10개
		
		int maxPage; //가장 마지막 페이지가 몇 번 페이지인지 (총 페이지의 개수)
		int startPage; //페이지 하단에 보여질 페이징 바의 시작 수
		int endPage; //페이지 하단에 보여질 페이징 바의 끝 수
		//listCount : 총 게시글의 수
		//현재 테이블에 게시글이 몇개나 있나를 알고 싶으면은 어디로 요청을 해야돼 어디야?
		//일단 서비스로 넘어와
		
		listCount =new BoardService().selectListCount();
		 System.out.println(listCount);
		request.getRequestDispatcher("/WEB-INF/views/board/board_list.jsp")
									.forward(request, response);
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
