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
/* 	height: 1050px; */
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
#userIdDiv{
float: right;
margin-right: 50px;
}
#option{
/* 	margin-left: 500px; */
  	clear: both;   
}

.oneProduct{
	float: left;
}
#pagging{
/*   	clear: both; */
  	width: 500px;
  	margin-left:  500px;
  	margin-top:  90px;

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
 
table {
	border: 1px solid black;
	border-collapse: collapse;
}

tr, td {
	border-bottom: 1px solid black;
	padding: 15px;
}
table, tr, td, th, a{
	text-decoration: none;
	color: black;
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
	
	var prheight = 380;
	var prwidth  = 300;
	var row = ${fn:length(productList)}/4 + 1;
	var posNum = ${fn:length(productList)}%4;
	var col = 4;
		
	window.onload = function () {
		
		document.getElementById("productTable").style.width = "750px";
// 		document.getElementById("productTable").style.height = "400px";
		document.getElementById("productTable").style.margin = "30px";
		
		document.getElementById("optionAd").style.left =  "-130px";
		document.getElementById("optionAd").style.top =  "-230px";


	}
	

</script>
</head>
<body>
<div style="width: 1360px; height:800px;">

		<jsp:include page="/resources/mainjsp/AdminMainPage.jsp"/>
			<div style="margin-left: 350px;">
				<div style=" padding-left: 30px">
					<h1 style="padding-top: 100px; height: 100px; margin-top: 0px;">?????? ??????</h1>
					<form id="pagingForm" action="./productListAdmin.do" method="post">
						<select id="searchOption" name="searchOption" style="height: 35px; font-family: fantasy;">
							<option value="name" selected="selected">?????????</option>
						</select> 
						<input type="text" id="keyword" name="keyword" value="${searchMap.keyword}"
							placeholder="???????????? ??????????????????" style=" width: 300px; height: 30px;"> 
						<input class="bttn" type="submit" value="??????">
							<input class="bttn" type="button" value="????????????" onclick="addProductFnc()">	
					</form>
					<div id="optionAd" style="margin-top: 30px;">
						<div>
						</div>
					</div>
				
				</div>
					
				<div class="allProduct" style="width: 750px; height: 400px;">
					  <table id="productTable" style="margin-top: 10px;">
					  	<tr style="background-color: #ffcccc; color: #FFFFFF; font-weight: bold;">
					  		<td style="text-align: center;" > 
					  			NO
					  		</td>
					  		<td style="text-align: center;" > 
					  			?????????
					  		</td>
					  		<td style="text-align: center;"> 
					  			??????					  		</td>
					  		<td style="text-align: center;"> 
					  			??????
					  		</td>
					  		<td style="text-align: center;"> 
					  			?????? ?????????
					  		</td>
					  	
					  	</tr>
					  	<c:choose>
							<c:when test="${empty productList}">
									<tr>
										<td colspan="5" style="text-align: center; border-color: black" >
											?????? ????????? ????????????.
										</td>
									</tr>
							</c:when>
						<c:otherwise>
							<c:forEach var="productDto" items="${productList}" varStatus="status">
								  <tr>
								  	<td style="text-align: right;">
								  		no.<c:out value ="${productDto.no}"></c:out>
								  	</td>
								  	<td style="text-align: left;">
								  		<a href="./productDetail.do?no=${productDto.no}">${productDto.name}</a>
								  	</td>
								  	<td style="text-align: right;">
								  		${productDto.stock}???
								  	</td>
								  	<td style="text-align: right;">
							  		<fmt:formatNumber value= "${productDto.price}"/>???
								  	</td>
								  	<td style="text-align: center;">
								  		<fmt:formatDate value="${productDto.modifiedDate}" pattern="yyyy.MM.dd HH:MM" />
								  	</td>
								  </tr>
							  </c:forEach>
						  </c:otherwise>
						  </c:choose>  
						  </table>
					</div>
				</div>
				<c:if test="${!empty productList}">
					<div id="pagging">
					  <jsp:include page="/WEB-INF/view/common/Paging.jsp">
							<jsp:param value="${pagingMap}" name="pagingMap" />
						</jsp:include>
					</div>
						<input type="hidden" id='tempCurPage' name='tempCurPage' 
							value="${pagingMap.memberPaging.curPage}">
				</c:if>
				<div>
					<input id="isAdmin" type="hidden" value="${sessionScope.memberDto.isAdmin}">
				</div>
		</div>
</body>
</html>