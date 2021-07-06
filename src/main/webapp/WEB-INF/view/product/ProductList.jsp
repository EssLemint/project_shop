<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<style type="text/css">
body{
	margin: 0 0px;
}
#allDiv{
	margin: 0 0px;
	width: 1520px;
	height: 1000px;
}
#main{
	width: 300px;
 	height: 900px; 
	float: left; 
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
#option{
/* 	margin-left: 500px; */
  	clear: both;   
}

.oneProduct{
	float: left;
}
#pagging{
/*     clear: both;   */
/*   	width: 700px; */
/*   	margin-left: 500px; */
	
}

.bttn {
 	border: none;
    color: white;
	background-color: #555555;
	font-size: 12px;
	display: inline-block;
	text-align: center;
    text-decoration: none;
    cursor: pointer;
    width: 60px;
    height: 25px;
    border-radius: 4px;
 }
 
 ul{
   list-style:none;
 }
 #userIdDiv{


}



</style>
<script type="text/javascript">

	$(document).ready(function(){
		$("a[id^='lowPrice']").on('click', function(e){
			e.preventDefault();
			lowPriceFnc($(this));
		});
	});
	
	$(document).ready(function(){
		$("a[id^='highPrice']").on('click', function(e){
			e.preventDefault();
			highPriceFnc($(this));
		});
	});
	function addProductFnc() {
		location.href = './productAdd.do';
	}
	
	$(document).ready(function(){
		var heightStr = $('#allProduct').css('height');
	});
	
	var prheight = 300;
	var prwidth  = 300;
	var row = ${fn:length(productList)}/4 + 1;
	var posNum = ${fn:length(productList)}%4;
	var col = 4;
		
	window.onload = function () {
		
			//상품 +
			document.getElementById("allProduct").style.height = prheight * row + "px";
			document.getElementById("allProduct").style.width = prwidth * 4 + "px";
	}
	

</script>
</head>
<body>
<div style="width: 1300px; height:800px;">
	<div>
		<div>
			<c:choose>
				<c:when test="${sessionScope.memberDto.isAdmin != 1}">
					<jsp:include page="/resources/mainjsp/MainPage.jsp"/>
				</c:when>
				<c:otherwise>
					<jsp:include page="/resources/mainjsp/AdminMainPage.jsp"/>
				</c:otherwise>
			</c:choose>
				<div id="allProduct" style="margin-left: 300px; padding-top: 70px;">
					<div style="margin-left: 40px;">
						<h1 style="font-size: 35px;">상품</h1>
					</div>
					<div style="width: 800px; height:50px;">
						<form id="pagingForm" action="./productList.do" method="post">
							<div style="margin-left: 45px; padding-top: 20px;">
								<select id="searchOption" name="searchOption" style="height: 35px; font-family: fantasy;">
									<option value="name" selected="selected" style="height: 30px;">상품명</option>
								</select> 
								<input type="text" id="keyword" name="keyword" value="${searchMap.keyword}"
									placeholder="상품명을 입력해 주세요" style=" width: 300px; height: 30px;"> 
								<input class="bttn" style="" type="submit" value="검색">
							</div>
							</form>
						</div>
						<div style="width: 1100px; height: 400px;">
							<c:forEach var="productDto" items="${productList}">
								<div class="oneProduct">
										<ul>
											<li><a href="./productDetail.do?no=${productDto.no}">
													<img alt="image not found" style="width: 180px; height: 180px;"
													src="<c:url value='/img/${productDto.storedFileName}'/>"/></a>
											</li>
											<li style="text-align: right">${productDto.name}</li>
											<li style="text-align: right"><fmt:formatNumber value= "${productDto.price}"/>원</li>
										</ul>
									</div>
							</c:forEach>
						</div>
						<c:if test="${!empty productList}">
							<div id="pagging" style="position: absolute; top: 800px; margin-left: 300px;">
							  <jsp:include page="/WEB-INF/view/common/Paging.jsp">
									<jsp:param value="${pagingMap}" name="pagingMap" />
								</jsp:include>
							</div>
								<input type="hidden" id='tempCurPage' name='tempCurPage' 
									value="${pagingMap.memberPaging.curPage}">
						</c:if>	
					</div>
				</div>
			
</div>
</div>
</body>
</html>