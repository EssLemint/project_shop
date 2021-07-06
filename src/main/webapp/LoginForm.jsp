<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<style type="text/css">
#coffee{
	text-align: center;
	margin-bottom: 0px;
}
#been{
	text-align: center;
	margin-top: 0px;
}

div {
	text-align: center;
}

#id {
	width: 300px;
	height: 35px;
}
#pass {
	width: 300px;
	height: 35px;
	margin-top: 10px;
}
#loginBtn {
	width: 300px;
	height: 40px;
	border: 0;
	outline: 0;
	color: #FFF;
	background-color: #9ececc;
}
ul {
	text-align: center;
}

li {
	list-style: none;
	display: inline-block;
	margin-right: 50px;
}
#aTag{
	font-size : 11px;
	text-decoration: none;
	color: gray;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
</script>
</head>
<body>
	<h1 id="coffee">Coffee</h1>
	<h1 id="been">Been Tree</h1>
	<div id="onediv">
	
		<form action="./loginCtr.do" method="post">
			<input type="text" id="id" name="id" placeholder="아이디"> <br> 
			<input type="password" style="width: 300px; height: 35px; margin-bottom: 10px" id="pass" name="pass" placeholder="패스워드"><br> 
			<input type="submit" id="loginBtn"  value="로그인" onclick="loginChk()"><br>
			<a></a>
		</form>
	</div>
	<hr style="width: 300px; margin-top: 20px;">
	<div>
		<ul>
			<li>
				<a href="./searchId.do" id="aTag">아이디 찾기</a> 
			</li>
			<li>
				<a href="./searchPwd.do" id="aTag">패스워드 찾기</a> 
			</li>
			<li>
				<a href="./newMember.do" id="aTag">회원가입</a>
			</li>
		</ul>
	</div>
	
</body>
</html>