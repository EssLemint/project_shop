<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니 상세</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
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
 	background-color: #BDBDBD;
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
					${ordersList.ORDERS_NO}
				</td>
			</tr>
			<tr>
				<td>
					구매자
				</td>
				<td class="val">
					${memberDto.name}
				</td>
			</tr>
			<tr>
				<td>
					연락처
				</td>
				<td class="val">
					${orderRequestList.ordersPhone}
				</td>
			</tr>
			<tr>
				<td>
					주소
				</td>
				<td class="val">
					${orderRequestList.ordersAddressMain}
				</td>
			</tr>
			<tr>
				<td>
					상세주소
				</td>
				<td class="val">
					${orderRequestList.ordersAddressDetail}
				</td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: center;">
					배송 요구 사항 <br>
					${orderRequestList.REQ_DETAIL}
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
					<c:forEach var="ordersBasketDto" items="${ordersBasketList}">
						<tr>
							<td>
								${ordersBasketDto.PRODUCT_NAME}
							</td>
							<td style="text-align: right">
								${ordersBasketDto.productCount}개
							</td>
							<td style="text-align: right">
								${ordersBasketDto.totalPrice}원
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			
			<div style="text-align: center; background-color: #A6A6A6; width: 700px; height: 50px">
				 금액  
				<c:choose>
					<c:when test="${totalPrice < 0}">
						금액이 부족합니다.
					</c:when>
					<c:otherwise>
						<div>
						${totalPrice}원
						</div>
					</c:otherwise>
				</c:choose>
			</div>
			
			<div style="text-align: center; margin-top: 40px;">
				<input class="bttn" type="button" name="back" value="확인" onclick="goPageOrderList(${memberDto.no});" style="margin-right: 30px;">
				<input class="bttn" type="button" name="review" value="리뷰 작성" onclick="goPageReviewList();">
			</div>
		</div>
</div>	
</div>
	
</body>
</html>