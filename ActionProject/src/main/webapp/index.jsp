<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>안녕 나는 웰컴 파일임 반가워~~</h1>
	<h2>EL(Expression Language)</h2>
	<p>JSP상에서 출력하고 싶으면 출력식 써야함 &lt;%= %>
	&lt;% 
	EL구문을 사용하면 \${변수 } 형식으로 작성할 수 있음
	</p>
	<h3>EL구문 간단하게 공부해보기 </h3>
	<a href="/action/el.do">01_EL</a>
	${classRoom },${academy }
	
	<!--
	1.Scripting Element : JSP상에서 자바코드를 직접 기술할 요소
	2. 문자열 : HTML,CSS<J>
	3. 지시어 : JSP메이지 정보를 기술한다거나 (page)포함시킬때 사용 (includeO
	4. JSP Action Tag  : XML기술을 사용해서 기존의 JSP문법을 확장하는 용도로 사용하는 태그                                     
	  -->
	views를 WEB-INF에 만들꺼임
	
	
	<h2>JSP Action Tag</h2>
	<h3>1. 표준액션 태그</h3>
	<a href="/action/">incldue.do </a>
	
	
	<h3>2.커스텀 액션 태그</h3>
	<a href="/action/jstl.do">04_JSTL</a>
</body>
</html>