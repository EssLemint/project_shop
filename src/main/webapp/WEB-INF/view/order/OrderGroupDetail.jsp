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
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<title>상세 구매내역</title>
<style type="text/css">
table {
    width: 700px;
    height: 100px;
    border-bottom: 1px solid #FFFFFF;   
    border-collapse: collapse;
  }
  th, td {
     border-bottom: 1px solid #444444;
     padding-top: 10px;
     padding-bottom:  10px;
  }
  #orderPage{
	float: left;
	margin-left: 15px;
	font-size:  15px;
 }
 .val{
 	text-align: center;
 }
 .what{
 	text-align: center;
 	background-color: #ffcccc;
 }
 .bttn {
 	border: none;
    color: white;
	background-color: #555555;
	font-size: 16px;
	display: inline-block;
	text-align: center;
    text-decoration: none;
    cursor: pointer;
    width: 80px;
    height: 40px;
    border-radius: 4px;
 }

</style>
<script type="text/javascript">
function goPageOrderList() {
	
	var infoFormObj = document.getElementById('infoForm');
	infoFormObj.submit();
}

</script>
</head>
<body>
<div style="width: 1360px; height: 800px;">
<jsp:include page="/resources/mainjsp/MainPage.jsp"/>
<div id="orderPage">
	<div style="margin-left:  100px;">
		<h1 style="text-align: center;">상세 구매내역</h1>
		<table>
			<tr>
				<td>
					주문번호
				</td>
				<td class="val">
					${orderRequest.ORDERS_NO}
				</td>
			</tr>
			<tr>
				<td>
					구매자
				</td>
				<td class="val">
					${lastMem.name}
				</td>
			</tr>
			<tr>
				<td>
					연락처
				</td>
				<td class="val">
					${orderRequest.ORDERS_PHONE}
				</td>
			</tr>
			<tr>
				<td>
					주소
				</td>
				<td class="val">
					${orderRequest.ORDERS_ADDRESS_MAIN}
				</td>
			</tr>
			<tr>
				<td>
					상세주소
				</td>
				<td class="val">
					${orderRequest.ORDERS_ADDRESS_DETAIL}
				</td>
			</tr>
			<tr>
				<td>
					배송 요구 사항 
					
				</td>
				<td class="val">
					${orderRequest.REQ_DETAIL}
				</td>
			</tr>	
		</table>
		
		
		
			<div style="margin-top: 100px; margin-bottom:  80px;">
				<table>
					<tr>
						<td class="what">
							상품
						</td>
						<td class="what">
							수량
						</td>
						<td class="what">
							가격
						</td>
					</tr>
					<c:set var="sum" value="0"/>
					<c:forEach var="orderGroupDto" items="${orderGroupList}">
						<tr>
							<td>
								${orderGroupDto.PRODUCT_NAME}
							</td>
							<td style="text-align: right">
								${orderGroupDto.PRODUCT_COUNT}개
							</td>
							<td style="text-align: right">
								${orderGroupDto.PRODUCT_PRICE}원
							</td>
						</tr>
					<c:set var ="sum" value="${sum + orderGroupDto.PRODUCT_PRICE}"/>
					</c:forEach>
				</table>
			</div>
			
			<div style="text-align: center; background-color: #ffcccc; width: 700px; height: 50px">
				 금액  
				<div>
					${sum}원
				</div>
			</div>
			
			<div style="text-align: center; margin-top: 40px;">
				<input class="bttn" type="button" name="back" value="확인" onclick="goPageOrderList();" style="margin-right: 30px;">
<!-- 				<input class="bttn" type="button" name="review" value="리뷰 작성" onclick="goPageReviewList();"> -->
			<form id="infoForm" action="./orderHistoryList.do" method="get">
				<input type="hidden" name='startDate' value='${searchMap.startDate}'>
				<input type="hidden" name='endDate' value='${searchMap.endDate}'>
				<input type="hidden" name='curPage' value="${curPage}"> 
			</form>
			</div>
		</div>
</div>	
</div>
	
</body>
</html>