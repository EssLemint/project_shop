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
	height: 1000px;
}
#allDiv{
	margin: 0 0px;
	width: 1520px;
	height: 1000px;
}
#main{
	width: 300px;
	height: 1000px;
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
<script type="text/javascript">
</script>
</head>
<body>
			<div id="main">
						<h2 id="mainh2"><a href="./adminmainPage.do">COFFEE <br>Bean Tree</a></h2>
					<ul>
						<li id="mainli">
							<a href="./productList.do" id="maina">상품</a>
						</li>
<!-- 						<li id="mainli"> -->
<!-- 							<a href="#" id="maina">후기게시판</a> -->
<!-- 						</li> -->
						<li id="mainli">
							<a href="./productListAdmin.do" id="maina">상품 관리</a>
						</li>
						<li id="mainli">
							<a href="./memberOrderAllHistory.do" id="maina">회원 구매내역</a>
						</li>
						<li id="mainli">
							<a href="./list.do?no=${sessionScope.memberDto.no}" id="maina">회원 관리</a>
						</li>
					</ul>
			</div>
		<div id="userIdDiv">
			${sessionScope.memberDto.id}님 환영합니다.
				<a href="<%=request.getContextPath()%>/logout.do" style="color: blue;">
				<img style="width: 20px; height: 20px;" alt="" src="./resources/img/logout.png">
		</a>
		</div>
</body>
</html>