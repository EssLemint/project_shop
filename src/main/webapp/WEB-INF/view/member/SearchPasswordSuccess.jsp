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
#twoDiv {
	text-align: center;
	margin: auto;
}
input{
	text-align: center; 
	text-decoration: none;
	color: black;
}
</style>
<title>패스워드 찾기 완료</title>
<link rel= "stylesheet" type="text/css" href="./resources/css/NewMemberChk.css">
<style type="text/css">

</style>
<script type="text/javascript">
function returnBtn() {
	location.href= './login.do'

}

</script>
</head>
<body>
	<div style="width: 1000px; height: 800px; margin: auto;">
		<h1 id="coffee">Coffee</h1>
		<h1 id="been">Been Tree</h1>
		<h2>패스워드 찾기 성공</h2>
		<div style="width: 300px; margin-left: 350px;">
			<h3 style="color:black;">패스워드 : ${memberDto.pass}</h3>
			<input type="button" style="margin-left: 0px;" value="확인" onclick="returnBtn()">
		</div>
	</div>
</body>
</html>