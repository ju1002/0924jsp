<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.kh.el.model.vo.Person"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL구문을 사용해보자</title>




</head>
<body>
<h1>EL구문 배울거에요홓호호호호호홓호호호홓호호호호호호홓호호호홓호호호호홓호호호호호호호호호호호</h1>

<h3>기존 방식을 먼저 사용</h3>
<%
//requestScope => classRoom , student
String classRoom = (String)request.getAttribute("classRoom");
Person student = (Person)request.getAttribute("student");
//sessionScope => academy, lecture


//수강생의 정보

	//<hr>
	//<h3>EL구문을 이용해서 request/session 에 담긴 값들을 출력</h3>

	//<p>
		//학원명 : ${academy} <br> 강의장 : ${classRoom } <br> 강사정보 :
		//${lecture.name }, ${lecture.age },${lecture.address } <br>
		//<!-- 실제로 필드에 직접 근한게 하님 name => getName()
		//내부적으로 getter메소드를 찾아서 호출해서 값을 출력해주는 구조 
		//lecture에 접근했을 떄 value는 Person타입 객체
		//해당 Person객체의 각 필드값을 출력하려고한다면 키값.필드명을 작성하면 
		//해당 필드에 네이밍컨벤션에 부한하는 getter을 찾아서 호출함-->

	//</p>
	//<%int num = (int)request.getAttribute("num");
	//

//<p>
//없//는 키값을 출력하는 경우 
//</p>
 //pageScoe.
//<%=   %>


<p>
	산술연산
	big+small=${big+small } <br>
	big-small= ${big-small }<br>
	big x small= ${big*small }<br>
	big / small = ${big/small } 또는 ${big div small }<br>
	big%small = ${big%small }또는 ${big mod small }<br>
</p>

<h3>숫자간의 대소비교 연산</h3>
<p>


 big이 small보다 크니? : ${big > small }또는 ${big gt small }<br>
 big이 small보다 작니? : ${big< small }또는 ${big lt small }<br>
 big이 small보다 크거나같니? :${big>=small }또는 ${big ge small }<br>
 big이 small보다 작거나 같니? :${big<=small} 또는 ${big le small }<br>



</p>


<hr>
<h3>동등비교연산</h3>
<p>

big과 small이 같습니까? : ${big == small}또는 ${big eq small } <br>
big과 10이 같습니까? : ${big ==10 } 또는 ${big eq 10 } <br>
 strOne과 strTwo가 같습니다까 ? ${strOne == strTwo }또는 ${strOne eq strTwo }
 <!-- EL구문에서의 문자열 ==  비교는 자바에서의 equals()와 같은 동작을 함  -->
 strOne에 담긴값과 "안녕"이 일치하나요? : ${strOne =='안녕' } <br>
 strOne과 strTwo가 같지 않습니까? : ${strOne != strTwo } 또는 ${strOne ne strTwo } <br>
</p>

<hr>

<h3>4. 객체가 null인지 또는 리스트가 비어있는지 체크</h3>

<p>

기존방식 <br>

스크립클릿을 if()
객체 == null
리스트.isEmpty()
</p>
<p>

EL구문
    ogj가 null과 일치합니따? <br>
    ${obj == null }또는 ${obj eq null }또는 ${empty obj } <br>
    list가 비어있습니까?  ${empty list } <br>
    list가 비어있지 않나용? : ${!empty list } <br>
</p>

<hr>

<h3>5.논리연산자</h3>
    
<p>
AND연산: ${true  && true  } 또는   ${true and true } <br>

OR연산: ${true || true } 또는 ${true or false } <br>


</p>
    
    
    
    
    
    
    
    
    
    
    
    
    
    /p>



























</body>
</html>