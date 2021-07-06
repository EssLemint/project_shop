<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
	#coffee{
	text-align: center;
	margin-bottom: 0px;
	}
	#been{
	text-align: center;
	margin-top: 0px;
	margin-bottom: 0px;
	}
h2 {
	text-align: center;
}
h3 {
	text-align: center;
}
input{
	text-align: center; 
	text-decoration: none;
	color: black;
}
</style>
<title>회원 가입 성공</title>
<style type="text/css">

</style>
<script type="text/javascript">
	function okBut() {
		location.href= './login.do';
	}
</script>
</head>
<body>
	<div style="width: 1000px; height: 800px; margin: auto;">
	<h1 id="coffee">Coffee</h1>
	<h1 id="been">Been Tree</h1>
	<h2>회원 가입 성공</h2>
	<div style="width: 300px; margin-left: 350px;">
		<h3 style="color:black;">아이디 : ${memberDto.id}</h3>
		<input type="button" style="margin-left: 130px;" value="확인" onclick="okBut()">
	</div>
	</div>
</body>
</html>