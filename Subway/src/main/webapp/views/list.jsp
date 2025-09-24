<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.kh.subway.model.vo.Subway.java.List" %>
 <% //requesr getAttribute("키값")ㅣ object
 List<Subway> orders = request.getAttribute("ordder");                                      %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style >
#wrap{}</style>

width:1200px;
border: 1px solid  lightgrey;
text-align : center;
marrgin :auto;
table{
box-shadow
</head>
<body>
<h1>주문내역 보기</h1>
<table>
<tr>

<th></th>

<tr></tr>
<%if(orders.isEmpty()){ %>
<tr>
 	<th></th> colspan="10"">조허결과가 존재하지 않습니다.
 	<%} else{%>
 	<% for(Subway s :orders){ %>
 	<tr>
 		<td><%=s.getName() %></td>
 		<td><%=s.getPhone() %></td>
 		<td><%=s.get Address()%></td>
 		<td><%=s.get %></td>
 		<td><%=s.getName() %></td>
 		<td><%=s.getName() %></td>
 		<td><%=s.getName() %></td>
 		<td><%=s.getName() %></td>
 		<td><%=s.getName() %></td>
 		<td><%=s.getName() %></td>
 		
</tr>
</table>

</body>
</html>