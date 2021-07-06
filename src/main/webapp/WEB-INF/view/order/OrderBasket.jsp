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
<title>장바구니 결제</title>

<style type="text/css">
  table {
 	width: 530px;
    height: 100px;
/*    border:  1px solid black;  */
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
	margin-left: 115px;
 }
 .coloredrow{
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
var mapContainer = document.getElementById('map'), // 지도를 표시할 div
mapOption = {
    center: new daum.maps.LatLng(37.537187, 127.005476), // 지도의 중심좌표
    level: 5 // 지도의 확대 레벨
};

//지도를 미리 생성
var map = new daum.maps.Map(mapContainer, mapOption);
//주소-좌표 변환 객체를 생성
var geocoder = new daum.maps.services.Geocoder();
//마커를 미리 생성
var marker = new daum.maps.Marker({
position: new daum.maps.LatLng(37.537187, 127.005476),
map: map
});


function sample5_execDaumPostcode() {
new daum.Postcode({
    oncomplete: function(data) {
        var addr = data.address; // 최종 주소 변수

        // 주소 정보를 해당 필드에 넣는다.
        document.getElementById("addressMain").value = addr;
        // 주소로 상세 정보를 검색
        geocoder.addressSearch(data.address, function(results, status) {
            // 정상적으로 검색이 완료됐으면
            if (status === daum.maps.services.Status.OK) {

                var result = results[0]; //첫번째 결과의 값을 활용

                // 해당 주소에 대한 좌표를 받아서
                var coords = new daum.maps.LatLng(result.y, result.x);
                // 지도를 보여준다.
                mapContainer.style.display = "block";
                map.relayout();
                // 지도 중심을 변경한다.
                map.setCenter(coords);
                // 마커를 결과값으로 받은 위치로 옮긴다.
                marker.setPosition(coords)
            }
        });
    }
}).open();
}


</script>
</head>
<body>

<div style="width: 1360px; height: 800px;">
	<jsp:include page="/resources/mainjsp/MainPage.jsp"/>
	<div id="orderPage">
		<h1 style="text-align: center;">결제</h1>
		<form action="./orderBasketAddCtr.do" method="post">
			<table style="width: 700px">
				<tr class="coloredrow">
					<td>
						상품명
					</td>
					<td>
						가격
					</td>
					<td>
						수량
					</td>
				</tr>
				<c:set var="sum" value="0"/>
				<c:forEach var="basketDto" items="${basketList}">
					<tr>
						<td style="text-align: left;">
							${basketDto.PRODUCT_NAME}
						</td>
						<td style="text-align: right;">
							${basketDto.PRODUCTPRICE}
						</td>
						<td style="text-align: right;">
							${basketDto.BASKET_PRODUCT_COUNT}개
						</td>
					</tr>
				<c:set var ="sum" value="${sum + basketDto.BASKET_TOTAL_PRICE}"/>
				</c:forEach>
				<tr>
					<td style="text-align: left;">
						총금액 
					</td>
					<td colspan="2" style="text-align: right;">
						 ${sum} 원
					</td>
				</tr>
				<tr>
					<td style="text-align: left;">
						나의 마일리지
					</td>
					<td colspan="2" style="text-align: right; ">
						  ${memberDto.point} 원
					</td>
				</tr>
				<tr>
					<td style="text-align: left;">
						구매후 마일리지
					</td>
					<td colspan="2" style="text-align: right;">
						<c:choose>
							<c:when test="${sum > memberDto.point}">
								금액이 부족합니다.
							</c:when>
							<c:otherwise>
								${memberDto.point - sum} 원
							</c:otherwise>
						</c:choose>
					</td>
					
				</tr>
			</table>
			<div style="background-color: #ffcccc; margin-top: 50px; margin-bottom:  80px; height: 300px;">
				<div>
					<h2 style="text-align: center;">배송정보</h2>
				</div>
				<div>
					<div id="memAddress">
						<div style="margin: 35px;">
							<span style="margin-right: 300px;">
								배송받을 주소
							</span>
							<span>
								<input type="text" id="addressMain" value="${memberDto.addressMain}" name= "addressMain">
								<input class="bttn" type="button" name="address" 
										value="주소찾기" onclick="sample5_execDaumPostcode()"
										style="width: 60px; height: 25px; font-size: 12px;">
							</span>
						</div>
					</div>
					<div style="margin: 35px;">
						<span style="margin-right: 337px;">
							상세주소
						</span>
						<span>
							<input type="text" id="addressDetail" value="${memberDto.addressDetail}" name="addressDetail">
						</span>
					</div>
				</div>
				<div>
					<div style="margin: 35px;">
						<span style="margin-right: 300px;">
							연락받을 번호 
						</span>
						<span>
							<input type="text" value="${memberDto.phone}" name="orderPhone">
						</span>
					</div>
				</div>
				<div>
					<div style="margin: 35px;">
						<span style="margin-right: 300px;">
								배송 요구사항
						</span>
						<span>
								<select name="requestDetail">
								<c:choose>
									<c:when test="${requestDetail == '1'}">
									    <option value='1' selected="selected">부재시 경비실에 부탁드립니다.</option>
									    <option value='2'>배송시 연락 부탁드립니다.</option>
									    <option value='3'>빠른 배송 부탁드립니다.</option>
									</c:when>
									<c:when test="${requestDetail == '2'}">
									    <option value='1'>부재시 경비실에 부탁드립니다.</option>
									    <option value='2' selected="selected">배송시 연락 부탁드립니다.</option>
									    <option value='3'>빠른 배송 부탁드립니다.</option>
									</c:when>
									<c:when test="${requestDetail == '3'}">
									    <option value='1'>부재시 경비실에 부탁드립니다.</option>
									    <option value='2'>배송시 연락 부탁드립니다.</option>
									    <option value='3' selected="selected">빠른 배송 부탁드립니다.</option>
									</c:when>
								</c:choose>
							</select>
						</span>
					</div>
				</div>
			</div>
			
			<div style=" text-align: center; margin-top: 30px; ">
				<input class="bttn" type="submit" name="buy" value="결제" style="margin-right: 30px;">
			</div>
				<input type="hidden" name="no" value="${memberDto.no}">
				<input type="hidden" name="sum" value="${sum}">
		</form>		
	</div>
	</div>

</body>
</html>