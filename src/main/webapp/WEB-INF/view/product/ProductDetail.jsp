 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 상세</title>
<script type="text/javascript" 
	src="/zordy/resources/js/jquery-3.4.1.min.js"></script>

<style>

#product{
	
	float: left;
	margin-top: 80px;
	margin-left: 45px;
	width: 1000px;
	height: 600px;
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
    width: 85px;
    height: 30px;
    border-radius: 4px;
    margin-right: 15px;
 }
 
</style>
<script type="text/javascript">
function pageMoveUpdateFnc(no){
	var url = 'productUpdate.do?no=' + no;
	location.href = url;
}

function pageMoveListFnc(){
	var url = 'productList.do';
	location.href = url;
}

function pageMoveBasket(){
	var url = 'basketAdd.do';
	var productInfoForm = document.getElementById('productInfoForm');
	
	productInfoForm.action = url;
	productInfoForm.submit();
}

function addChk() {
	
	var formObj = document.getElementById("productInfoForm");
	var stockObj = document.getElementById("stocks").value;
	var countObj = document.getElementById("count").value;
	
	// 수량 검사
	if (stockObj < countObj) {
		alert("알맞은 수량을 입력해주세요");
		return false;
	}
	
	formObj.submit();
}

</script>
</head>
<body>
<div style="width: 1500px; height: 700px;">
	<c:choose>
		<c:when test="${sessionScope.memberDto.isAdmin == 1}">
			<jsp:include page="/resources/mainjsp/AdminMainPage.jsp"/>
		</c:when>
		<c:otherwise>
			<jsp:include page="/resources/mainjsp/MainPage.jsp"/>
		</c:otherwise>
	</c:choose>


	<div id="product">
		<form  id="productInfoForm" action='./orderOne.do' onsubmit="return false;" method='get'>
		<div style="float: left; width: 450px;">
				<c:choose>
					<c:when test="${empty fileList}">
						첨부파일이 없습니다.<br>
					</c:when>
				<c:otherwise>
					<c:forEach var="file" items="${fileList}">
						<img alt="image not found" style="width: 400px; height: 400px;"
						src="<c:url value='/img/${file.P_IMAGE_STORED_FILE_NAME}'/>"/>
							<br>
						</c:forEach>
					</c:otherwise>
				</c:choose>
		</div>
		<div style="width: 350px; float: right; margin-right: 200px;">
			<hr style="width: 500px; border: 1px solid black;">
					<div style="margin-bottom: 10px; margin-top: 30px;">
						<span style="margin-right: 45px; font-family: fantasy;">
							상품명
						</span> 
						<span>
							${productDto.name}
						</span>
					</div>
					<div style="margin-bottom: 10px;">
						<c:choose>
							<c:when test=" ${productDto.stock < 0 }">
								<span style="margin-right: 23px;">
									남은 수량
								</span>
								<span >
									 0개
								</span>
							</c:when>
							<c:otherwise>
								<span style="margin-right: 23px;">
									남은 수량
								</span>
								<span>
									${productDto.stock}개
								</span>
							</c:otherwise>
						</c:choose>

					</div>
					<div style="margin-bottom: 10px;">
						<span style="margin-right: 25px;">
							구매 수량
						</span>
						<span>

							<input type="text" id="count" name="count" value="1" min="1">

<!-- 							<input type="text" name="count" placeholder="1"> -->

<!-- 							<input type="number" style="width: 50px;" id="count" name="count" placeholder="1" onchange="priceupdate();"> -->

						</span>
					</div>
					<div style="margin-bottom: 50px;">
						<span style="margin-right: 60px;">
							금액
						</span>
						<span>
							 <fmt:formatNumber value= "${productDto.price}"/>원
						</span>
					</div>
						<a style="text-align: center;">상품 상세 설명</a>
				<div style="width: 500px; height: 300px; border: 1px solid black; margin-top: 20px; margin-bottom: 20px;">
						 <p style="margin: 10px;"> ${productDto.detail} </p> 
				</div>
								

				
				<div style="margin-bottom: 10px;">
					<c:choose>
						<c:when test="${sessionScope.memberDto.isAdmin == 1}">
							<input class="bttn" type='button' value='수정' onclick='pageMoveUpdateFnc(${productDto.no});'> 
							<input type="hidden" name='no' value='${productDto.no}'>
						</c:when>
						<c:otherwise>
							<input class="bttn" type='button' value='구매' onclick="addChk()"> 
							<input class="bttn" type='button' value='장바구니 담기' onclick="pageMoveBasket();"> 
							<input class="bttn" type='button' value='이전페이지' 	onclick='pageMoveListFnc();'> 
							<input type="hidden" name='no' value='${productDto.no}'>
						</c:otherwise>
					</c:choose>	
					<input type="hidden" name='no' value='${productDto.no}'>
					<input type="hidden" id='stocks' name='stocks' value='${productDto.stock}'>
				</div>
				
				
			</div>
		</form>
	</div>
</div>
</body>
</html>