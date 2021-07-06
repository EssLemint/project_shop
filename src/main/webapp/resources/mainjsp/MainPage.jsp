<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello Spring</title>
<style type="text/css">
body{
	margin: 0 0px;
}
#mainallDiv{
	width: 300px;
	height: 800px;
}
#allDiv{
	margin: 0 0px;
	width: 1520px;
	height: 800px;
}
#main{
	width: 300px;
	height: 100vh;
	float: left;
	border-right: 2px solid #ff4d4d;
}
#mainh2{
	text-align: center;
	margin-top: 80px;
	margin-bottom: 30px;
	font-size: 50px;
}
#mainli {
	list-style: none;
	margin-bottom: 10px;
}
#maina{
	font-size: 20px;
	font-weight: bolder;
	text-decoration: none;
	color: black;
}
#userIdDiv{
	text-align: right;
 	margin-right: 160px; 
	position: relative;
}
a{
	text-decoration: none;
	color: black;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">

</script>
</head>
<body id="body">
			<!-- 				인크루드 예시 -->
<%-- 	<jsp:include page="/resources/mainjsp/MainPage.jsp"/> --%>
			<div>
				<div id="main">
					<h2 id="mainh2"><a href="./mainPage.do">COFFEE <br>Bean Tree</a></h2>
					<ul>
						<li id="mainli">
							<a href="./productList.do" id="maina">상품</a>
						</li>
						<li id="mainli">
							<a href="./basketAdd.do" id="maina">장바구니</a>
						</li>
<!-- 						<li id="mainli"> -->
<!-- 							<a href="#" id="maina">후기게시판</a> -->
<!-- 						</li> -->
						<li id="mainli">
							<a href="./myPage.do?no=${sessionScope.memberDto.no}" id="maina">마이페이지</a>
						</li>
						<li id="mainli">
							<a href="./orderHistoryList.do" id="maina">주문내역</a>
						</li>
					</ul>
			</div>
			<div>
				<div id="userIdDiv">
					${sessionScope.memberDto.id}님 환영합니다.
					<a href="<%=request.getContextPath()%>/logout.do" style="color: blue;">
					<img style="width: 20px; height: 20px;" alt="" src="./resources/img/logout.png">
			</a>
				</div>
			</div>
		</div>
</body>
</html>