<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
function nextWin(){
	alert('재고가 부족합니다   상품 상세페이지로 이동합니다');
	location = "./productDetail.do?no=" + ${productNo};
	
}
</script>
</head>
<body>

<body onLoad="setTimeout('nextWin()', 0)"> <!--1000 이 1초 입니다.-->
	
</body>
</html>