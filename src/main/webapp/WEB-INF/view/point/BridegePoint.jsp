<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title></title>
<script type="text/javascript">
	window.onload = function () {
		
		
		alert("구매가 완료 되었습니다.")
		form.submit();
	}	
</script>
</head>
<body>
	<form action="./orderpointinsert.do" method="post" id="form">
		<input type="hidden" name="no" value="${memberDto.no}">
		<input type="hidden" name="point" value="${productDto.price}">
		<input type="hidden" name="count" value="${count}">
		<input type="hidden" name="totalPrice" value="${productDto.price * count}">
		<input type="hidden" name="productNo" value="${productDto.no}"> 	
		<input type="hidden" name="name" value="${productDto.name}"> 	
		<input type="hidden" name="price" value="${productDto.price}"> 	
	</form>
</body>
</html>