<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
h1{
	text-align: center;
	margin-right: 30px;
	font-weight: normal;
}

div{
	width: 400px;
	height: 350px;
	border: 3px solid #e6e6e6;
}
li{
	list-style: none;
	text-align: center;
	margin-right: 50px;
	margin-bottom: 30px;
}
a{
	margin-right: 80px;
}

</style>
<title>포인트 충전</title>
<script type="text/javascript">

	
	function addPoint() {
// 		alert('??');
		var nowPoint = document.getElementById('nowPoint').value;
		var addPoint = document.getElementById('addPoint').value;
		var afterPoint = document.getElementById('afterPoint');
		var hiddenPoint = document.getElementById('hiddenPoint');
		
		hiddenPoint.value = Number(addPoint);
		afterPoint.value = Number(nowPoint) + Number(addPoint);
		
	}
	
	function postBut() {
		var addPoint = document.getElementById('addPoint');
		
		if (addPoint.value == "") {
			alert("충전 금액을 입력해주세요");
			addPoint.focus();
			return false;
		}else if (addPoint.value >= 100001) {
			alert("충전 금액은 10만을 초과할수 없습니다.");
			addPoint.focus();
			return false;
		}else if (addPoint.value <= 0) {
			alert("충전 금액은 마이너스가 될수 없습니다.")
			addPoint.focus();
			return false;
		}
			formObj.submit();		
	}
	function returnBut() {
		window.close();
	}
</script>
</head>
<body style="overflow-x:hidden; overflow-y:hidden">
	<h1>포인트 충전</h1>
	
		<div>
			<ul>
				<li>
					<a>현재 금액</a><br>
					<input type="text" id="nowPoint" value="${memberDto.point}" readonly="readonly">			
				</li>
				<li>
					<a>충전 금액</a><br>
					<input type="number" id="addPoint" onchange="addPoint()">
				</li>	
				<li>
				<form action="./memberPointUpdate.do" id="formObj" method="post">
					<a>충전 후 금액</a><br>
					<input type="text" id="afterPoint" readonly="readonly">
					<input type="hidden" name="point" id="hiddenPoint">
					<input type="hidden" name="no" value="${memberDto.no}">
				</form>
				</li>
				<li>
					<input type="button" value="충전하기" onclick="postBut();">
					<input type="button" value="취소" onclick="returnBut();">		
				</li>
			</ul>
		</div>
	
</body>
</html>