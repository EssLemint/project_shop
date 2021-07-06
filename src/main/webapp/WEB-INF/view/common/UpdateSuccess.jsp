<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
	alert('성공적으로 처리했습니다.');
	
	location.href = '/zordy/productDetail.do?no=' + ${productDto.no};
</script>
</body>
</html>