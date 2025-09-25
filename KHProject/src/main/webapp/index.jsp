<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>welcome파일을 webapp에 만들어 줌 </title>
</head>
<body>
<!-- WEB환경에서의 CRUD
	회원서비스
	로그인/로그아웃, 회원가입(아이디 중복체크),내정보 조회(마이페이지),내정보 변경,
	비밀번호 변경,회원 탈퇴
	
	공지사항 서비스
	공지사항등록, 공지사항 목록조회, 공지사항상세조회, 공지사항 수정, 공지사항 삭제
	일반게시판 서비스
	
	게시글 목록조회(페이징 처리 페이지 넘기면서 하는 거), 상세조회 ,게시글 작성(첨부파일 1개 업로드) , 게시글 수정
	,게시글 삭제, 댓글 서비스 , 게시글 검색
	
	사진게시판 서비스
	사진게시글 목록조회(이미지) , 상세조회, 게시글작성(다중파일업로드) -->
	<jsp:include page="WEB-INF/views/include/header.jsp"/>
	<jsp:include page="WEB-INF/views/include/main.jsp"/>
	<jsp:include page="WEB-INF/views/include/footer.jsp"/>
<!-- include함 -->

</body>
</html>