<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    // 이 구문은 스크립틀릿 이라고 함
    //자바코드를 그냥 쓸 수 있음
    int a= 0;
    //미리 여기서 뽑아내야지 출력가능
    //현재 JSP상에서 필요한 데이터들을 => request
    int age= (int)request.getAttribute("age");
    double  height = (double)request.getAttribute("height");
    String name = (String)request.getAttribute("name");
    String gender= (String)request.getAttribute("gender");
    String city = (String)request.getAttribute("city");
    String[] foods = (String[])request.getAttribute("foods");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 응답을 여기서 할꺼임
응답을 하기 위해서 사용자가 누군지 알아야 함 그래야 그걸가지고 응답을 해줄 수 있기 때문이다.
 -->
 <!-- 넘어온 key값을 적음 -->
 <h1>${msg}</h1>
 <h3><%=name%>님의 정보~ </h3>
 나이<%=age%> <br>
 키<%=height %> <br>
지역<%=city %> <br>

성별 
<% if(gender==null){ %> 
선택안함 <br><%}else if("남".equals(gender)){ %>
남자 <br><% } else{
	%>여자
<%} %>

좋아하는 음식
<%if(foods==null){ %>
안고름<%}else{ %>
<% for(int i=0; i < foods.length; i++){%>
 <ul>
 <li><%=foods[i] %></li>
 <%} %>
 </ul>입니다

<%} %>

</body>
</html>