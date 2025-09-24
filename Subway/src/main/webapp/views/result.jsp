<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="com.kh.subway.model.vo.Subway" %>
 <!-- 스크립틀릿 : 자바코드를 그대로 작설하는 영역 (세미콜론을 포함한 형태  -->   
 <!-- JsP는 Servlet으로 변환되어 동작하기 때문에 클래스 작성과 동일한 방식을 생각해야함 -->
 <% 
    
   Subway order = (Subway)request.getAttribute("order");
 %>
  
<!DOCTYPE html>  
<html>
<head>
<meta charset="UTF-8">
<title>주문확인 페이지</title>
<style>
	#wrap{width:1200px;
		  margin: auto;
	}
	h1{
	text-align:center;
	}

</style>
 <body>
<div id="wrap">
	<h1>주문내역</h1>
	<%--JSP주석 
	출력식 : <%= 자바 변수 메소드 호출 %> --%>
	<h3>주문자 정보</h3>
	이름: <%=order.getName() %><br>
	전화번호 :<%=order.getPhone() %> <br>
	주소 : <%=order.getAddress() %><br>
	요청사항 :<%=order.getRequest() %> <br>
	
	<h3>메뉴정보</h3>
	샌드위치 <%=order.getSandwich() %>: <br>
	채소 : <%=order.getVegetable() %><br>
	소스 : <%=order.getSauce() %><br>
	쿠키 : <%=order.getCookie() %><br>
	결제 방식 :<%=order.getPayment() %> <br>
	
	위와같이 주문하시겠습니다? <br><br>





</div>
</body>
</html>