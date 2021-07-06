<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 전체 구매 리스트</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
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
 	font-weight: bold;
 }
 .val{
 	margin-top: 30px;
 	margin-bottom:  10px;
 }
 #pagging{
 
 }
 table{
	border-collapse: collapse;
 }
 tr{
 
 }
 
 td{
 
 border-bottom: 1px solid black;
 }

#userIdDiv{
	margin-right: 300px;
}
</style>

<script type="text/javascript">
// $(document).ready(function() {
// 	var startObj = document.getElementById("startDate");
// 	var endObj = document.getElementById("endDate");
	
// 		var dateObj = new Date();
// 		var monthObj = dateObj.getMonth() + 1;
// 		var yearObj = dateObj.getFullYear();
// 		var startYMon =  String(yearObj)+ "-" + String(monthObj)+ "-" + "01";
// // 		var endYMon =  String(yearObj)+ "-" + String(monthObj)+ "-" + "31";
// 		var endYMon = String(yearObj)+ "-" + String(monthObj)+ "-" +
// 							(new Date(yearObj, monthObj, 0)).getDate();
// 		//AdminProductList 에도 수정 필요
		
// 		document.getElementById("startDate").value = startYMon;
// 		document.getElementById("endDate").value = endYMon;		
// });

</script>
</head>
<body>

<div>
<jsp:include page="/resources/mainjsp/AdminMainPage.jsp"/>

<div style=" width: 1000px; height: 500px; margin-left:  400px;">


	<h1 style="padding-top: 150px; padding-bottom: 50px; margin: 0 0 0 0px;">구매내역 조회</h1>
	
		<div>
			<form id="pagingForm" action="./memberOrderAllHistory.do" method="post">
				<div>
					<span>
						<select id="searchOption" name="searchOption" style="height: 35px;">
							<option value="id" selected="selected" style="height: 30px;">회원 ID</option>
						</select> 
					</span>
					<span>
						<input type="text" id="keyword" name="keyword" value="${searchMap.keyword}"
								placeholder="회원 ID" style=" width: 300px; height: 30px;"> 
						<input class="bttn" type="submit" value="검색">
					</span>
				</div>
			</form>
			
			<div>
				<table style="width: 800px; height: 300px; margin-top: 30px;">
					<tr style="text-align: center; background: #ffcccc; height: 50px;">
						<td class="memus" style="width: 100px;">
							주문번호
						</td>
						<td class="memus" style="width: 300px;">
							주문내역
						</td>
						<td class="memus" style="width: 150px;">
							회원ID
						</td>
						<td class="memus" style="width: 150px;">
							금액
						</td>
						<td  class="memus" style="width: 120px;">
							구매날짜
						</td>
						<td>
						</td>
					</tr>
					<c:choose>
					<c:when test="${empty allOrdersList}">
								<tr>
									<td colspan="5" style="text-align: center; border-color: black" >
										검색 결과가 없습니다.
									</td>
								</tr>
						</c:when>
						<c:otherwise>
<!-- 					<hr style="border: none; border: 3px double black; width: 800px; margin-left: 0px"> -->
						<c:forEach var="allOrdersDto" items="${allOrdersList}">
							<tr>
								<td style="text-align: center;">
									${allOrdersDto.ORDERS_GROUP}
								</td>
								<td style="text-align:  center;">
<%-- 									<a href="./orderGroupDetail.do?no=${allOrdersDto.ORDERS_NO} --%>
<%-- 									&curPage=${pagingMap.memberPaging.curPage} --%>
<%-- 									&searchOption=${searchMap.searchOption} --%>
<%-- 									&keyword=${searchMap.keyword}" --%>
<!-- 									>	 -->
										${allOrdersDto.TITLE}
										<c:if test="${allOrdersDto.COUNT > 1 }">등 ${allOrdersDto.COUNT}개</c:if>
<!-- 									</a> -->
								</td>
								<td style="text-align: center;">
									${allOrdersDto.MEMBERS_ID}
								</td>
								<td style="text-align: center;">
								
								<fmt:formatNumber value="${allOrdersDto.SUM}" type="number"/>원
								</td>
								<td style="text-align: center;">
									<fmt:formatDate value="${allOrdersDto.ORDERS_DATE}" pattern="yyyy.MM.dd HH:MM" />
								</td>
							</tr>
						</c:forEach>
					</c:otherwise>
					</c:choose>
				</table>
			</div>
		
		</div>
	</div>
	<c:if test="${!empty allOrdersList}">
		<div style="width: 800px; height: 100px; margin-left: 250px;">
			<div id="pagging" style="position: relative; margin-left: 250px; margin-top: 230px;">
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