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
table, tr, td, th, a{
	text-decoration: none;
	color: black;
}

#userIdDiv{
	margin-right: 300px;
}
</style>
<script type="text/javascript">
	function returnBut() {
		
	}
</script>
<title>회원 리스트</title>
</head>
<body>

	<jsp:include page="/resources/mainjsp/AdminMainPage.jsp" />
	<div style="width: 1500px; height: 800px; margin: 0;">
		<h2 style="font-size: 40px; margin-left: 150px; margin-top: 120px; float: left; font-weight: bold;">회원 관리</h2>
		<div style="width: 900px; height:440px; float: left; margin-left: 150px;">
			<table style="margin-top: 0px; float: left;">
				<tr style="background: #ffcccc;">
					<th style="width: 120px; padding: 30px;">번호</th>
					<th style="width: 170px;">이름</th>
					<th style="width: 250px;">전화 번호</th>
					<th style="width: 220px;">포인트</th>
					<th style="width: 220px;">최근 수정 날짜</th>
				</tr>
				<c:forEach var="memberDto" items="${memberList}">
					<tr>
						<td style="text-align: center;"><a href='./detail.do?no=${memberDto.no}' title="회원의 자세한 정보를 볼수있습니다.">${memberDto.no}</a></td>
						<td style="text-align: center;"><a>${memberDto.name}</a></td>
						<td style="text-align: center;"><a>${memberDto.phone}</a></td>
						<td style="text-align: center;"><a href='./adminMemberPoint.do?no=${memberDto.no}' title="회원의 포인트 내역을 볼수있습니다.">
							<c:choose>
								<c:when test="${memberDto.point < 0}">
									0
								</c:when>
								<c:otherwise>
									${memberDto.point}
								</c:otherwise>
							</c:choose>
						</a>
						</td>
						<td style="text-align: center;"><fmt:formatDate
								value="${memberDto.modifiedDate}" pattern="yyyy-MM-dd HH:mm" /></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		
		
		<div style="float: left; margin-left: 150px; width: 830px; margin-top: 100px;">
			<jsp:include page="/WEB-INF/view/admin/Paging.jsp">
				<jsp:param value="${pagingMap}" name="pagingMap" />
			</jsp:include>

			<form action="./list.do" id="pagingForm" method="post">
				<input type="hidden" id='curPage' name='curPage'
					value="${pagingMap.memberPaging.curPage}">
			</form>
		</div>
	</div>
</body>
</html>