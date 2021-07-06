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
	border-right: 2px solid  #ff4d4d;
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
	margin-left: 40px;
}
#userIdDiv{
	float: right;
	margin-right: 160px;
	position: relative;
	margin-top: 0px;
	margin-bottom: 20px;
	
}
#one {
	width: 300px;
	height: 1000px;
	float: left;
	border: 1px solid black;	
}
ul, li {
	list-style: none;
}

#imgslideDiv {
	width: 1200px;
	height: 600px;
	margin-left : 350px;
	position: relative;
	overflow: hidden;
}


#secondImgDiv{
	float: left;
	margin-top: 50px;
	margin-left: 10px;
 	width: 1040px;
}
#secondImgLi{
	float: right;
	list-style: none;
}
#secondImg{
	float: right;
	width: 250px;
	height: 250px;
}
#scale {
	transform: scale(1);
	-webkit-transform: scale(1);
	-moz-transform: scale(1);
	-ms-transform: scale(1);
	-o-transform: scale(1);
	transition: all 0.3s ease-in-out; 

}

#scale:hover {
	transform: scale(1.2);
	-webkit-transform: scale(1.2);
	-moz-transform: scale(1.2);
	-ms-transform: scale(1.2);
	-o-transform: scale(1.2);
}

#img {
	width: 250px;
	height: 250px;
	overflow: hidden;
	margin-left: 100px;
} 

</style>
<script type="text/javascript">
</script>
</head>
<body>
	<div id="allDiv">
		<div>

				<div id="main">
					<h2 id="mainh2">COFFEE <br>Bean Tree</h2>
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
				
				<div id="imgslideDiv">
					<jsp:include page="/resources/mainjsp/slide.jsp" />
				</div>
			</div>
			
				<div style="width: 995px; height: 60px; margin-left: 50px; margin-top: 10px; 
				background-color: #262626; float: left; text-align: center; font-family: fantasy;">
					<a style="color: white; font-size: 20px;">BEST ITEM</a><br>
					<a style="color: white; font-size: 20px; font-weight: bold;">한눈에 보는 커피 인기상품</a>
				</div>
				
			<div id="img" style="float: left; margin-left: 50px; margin-top: 0px;">
				<div id="scale">
					<a href="http://localhost:9080/zordy/productDetail.do?no=82">
						<img style="width: 250px; height: 250px;" src="./resources/img/81.JPG">
					</a>
				</div>
			</div>
			<div id="img" style="float:left; margin-top: 0px; margin-left: 0px;">
				<div id="scale">
					<a href="http://localhost:9080/zordy/productDetail.do?no=83">
						<img style="width: 250px; height: 250px;"src="./resources/img/83.JPG">
					</a>
				</div>
			</div>
			<div id="img" style="float:left; margin-top: 0px; margin-left: 0px;">
				<div id="scale">
					<a href="http://localhost:9080/zordy/productDetail.do?no=84">
						<img style="width: 250px; height: 250px;" src="./resources/img/84.JPG">
					</a>
				</div>
			</div>
			<div id="img" style="float:left; margin-top: 0px; margin-left: 0px;">
				<div id="scale">
					<a href="http://localhost:9080/zordy/productDetail.do?no=85">
						<img style="width: 250px; height: 250px;" src="./resources/img/85.JPG">
					</a>
				</div>
			</div>
			
		</div>
	</div>

</body>
</html>