<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 실패용 페이지</title>
 <style>
 	h1{
 		color:red;
 		font-size:64px;
 		text-align: center;
 		height: 600px;
 		line-height: 600px;
 		}
 	
 
 
 
 
 </style>
</head>
<body>
<!-- .은 현재 경로 ..은 상위 폴더로 이동하겠다는 뜻 
실패하면 여기로 보내  줌-->

	<jsp:include page="../include/header.jsp"/>
	<h1>${msg }</h1> <!-- 키값이 msg인걸 출력한다는 뜻 -->
	<jsp:include page="../include/footer.jsp"/>
</body>
</html>