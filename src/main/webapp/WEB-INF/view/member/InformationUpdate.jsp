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
	width: 600px;
	height: 420px;
	margin-top: 100px;
}
#oneh2{
	margin-left: 50px;
	font-size: 40px;
	font-weight: normal;
}
#oneli{
	font-size: 20px;
	width: 500px;
	list-style: none;
	margin-bottom: 20px;
	margin-left: 160px;
	float: left;
}
#twoDiv{
	float: left;
	width: 500px;
	height: 330px;
	margin-top: 200px;
	margin-left: 100px;
}
#twoli{
	font-size: 20px;
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
function passChk() {
	
	var nowPass = document.getElementById("nowPass")
	var newPass = document.getElementById("newPass")
	var newPassChk = document.getElementById("newPassChk")
	
	if (nowPass.value != ${memberDto.pass}) {
		alert("현재 패스워드가 다릅니다. 확인해주세요!");
		nowPass.focus();
		return false;
	}else if (newPass.value != newPassChk.value) {
		alert("변경할 패스워드 와 패스워드 확인란이 다릅니다. 다시한번 확인해주세요!");
		return false;
	}else if (newPass.value.length <= 3 || newPass.value.length >= 21) {
		alert("패스워드는 4~20 자 입니다.")
		document.newPass.focus();
		document.newPass.select();
		return false;
	}
	
	formObj.submit();
	return true;
}

</script>
</head>

<body>

	
	<jsp:include page="/resources/mainjsp/MainPage.jsp" />
	<div style="width: 1600px; height: 800px;">	
		<form action="./uMemberUpdateCtr.do" id="formObj" method="post">
		<div id="oneDiv">
			<h2 id="oneh2">회원 정보 수정</h2>
			<ul>
				<li id="oneli">아이디
				<input id="oneinput" type="text" name="id"
				style="width: 200px; height: 30px; margin-left: 180px; margin-top: 20px;" value="${memberDto.id}" readonly="readonly"> 
				</li>
				<li id="oneli">현재 패스워드
				<input id="nowPass" type="password" id="nowPass" style="width: 200px; height: 30px; margin-left: 115px;" value=""> 
				</li>
				<li id="oneli">변경할 패스워드
				<input type="password" id="newPass" name="pass"
				style="width: 200px; height: 30px; margin-left: 95px;" value="" > 
				</li>
				<li id="oneli">변경할 패스워드 확인
				<input id=newPassChk type="password" 
				style="width: 200px; height: 30px; margin-left: 50px;" value=""> 
				</li>
			</ul>
		</div>
		<div id="twoDiv">
			<ul>
				<li id="twoli">이름
				<input type="text" id="twoinput" name="name" style="width: 200px; height: 30px; margin-left: 60px;" value="${memberDto.name}" readonly="readonly"> 
				</li>
				<li id="twoli">이메일
				<input type="email" id="twoinput" name="email"
				style="width: 200px; height: 30px; margin-left: 40px;" value="${memberDto.email}"> 
				</li>
				<li id="twoli">주소
				<input id="oneinput" type="text" name="addressMain"
				style="width: 200px; height: 30px; margin-left: 60px;" value="${memberDto.addressMain}"> 
				</li>
				<li id="twoli">상세주소
				<input type="text" id="twoinput" name="addressDetail"
				style="width: 200px; height: 30px; margin-left: 20px;" value="${memberDto.addressDetail}"> 
				</li>
				<li id="twoli">연락처
				<input id=newPassChk type="number" name="phone" 
				style="width: 200px; height: 30px; margin-left: 40px;" value="${memberDto.phone}"> 
				</li>
			</ul>
		</div>
		<div>
			<input type="hidden" name="no" value="${memberDto.no}">
			<input type="hidden" name="point" value="${memberDto.point}" readonly="readonly"> 
			<input style="margin-left: 490px;" id="loginBtn" type="button" value="수정 완료" onclick="passChk();">
		</div>
		</form>
	</div>
</body>
</html>