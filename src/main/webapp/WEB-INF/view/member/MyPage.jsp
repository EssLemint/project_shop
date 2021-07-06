<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이 페이지</title>
<script type="text/javascript">

	function view(no) {
		location.href= './uMemberView.do?no=' + no
	}
	function showPopUp(no) {		
		window.open("./memberPoint.do?no="+no, "", "left="+(screen.availWidth-660)/2+",top="+(screen.availHeight-430)/2+", width=490, height=500");
	}
	function pointHistory(no) {
		location.href= './pointHistory.do?no=' + no
	}
	function update(no) {
		location.href= './uUpdate.do?no=' + no
	}
	</script>
</head>
<body> 
	<jsp:include page="/resources/mainjsp/MainPage.jsp" />
	<div style="width: 1500px; height: 800px; margin: 0;">
		<div style="width: 1000px; height: 80px; border: 1px solid #e6e6e6; float: left; margin-left: 30px; margin-top: 100px;">
		     <img alt="human" style="width: 50px; height: 50px; margin-top: 15px; float: left;" src="./resources/img/love.png">
		     	<p style="float: left; margin-top: 29px; font-size: 13px;">저희 쇼핑몰을 이용해주셔서 감사합니다.</p>
		</div>
		<div style="width: 995px; height: 170px; border: 5px solid #e6e6e6; float: left; margin-left: 30px; margin-top: 30px;">
			<ul>
				<li style="width: 480px; list-style: circle; margin-top: 25px;">
					<a>사용가능 포인트</a>
					<a style="float: right;"><fmt:formatNumber value="${memberDto.point}" type="currency" currencyCode="KRW"/></a>
				</li>
				<li style="width: 480px; list-style: circle; margin-top: 30px;">
					<a>포인트 충전</a>
					<input style="float: right; background: white; border: 1px solid #bfbfbf; border-radius: 3px; font-size: 11px;" type="button" 
						value="충전 " onclick="showPopUp(${memberDto.no})">
				</li>
				<li style="width: 480px; list-style: circle; margin-top: 30px;">
					<a>포인트 내역</a>
					<input style="float: right; background: white; border: 1px solid #bfbfbf; border-radius: 3px; font-size: 12px;"
					 type="button" value="조회" onclick="pointHistory(${memberDto.no})">
				</li>
			</ul>
		</div>
		<div style="width: 995px; height: 170px; border: 5px solid #e6e6e6; float: left; margin-left: 30px; margin-top: 30px;">
			<ul>
				<li style="width: 480px; list-style: circle; margin-top: 45px;">
					<a>계정 정보 조회</a>
					<input style="float: right; background: white; border: 1px solid #bfbfbf; border-radius: 3px; font-size: 12px;" type="button" 
						value="조회" onclick="view(${memberDto.no})">
				</li>
				<li style="width: 480px; list-style: circle; margin-top: 40px;">
					<a>계정 정보 수정</a>
					<input style="float: right; background: white; border: 1px solid #bfbfbf; border-radius: 3px; font-size: 11px;" type="button" 
						value="수정 " onclick="update(${memberDto.no});">
				</li>
			</ul>
		</div>
	</div>
</body>
</html>

