<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    오늘나는 뭘한거지 아 떡볶이 맛있게 먹었다 오늘의 한일 맛 집 알아냄 몽글몽글 떡볶이 많이들 오세요~~
    오늘내가 해야할일은 뭘까? 과제가있지 과제를 해야하고 떡볶이를 먹자
    아니 나이차이가 너무 나서 왜 가운데 앉아가지고 고생을 하네........
<%@ taglib prefix="c" uri="" %>
<!-- URI 식별자: 고유한 이름 =>실체위치가 아닌 논리적인 식별값

	 URL 실체 파일의 경로나 웹 주소 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자신과의 싸움</title>
</head>
<body>

<h1>JSTL이란...?</h1>
<p>
	Jakarta Server Page Standard Tag Library 약어로 <br>
	JSP에서 사용할 수 있는 커스텀 액션 태그 <br>
	공통적으로 사용해야하는코드들의 집합을 보다 쉽게 사용할 수 있도록 태그로 만들어서 <br>
	표준으로 제공하는 라이브러리(클래스 모음집)


</p>
 <hr>
 <h3>라이브러리를 추가</h3>
 <p>확장자가 .jar인 파일들 WEB_INF/lib/~~.jar
 1. http://tomcat.apache.org로 접속 <br>
 2.Standard-1.2.3.jar 파일 4개다 다운받기 <br>
 3.WEB-INF/lib폴더에 추가해주기
 
 </p>
 
 <h4>JSTL선언 선언을 해야 사용가능함 </h4>
 <p>
 JSTL을 사용하고자하는 해당 JSP파일  상단에 
 (보통page지시어 바로 및네)
 [표현법] <br>
 &lt;@ taglib prefix="접두어" url=파일이네
 </p>
 <hr>
 
<h4>JSTL CORE Library</h4>
<p>
</p>
변수와 조건문 , 반복문 등의 로직과 관현됨  태그들을 제공
<h5>변수 </h5>

[표현법]
&lt;c:set var = value = 리터럴값 scope= 스코프영역
scopㄷ에 새로운 Attribute를 추가할 수 있는 태그
더 나아가서 어떤 scope레 추가할건디고 지정다
<c:set var="num1" value="10"/>
<c:set var="num2" value="20" scope="request"/>
<c:set var="result" value="${num1+num2 }" scope="session"/>
num1의 값 : ${num1 } <br>
num2의 값 : ${num2 } <br>
result의 값 : ${result } <br>

</body>
</html>