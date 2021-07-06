<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript"
	src="/zordy/resources/js/jquery-3.4.1.min.js"></script>
<title>장바구니</title>
<style>
  table {
    width: 800px;
    height: 100px;
    border-collapse: collapse;
  }
  th, td {
  	height: 50px;
    width: 80px;
    border-bottom: 2px solid #FFFFFF;
    text-align: center;
  }
  #basket{
  	float: left;
	margin-left: 15px;
  }
  .bttn {
 	border: none;
    color: white;
	background-color: #555555;
	font-size: 13px;
	display: inline-block;
	text-align: center;
    text-decoration: none;
    cursor: pointer;
    width: 90px;
    height: 40px;
    border-radius: 4px;
 }
</style>
<script type="text/javascript">
	function deleteProductFnc(id) {
		var url = 'deleteBasketOneCtr.do';
		var objForm = document.getElementById('basketInfoForm');
		var htmlStr = '';
		
		htmlStr += '<input type="hidden" name="id" value=" '+ id +' ">';		
		objForm.innerHTML = objForm.innerHTML + htmlStr;
		
		objForm.action = url;
		objForm.submit();
	}
	function goProductListFnc(){
		var url = 'productList.do';
		location.href = url;
	}
</script>
</head>
<body>
<div style="width: 1360px; height: 800px;">
<jsp:include page="/resources/mainjsp/MainPage.jsp"/>
<div id="basket" style="margin-left:  50px; margin-top:  30px;">
	<h1 style="text-align: center;">장바구니</h1>
	<form id="basketInfoForm" action="./buyBasket.do" method="post">
			<div id="basketTable">
				<table>
					<tr style="background-color: #ffcccc; font-weight: 700;">
						<td>
							NO
						</td>
						<td>
							상품명
						</td>
						<td>
							가격
						</td>
						<td>
							수량
						</td>
						<td>
							삭제
						</td>
					</tr>
					<c:set var="sum" value="0"/>
					<c:set var="rowNum" value="1"/>
					<c:forEach var="basketDto" items="${basketList}">
						<tr>
							<td>
								${rowNum}
							</td>
							<td>
								${basketDto.name}
							</td>
							<td>
								${basketDto.totalPrice}원
							</td>
							<td>
								${basketDto.productCount}
							</td>
							<td>
								<input class="bttn" type="button" value="삭제" 
									onclick="deleteProductFnc(${basketDto.id});" style=" width: 60px; height: 30px; font-size: 12px;">
							</td>
						</tr>
						<c:set var ="rowNum" value="${rowNum + 1}"/>
						<c:set var ="sum" value="${sum + basketDto.totalPrice}"/>
					</c:forEach>
					
					<tr style="background-color: #ffcccc;">
						<td colspan="5" style="text-align: right; border-bottom: 1px solid black;">
						총 금액  <c:out value="${sum}"/> 원
						</td>
					<tr>
					<tr style="background-color: #ffcccc;">
						<td colspan="5" style="text-align: right; border-bottom: 1px solid black;"> 	
						나의 포인트  ${memberDto.point}원
						</td>
					<tr>
					<tr style="background-color: #ffcccc;">
						<td colspan="5" style="text-align: right;">
						<c:choose>
							<c:when test="${(memberDto.point - sum) < 0}">
								구매 후 포인트  0
							</c:when>
							<c:otherwise>
								구매 후 포인트  ${memberDto.point - sum} 원
							</c:otherwise>
						</c:choose>
						</td>
					<tr>
				</table>
			</div>
		<div style="margin-top: 40px;">	
			<span style="margin-right: 60px; margin-left: 300px;">
				<input class="bttn" type="submit" value="구매하기">
			</span>
			<span>
				<input class="bttn" type="button" name="back" value="계속 쇼핑하기"  onclick="goProductListFnc();">
			</span>
		</div>
		<input type="hidden"  name="no" value="${memberDto.no}">
	</form>
</div>
</div>
</body>
</html>