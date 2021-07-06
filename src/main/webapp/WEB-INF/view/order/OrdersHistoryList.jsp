<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구매내역 리스트</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<style type="text/css">
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
 .memus{
 	margin-right:  100px;
 	font-weight:  bold;
 }
 .val{
 	margin-top: 30px;
 	margin-bottom:  10px;
 }
 #pagging{
 
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
$(document).ready(function() {
	
	
		var startObj = document.getElementById("startDate");
		var endObj = document.getElementById("endDate");
		
		var dateObj = new Date();
		var monthObj = dateObj.getMonth() + 1;
		var yearObj = dateObj.getFullYear();
		var startYMon =  String(yearObj)+ "-" + String(monthObj)+ "-" + "01";
		var endYMon = String(yearObj)+ "-" + String(monthObj)+ "-" +
		(new Date(yearObj, monthObj, 0)).getDate();
	
// 		alert(startYMon);
// 		alert(endYMon);
// 		alert(startObj.value);
// 		alert(endObj.value);
		
		if(startObj.value == "" && endObj.value == ""){		
			document.getElementById("startDate").value = startYMon;
			document.getElementById("endDate").value = endYMon;
		}if(startObj.value == "" && endObj.value != ""){	
			document.getElementById("startDate").value = startYMon;			
		}if(startObj.value != "" && endObj.value == ""){
			document.getElementById("endDate").value = endYMon;
		}	
});

</script>
</head>
<body>

<div>
<jsp:include page="/resources/mainjsp/MainPage.jsp"/>

<div style=" width: 1000px; height: 500px; margin-left:  400px;">



	<h1 style=" padding-top: 100px; margin-top: 0px;"></h1>

<%-- 	<h1 style=" padding-top:  100px;">${memberDto.MEMBERS_NAME}님 구매내역</h1> --%>

<%-- 	<h1 style="padding-top: 150px; padding-bottom: 50px; margin: 0 0 0 0px;">${memberName.name}님 구매내역</h1> --%>

	
		<div>
			<form id="pagingForm" action="./orderHistoryList.do" method="post">
			<div>
				<span style=" margin-right:  20px; font-weight: bold;">
					날짜 조회
				</span>
				<span style=" margin-right:  20px;">
				 	<input id="startDate" type="date" name="startDate" value= "${searchMap.startDate}" style="height: 30px;"> - 
				 	<input id="endDate" type="date" name="endDate" value="${searchMap.endDate}" style="height: 30px;">
				</span>
				<span>
					<input class="bttn" type="submit" value="검색">
				</span>
			</div>
			</form>
			
			<div>
				<table style="width: 800px; height: 300px; margin-top: 30px; ">
					<tr style="text-align: center; background: #ffcccc;">
						<td class="memus">
							주문번호
						</td>
						<td class="memus">
							주문내역
						</td>
						<td class="memus">
							금액
						</td>
						<td  class="memus">
							구매날짜
						</td>
						<td>
						</td>
					</tr>
					<c:choose>
						<c:when test="${empty ordersMemberList}">
								<tr>
									<td colspan="5" style="text-align: center; border-color: black" >
										검색 결과가 없습니다.
									</td>
								</tr>
						</c:when>
					<c:otherwise>
<!-- 					<hr style="border: none; border: 3px double black; width: 800px; margin-left: 0px"> -->
						<c:forEach var="ordersMemberDto" items="${ordersMemberList}">
							<tr>
								<td style="text-align: center;">
									${ordersMemberDto.ORDERS_NO}
								</td>
								<td style="text-align: left;">
									<a href="./orderGroupDetail.do?no=${ordersMemberDto.ORDERS_NO}
									&curPage=${pagingMap.memberPaging.curPage}
									&startDate=${searchMap.startDate}
									&endDate=${searchMap.endDate}">${ordersMemberDto.TITLE} 
										<c:if test="${ordersMemberDto.COUNT > 1 }">등 ${ordersMemberDto.COUNT }개</c:if>
				                  	</a>
								</td>								
								<td style="text-align: center;">
									${ordersMemberDto.ORDERS_TOTAL_PRICE}원
								</td>
								<td style="text-align: center;">
									<fmt:formatDate value="${ordersMemberDto.ORDERS_DATE}" pattern="yyyy.MM.dd HH:MM" />
								</td>
								<td>
<!-- 									<input class ="bttn" type="button" name="revBtn"  -->
<!-- 									value="리뷰 작성" onclick="gotoOrderDetailFnc();"> -->
								</td>
							</tr>
						</c:forEach>
					</c:otherwise>
					</c:choose>
				</table>
			</div>
		
		</div>
	</div>
	<c:if test="${!empty ordersMemberList}">
		<div style="width: 800px; height: 100px; margin-left: 250px;">
			<div id="pagging" style="position: relative; margin-left: 250px; margin-top: 200px;">
			  <jsp:include page="/WEB-INF/view/common/Paging.jsp">
					<jsp:param value="${pagingMap}" name="pagingMap" />
				</jsp:include>
			</div>
				<input type="hidden" id='tempCurPage' name='tempCurPage' 
				value="${pagingMap.memberPaging.curPage}">
		</div>	
	</c:if>	
</div>

	

</body>
</html>