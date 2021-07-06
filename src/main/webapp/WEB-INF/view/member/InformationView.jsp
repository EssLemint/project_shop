<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록 조회</title>

<style type="text/css">
#oneDiv{
	float: left;
	width: 550px;
	height: 420px;
	margin-top: 120px;
}
#oneh2{
	margin-left: 50px;
	font-size: 40px;
	font-weight: normal;
}
#oneli{
	font-size: 30px;
	width: 400px;
	list-style: none;
	margin-bottom: 20px;
	margin-left: 160px;
	float: left;
}
#twoDiv{
	float: left;
	width: 500px;
	height: 330px;
	margin-top: 210px;
	margin-left: 100px;
}
#twoli{
	font-size: 30px;
	width: 500px;
	list-style: none;
	margin-bottom: 20px;	
}
input{
	font-size: 12px;
}
#butli{
	list-style: none;
}
#loginBtn {
	width: 300px;
	height: 40px;
	border: 0;
	outline: 0;
	color: #FFF;
	background-color: #9ececc;
}
</style>
<script type="text/javascript">
	function update(no) {
	location.href= './uUpdate.do?no=' + no
}
	
</script>
</head>

<body>

	
	<jsp:include page="/resources/mainjsp/MainPage.jsp"/>
	<div style="width: 1500px; height: 800px;">	
		<div id="oneDiv">
			<h2 id="oneh2">회원 정보</h2>
			<ul>
				<li id="oneli">아이디
				<input id="oneinput" type="text" style="width: 200px; height: 30px; margin-left: 50px;" value="${memberDto.id}" readonly="readonly"> 
				</li>
				<li id="oneli">패스워드
				<input id="oneinput" type="password" style="width: 200px; height: 30px; margin-left: 20px;" value="${memberDto.pass}" readonly="readonly"> 
				</li>
				<li id="oneli">연락처
				<input id="oneinput" type="text" style="width: 200px; height: 30px; margin-left: 50px;" value="${memberDto.phone}" readonly="readonly"> 
				</li>
				<li id="oneli">상세주소
				<input type="text" id="twoinput" name="addressDetail"
				style="width: 200px; height: 30px; margin-left: 20px;" value="${memberDto.addressDetail}" readonly="readonly"> 
				</li>
			</ul>
		</div>
		<div id="twoDiv">
			<ul>
				<li id="twoli">이름
				<input type="text" id="twoinput" style="width: 200px; height: 30px; margin-left: 50px;" value="${memberDto.name}" readonly="readonly"> 
				</li>
				<li id="twoli">이메일
				<input type="text" id="twoinput" style="width: 200px; height: 30px; margin-left: 20px;" value="${memberDto.email}" readonly="readonly"> 
				</li>
				<li id="twoli">주소
				<input id="oneinput" type="text" style="width: 200px; height: 30px; margin-left: 50px;" value="${memberDto.addressMain}" readonly="readonly"> 
				</li>
			</ul>
		</div>
		<div>
			<input style="margin-left: 490px;" id="loginBtn" type="button" value="수정" onclick="update(${memberDto.no});">
			
		</div>
			</div> 
			
		
			
			
</body>
</html>