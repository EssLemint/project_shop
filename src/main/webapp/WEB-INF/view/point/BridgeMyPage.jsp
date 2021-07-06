<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<script type="text/javascript">
	window.onload = function () {
		opener.parent.location = formObj.submit();
		opener.parent.location.reload();
		window.opener = self;
		self.close();




		
// 		formObj.submit();
	}

</script>
<title></title>
</head>
<body>
	<div>
		<form action="./myPage.do" id="formObj" method="post">
			<input type="hidden" name="no" value="${memberDto.no}">
<%-- 			<input type="hidden" name="point" value="${memberDto.point}"> --%>
		</form>
	</div>
</body>
</html>