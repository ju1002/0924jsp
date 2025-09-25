<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    오늘나는 뭘한거지 아 떡볶이 맛있게 먹었다 오늘의 한일 맛 집 알아냄 몽글몽글 떡볶이 많이들 오세요~~
    오늘내가 해야할일은 뭘까? 과제가있지 과제를 해야하고 떡볶이를 먹자
    아니 나이차이가 너무 나서 왜 가운데 앉아가지고 고생을 하네........
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

	<c:set var="result" scope="session">9999</c:set>
	<!-- value속성 말고 시작태그와 종료 태그 사이에도 대입할 값을 기술할 수 있음 -->
	
	<hr>
	
	<pre>
		속성삭제(Attribute remove)
		(&lt;c:remove var="제거하려는 키값" scope="스코프영역(생략사능)"/>)
		-해당 Attribute를 Scope영역에서 제거하는 태그
		-scope속성을 작성하지 않으면 모든 scope에서 해당Attribute를 찾아서 다 제거함
	</pre>

삭제 전 result : ${result } <br>
<hr>

requestScope에서 result속성을 삭제 <br>

<c:remove var="result" scope="request"/>
삭제 후 result : ${result } <br>

<pre>
속성 출력 (&lt;c:out value="출력할 값 " default="기본값" escapeXml="t/f"/>)
-데이터를 출력하려고 할 때 사용하는 태그
-default : 기본값 , value 속성에 출력하고자 하는 값이 없을 경우 대체해서 출력할 내용물을 쓸 수 있음(생략가능)
-escapeXml : HTML태그를 인식시킬수도 있음
</pre>

num1을 출력 : <c:out value="${num1}"/>  <br>

requestScope result : ${requestScope.result }<br>
<c:out value="${requestScope.result }" default="값이 없어요.." /> <br>

<br>

<c:set var="outStr" value="<strong>강한정보</strong>"/>

<br>
${outStr } <br>

<hr>

<h3>2. 조건문 - if태그 </h3>

<pre>
	[표현법]
	
	&lt;c:if test="조건식">
		조건식이 true일 경우 실행할 내용
		&lt;/c:if>
	-Java의 단일 if문과 비슷한 역할을 수행하는 태그
	-조건식은 test라는 속성에 작성
	(조건식을 만들때는 반드시 EL구문으로 작성해야 함!!)
</pre>


	<c:if test="${ num1 gt num2}">
		<strong>num1이 num2보다 큽니다.</strong>  
		<br>
	</c:if>

	<c:if test="${num1 le num2 }">
	
	<strong>num1이 num2보다 작거나 같습니다.</strong> <br>
	</c:if>
	
	<hr>
	
<!-- 여러개의 조건이 달렸을 때 -->
<h3>3.조건문 - choose,when,otherwise</h3>
<pre>
[표현법]
&lt;c:choose>
&lt;c:when test="조건1">

&lt;/c:when>

&lt;c: when test="조건2">

&lt;/c:when>

&lt;c:otherewise>
&lt;/c:otherwise>

&lt;/c:choose>


java의 if-else문, switch문 비슷한 역할을 하는 태그
각 조건들은 choose의 하위요소로 when태그를 이용해서 작성
otherwise는 조건을 작성하지 않음

db에서 뭐 회원의 포인트를 조회해 왔는데 포인트가100점이하면 일반 300우수 500vip회원 이렇게 포인트에 따라 회원등급을 출력해 줄껀데
</pre>
<c:set var="point" value="200"/>
회원등급 출력 :  

<c:choose>

	<c:when test="${pint le 100 }">
	일반회원 <br>
	</c:when>
	
	<c:when test="${point le 300 }">
	우수회원 <br>
	</c:when>
	<c:otherwise>
	
		<strong>최우수회원</strong> <br>
		앞에 조건들이 다 맞지 않았을 때 출력할 값
	</c:otherwise>
</c:choose>

<!-- choose에 하위 요소는 when과 otherwise만 들어갈 수 있음
다른 태그를 넣으면 오류 뜸! -->

<hr>

<h3>4.반복문 - forEach </h3>

<pre>

[표현법]

for loop문
&lt;c:forEach var="속성명" begin="초기값 :몇번 반복할건지" end="끝값 : 언제까지  할껀지" step="몇씩증가">
&lt;/c:forEach>

step생략 시 기본값이 1


향상됭 for문 
 &lt;c:forEach var="속성명"  items="순차적으로 접근할 배열 /컬렉션" varStatus="상태값">
 반복시킬 내용
 &lt;/c:forEach>
 
 var로 선언된 제어변수를 사용할때는 반드시 EL구문으로 접근해야함!

내가 만약 0~9까지 적고 값을 뽑고 싶다

</pre>

<c:forEach var="i" begin="0" end="9">
${i }
</c:forEach>

<c:forEach var="i" begin="1" end="6">
	<h${i }> 이런것도 가능 </h${i }>
</c:forEach>

<c:set var="color">
red,orangered,orange, yellow, yellowgreen, greeneyellow, forestgreen
</c:set>


<br>

<ul>

	<c:forEach var="c" items="${color }">
		<li style="color:${c}">${c }</li>
	</c:forEach>

</ul>

<hr>

<table border="1">
	<thead>

			<tr>
				<th>순번</th>
				<th>이름</th>
				<th>나이</th>
				<th>지역</th>
		   </tr>
	</thead>
	<tbody>
		<c:choose>
			<c:when test="${empty list }">
				<tr>
					<th colspan="3">조회결과가 존재하지 않습니다. </th>
			   </tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="p"  items="${list }" varStatus="s">
					<tr>
						<!-- s안에는 index,count가 있는데 index는 0부터 count는 1부터 시작함 -->
						<td>${s.count }</td>
						<td>${p.name }</td>
						<td>${p.age }</td>
						<td>${p.address }</td> 
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</tbody>
	<tfoot>
	<!-- 총합 통계 부분 -->
		<tr>
			<thcolspan="3">총합</thcolspan>
			<td>${list.size()}명</td>
		</tr> 
	</tfoot>
</table>

<hr>
	<h5>5. 반복문 -forTokens</h5>
	
	<pre>
		[표현법] <br>
		
		&lt;c:forTokens var="값을 보관할 속성명" items="분리하고자하는문자열" delims="구분자">
		 반복적으로 실행할 문구(출력만)
		&lt;/c:forTokens>
		
		JAVA의 StringTokenizer와 비슷한 역할
		구분자를 통해 분리된 각각의 문자열에 순차적으로 접근하면서 반복 수행 
	</pre>
	<!-- 테스트할 값 -->
	
	<c:set var="device" value="컴퓨터,핸드폰,TV/에어컨.냉장고-세탁기"/>
	
	<ul>
		<c:forTokens var="d" items="${device }" delims=",;.-">
			<li>${d }</li>
		</c:forTokens>
	
	</ul>	
	






































</body>
</html>