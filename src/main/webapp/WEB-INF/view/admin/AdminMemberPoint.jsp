<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
table {
	border: 1px solid black;
	border-collapse: collapse;
}

tr, td {
	border-bottom: 1px solid black;
	padding: 15px;
}

/* display: none; */
</style>
<script type="text/javascript">
	
</script>
<title>회원 포인트 내역</title>
</head>
<body>
	
	<jsp:include page="/resources/mainjsp/AdminMainPage.jsp" />
	<div style="width: 1500px; height: 800px; margin: 0;">
		<h2
			style="font-size: 40px; margin-left: 150px; margin-top: 120px; font-weight: normal; float: left;">포인트
			내역</h2>
		<div style="width: 900px; height:440px; float: left; margin-left: 150px;">
			<table id="pointTable" style="margin-top: 0px; float: left;">
				<tr style="background: #ffcccc;">
					<th style="width: 120px; padding: 30px;">번호</th>
					<th style="width: 170px;">변경금액</th>
					<th style="width: 250px;">포인트 변경일</th>
					<th style="width: 220px;">변경 내용</th>
				</tr>
				<c:choose>
				 <c:when test="${pointList == null}">
<!-- 				 조건에 맞으면 수행		 -->
				 </c:when>
				 <c:otherwise>
<!-- 				 아니면 이거를 수행한다. -->
				 </c:otherwise>
				</c:choose>
				<c:forEach var="pointDto" items="${pointList}">
					<tr>
						<td style="text-align: center;"><a>${pointDto.pno}</a></td>
						<td style="text-align: center;">
						<c:if test="${pointDto.route eq '상품 구매'}"> 
						<a>-</a> 
						</c:if>
						<c:if test="${pointDto.route eq '사용자직접충전'}"> 
						<a>+</a> 
						</c:if>
						<a>${pointDto.point}</a>
						</td>
						<td style="text-align: center;"><fmt:formatDate
								value="${pointDto.modifiedDate}" pattern="yyyy-MM-dd HH:mm" /></td>
						<td style="text-align: center;"><a>${pointDto.route}</a></td>
					</tr>
				</c:forEach>
			</table>
			<div id="Blank">
			
			</div>
		</div>
		<div id="paging" style="float: left; margin-left: 150px; width: 830px; margin-top: 100px;">
			<jsp:include page="/WEB-INF/view/point/Paging.jsp">
				<jsp:param value="${pagingMap}" name="pagingMap" />
			</jsp:include>

			<form action="./adminMemberPoint.do" id="pagingForm" method="post">
				<input type="hidden" name="no" value="${userno}">
				<input type="hidden" name="keyword" value="${pagingMap.keyword}">
				<input type="hidden" id='curPage' name='curPage'
					value="${pagingMap.memberPaging.curPage}">
			</form>
		</div>
	</div>
	<script type="text/javascript">
	window.onload = function () {
		var pointTable = document.getElementById("pointTable").childNodes[1];
		var blank = $("#Blank");
		var paging = document.getElementById("paging")
		
		if (${empty pointList}) {
			paging.style.display = "none";
			var htmlStr = "";

			htmlStr += '<h2 style="text-align: center; margin-top: 150px;"> 현재 사용자의 이용내역이 없습니다.</h2>';
		
			blank.html(htmlStr);
		}
		
		
		
		
	}
	</script>
</body>
</html>