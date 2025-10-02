package com.kh.java.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.java.board.model.service.BoardService;
import com.kh.java.board.model.vo.Board;
import com.kh.java.common.vo.PageInfo;

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
		 //System.out.println(listCount);
		currentPage =Integer.parseInt(request.getParameter("page"));
		pageLimit =3;
		boardLimit=5;
		/*maxPage:가장 마지막페이지가 몇번 페이지인지
		 * listCount, boardLimit에 영향을 받음
		 * -공식 구하기
		 * 단 , boardLimit이 10이라고 가정
		 * 총개수   한페이지 나눗셈결과  마지막페이지
		 * 100 /   10  =  10.0    10
		 * 107 /   10 = 10.7       11
		 * 나눗셈(listCount/boardCount )의 결과를 올림처리 할 경우 maxPage가 나옴
		 * 
		 * 순서
		 * 1. listCount를 double로 변환
		 * 2. listCount/ boardLimit
		 * 3.결과를 올림처리 => Math.ceil()
		 */
		maxPage =(int)Math.ceil((double)listCount/boardLimit);
		/*startPage: 페이지 하단에 보여질 페이징  버튼중 시작값
		 * currentpage,pageLimit에 영향을 받음
		 * 
		 * -공식 구하기 
		 * 단, pageLimit이 10이라고 가정
		 * starPage:1,11,21,31 =>
		 * currentPage     startPage
		 * 		1				1
		 * 		5				1
		 * 		10				1
		 * 		11				11
		 * 		13				11
		 * 		17				11
		 * 		20				11
		 * 		21				21
		 * n =(currentpage-1)/ pageLimit
		 * startPage =(currentPage-1)/pageLimit*pageLimit+1;
	*/
		startPage =(currentPage-1)/ pageLimit*pageLimit+1;
		/*ensdpage: 페이지 하단에 보여질 페이지  버튼의 끝 수
		 * startPage, pageLimit에 영향을 받음 
		 * 
		 * -
		 */
		endPage = startPage+pageLimit-1;
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		int offset = (currentPage -1)*boardLimit;
		
		PageInfo pi = new PageInfo(listCount,currentPage,
									pageLimit ,boardLimit,
									startPage, endPage,
									maxPage, offset);
		//System.out.println(pi);
		List<Board> boards = new BoardService().selectBoardList(pi);
		//pi랑 boards랑 보내줘야 함
		

		
		request.getRequestDispatcher("/WEB-INF/views/board/board_list.jsp")
									.forward(request, response);
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
