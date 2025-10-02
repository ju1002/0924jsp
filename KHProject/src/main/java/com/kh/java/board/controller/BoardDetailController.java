package com.kh.java.board.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.java.board.model.service.BoardService;

@WebServlet("/detail.board")
public class BoardDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardDetailController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//일단 KH_BOATD에서 게시글 내용 조회하고 
		//첨부파일은 KH_ATTACHMENT에서 조회해가야함
		//GET방식
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		//가공할건 없음
		//요청처리 서비스 단으로
		Map<String,Object >map= new BoardService().selectBoard(boardNo);
		String path="";
		//성공 실패
		if(map !=null) {
		request.setAttribute("map", map);
		path= "board/board_detail";
		//request.getRequestDispatcher("MEP-INF/views/board/board_detail.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "게시글이 없어요");
			path="common/result_page";
			
			//request.getRequestDispatcher("/WEB-INF/views/common/result_page.jsp").forward(request, response);
		}
		request.getRequestDispatcher("/WEB-INF/views/" + path +".jsp").forward(request, response);
		//이렇게 중복제거
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
