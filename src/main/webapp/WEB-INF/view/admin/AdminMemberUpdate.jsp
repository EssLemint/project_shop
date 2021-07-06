<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 수정</title>

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
	margin-top: 230px;
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
</script>
</head>

<body>

	
	<jsp:include page="/resources/mainjsp/AdminMainPage.jsp" />
		<div style="width: 1500px; height: 800px;">
		<form action="./updateCtr.do" method="post">
		<div id="oneDiv">
			<h2 id="oneh2">회원 정보 수정</h2>
			<ul>
				<li id="oneli">회원번호
				<input id="oneinput" type="text" name="no"
				style="width: 200px; height: 30px; margin-left: 20px;" value="${memberDto.no}" readonly="readonly"> 
				</li>
				<li id="oneli">패스워드
				<input id="oneinput" type="password" style="width: 200px; height: 30px; margin-left: 20px;" value="${memberDto.pass}" readonly="readonly"> 
				</li>
				<li id="oneli">연락처
				<input id="oneinput" type="text" name="phone"
				style="width: 200px; height: 30px; margin-left: 50px;" value="${memberDto.phone}"> 
				</li>
				<li id="oneli">주소
				<input id="oneinput" type="text" name="addressMain"
				style="width: 200px; height: 30px; margin-left: 80px;" value="${memberDto.addressMain}"> 
				</li>
				
			</ul>
		</div>
		<div id="twoDiv">
			<ul>
				<li id="twoli">아이디
				<input type="text" id="twoinput" style="width: 200px; height: 30px; margin-left: 20px;" value="${memberDto.id}" readonly="readonly"> 
				</li>
				<li id="twoli">이름
				<input type="text" id="twoinput" style="width: 200px; height: 30px; margin-left: 50px;" value="${memberDto.name}" readonly="readonly"> 
				</li>
				<li id="twoli">이메일
				<input type="email" id="twoinput" name="email"
				style="width: 200px; height: 30px; margin-left: 20px;" value="${memberDto.email}"> 
				</li>
				<li id="twoli">포인트
				<input type="number" id="twoinput" name="point"
				style="width: 200px; height: 30px; margin-left: 20px;" value="${memberDto.point}"> 
				</li>
			</ul>
		</div>
		<div>
			<input style="margin-left: 490px;" id="loginBtn" type="submit" value="수정 완료">
		</div>
		</form>
			</div>
</body>
</html>