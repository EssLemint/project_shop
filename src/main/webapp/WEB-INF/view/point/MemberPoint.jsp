<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<script type="text/javascript">
	window.onload = function () {
		
		alert("포인트 충전이 완료 되었습니다.");
// 		location = "./pointinsert.do?no=" + ${memberDto.no} "&" + "point=" +${memberDto.point};

		formObj.submit();
	}

</script>
<title></title>
</head>
<body>
	<div>
		<form action="./pointinsert.do" id="formObj" method="post">
			<input type="hidden" name="no" value="${memberDto.no}">
			<input type="hidden" name="point" value="${memberDto.point}">
		</form>
	</div>
</body>
</html>