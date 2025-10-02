package com.kh.java.board.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.kh.java.board.model.service.BoardService;
import com.kh.java.board.model.vo.Attachment;
import com.kh.java.board.model.vo.Board;
import com.kh.java.common.MyRenamePolicy;
import com.kh.java.member.model.vo.Member;
import com.oreilly.servlet.MultipartRequest;

@WebServlet("/insert.board")
public class BoardInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardInsertController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//1인코딩 설정
		request.setCharacterEncoding("UTF-8");
		//form태그 요청시 multipart/form-data형식으로 전송한 경우
		//request.getParameter로 값을 뽑을 수 없음
		//뽑을 경우 null값이 나옴
		//0 요청이 multipart방식으로 잘 왔는지부터 확인
		
		if(ServletFileUpload.isMultipartContent(request)) {
			//1전송된 파일을 위한 작업
			//1.1 전송파일 용량 제한
			int maxSize =10 *1024*1024;
			//1.2 서버의 저장할 폴더 경로 알아내기
			//pageContext
			//HttpServeltRequest
			//HttpSession
			//ServletContext
			//getRealPath()
			HttpSession session = request.getSession();
			ServletContext application = session.getServletContext();
			String savePath = application.getRealPath("/resources/board_upfiles");
			//장점: 동적으로 실제 경로 확인 , 서버환경에 관계없이 동작
			//단점 : WAR 파일 배포 시 파일이 사라질 수 있음
			//2.파일 업로드하기
			//HttpServeltRequest => MultipartRequest객체로 반환
			/*[표현법]
			 * MultipartRequest multiRequest=
			 * new MultiRequest(request,저장경로,용향제한,인코딩 ,파일명을 수정해주는 객체);
			 * Multipart 객체를 생성하면 파일이 업로드
			 * 사용자가 올린 파일명은 이름을 바꿔서 업로드하는게 일반적인 관례
			 * 파일명은 왜 바꾸지?
			 * 똑같은 파일명 있을 수 있으니까
			 * 퍼일명에 한글/ 특수문자/공백문자 포함 경우 서버에 따라 문제가 발생
			 */
			MultipartRequest multiRequest = new MultipartRequest(request,
					savePath,maxSize,"UTF-8",new MyRenamePolicy());
			//파일 업로드
			//BOARD테이블에 INSERT하기
			//2.값뽑기
			String title = multiRequest.getParameter("title");
			String content = multiRequest.getParameter("content");
			String category = multiRequest.getParameter("category");
			Long userNo =
			((Member)session.getAttribute("userInfo")).getUserNo();
			//3가공
			Board board = new Board();
			board.setBoardTitle(title);
			board.setBoardContent(content);
			board.setCategory(category);
			board.setBoardWriter(String.valueOf(userNo));
			
			//3.2 첨부파일의 경우 => 선택적
			Attachment at = null;
			
			//첨부파일의 유무을 파악
			//System.out.println(multiRequest.getOriginalFileName("upfile"));
			if(multiRequest.getOriginalFileName("upfile")!=null) {
				 at = new Attachment();
				//첨부파일이 있다면 =>VO로 만들기
				
				//originName
				at.setOriginName(multiRequest.getOriginalFileName("upfile"));;
				
				//changeName
				at.setChangeName(multiRequest.getFilesystemName("upfile"));
				//filePath
				at.setFilePath("resources/board_upfiles");
			}
		
			//요청처리 Serviece호출
			int result= new BoardService().insert(board,at);
		
			//5,응답화면 지정
			if(result>0) {
				session.setAttribute("alertMsg", "게시글작성 성공~");

				//request.getRequestDispatcher("/WEB-INF/views/board/board_list.jsp").forward(request, response);
			response.sendRedirect(request.getContextPath()+"/bpards");
			}else {
				if(at !=null) {
					
				}
				
			}
		}
		
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
