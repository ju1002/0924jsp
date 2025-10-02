package com.kh.java.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.java.board.model.vo.Attachment;
import com.kh.java.board.model.vo.Board;

@WebServlet("/update.board")
public class BoardUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardUpdateController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	//case1. 첨부파일이 없음 => BOARD UPDATE +AT X
	//case2. 첨부파일 O , 기존 첨부파일 O => BOARD UPDATE +AT UPDATE
	//case3. 첨부파일 O , 기존 첨부파일 X => BOARD ULPDATE =AT INSERT
	//값뽑기
		String category = multiRequest.getParameter("category");
		String boardTitle = multiRequest.getParameter("title");
		String boardContent = multiRequest.getParameter("content");
		Long boardNo = Long.parseLong(multiRequest.getParameter("boardNo"));
		
		Board board = new Board();
		board.setCategory(category);
		board.setBoardTitle(boardTitle);
		board.setBoardContent(boardContent);
		board.setBoardNo(boardNo);
		
		//Attachment 객체 선언만 
		//실제 첨부파일이 존재할 경우에만 => 객체 생성
		Attachment at = null;
		
		if(multiRequest.getOriginalFileName("")) {
			
		}
		
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
