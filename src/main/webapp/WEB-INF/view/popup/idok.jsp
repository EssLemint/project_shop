<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style type="text/css">
	h2 {
	margin-left: 130px;
	margin-top: 30px;
}
</style>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript">
	window.onload = function() {
		alert("사용가능한 아이디 입니다.");
	}
	function idChk() {
		var idObj = document.getElementById("useid");
		
		if (idObj.value == "") {
			alert("아이디를 입력하세요")
			document.formid.id.focus();
			return false;
    	}else if (idObj.value.length < 4 || idObj.value.length > 15) {
			alert("아이디는 4~15 자 입니다.")
			document.formid.id.focus();
			return false;
    	}else if (idObj.value.indexOf(" ") >= 0) {
            alert("아이디에 공백을 사용할 수 없습니다.")
            document.f.id.focus();
            document.f.id.select()
            return false;
        }
		for (var i = 0; i < idObj.value.length; i++) {
			ch = idObj.value.charAt(i)
        if (!(ch >= '0' && ch <= '9') && !(ch >= 'a' && ch <= 'z')&&!(ch >= 'A' && ch <= 'Z')) {
            alert("아이디는 영문 대소문자, 숫자만 입력가능합니다.")
            document.idObj.focus();
            document.idObj.select();
            return false;
	}
	}
		 formObj.submit();
 		 return true;
	}
	
	function okBut() {
		
	var idObj = document.getElementById("useid");
	var aTag = document.getElementById("aTag");
	
		if (idObj.value == "") {
			alert("아이디 내용 변경시 다시 중복검사가 필요합니다.")
			aTag.innerHTML="아이디 내용 변경시 다시 중복검사가 필요합니다.";
			aTag.style.marginLeft = "80px";
			return false;
    	}else if (idObj.value.length < 4 || idObj.value.length > 15) {
			alert("아이디 내용 변경시 다시 중복검사가 필요합니다.")
			aTag.innerHTML="아이디 내용 변경시 다시 중복검사가 필요합니다.";
			aTag.style.marginLeft = "80px";
			return false;
    	}else if (idObj.value.indexOf(" ") >= 0) {
            alert("아이디 내용 변경시 다시 중복검사가 필요합니다.")
            aTag.innerHTML="아이디 내용 변경시 다시 중복검사가 필요합니다.";
            aTag.style.marginLeft = "80px";
            return false;
        }
		for (var i = 0; i < idObj.value.length; i++) {
			ch = idObj.value.charAt(i)
        if (!(ch >= '0' && ch <= '9') && !(ch >= 'a' && ch <= 'z')&&!(ch >= 'A' && ch <= 'Z')) {
            alert("아이디 내용 변경시 다시 중복검사가 필요합니다.")
            aTag.innerHTML="아이디 내용 변경시 다시 중복검사가 필요합니다.";
            aTag.style.marginLeft = "80px";
            return false;
	}
	}
		
		
		var useid = document.getElementById("useid");
		window.opener.document.getElementById("id").value = useid.value;		
		window.opener = self;
		self.close();
	
	}
</script>
<body style="overflow-x:hidden; overflow-y:hidden">
	<div style="width: 500px; height: 600px;">
		<h2>아이디 중복 검사</h2>
			<form action="./testIdChk.do" id="formObj" method="post">
				<input style="width: 300px; height:20px; margin-left:75px; margin-bottom: 5px;"
				type="text" id="useid" name="id" value="${id}"><br>
				<a id="aTag" style="font-size: 12px; text-align: left; color: red; margin-left: 150px;">
						 사용 가능한 아이디 입니다!!</a>
						<hr style="width: 300px; margin-top: 20px; margin-left: 70px;">
				<ul>
					<li style="list-style: none;">
						<input style="margin-left:100px; margin-right: 20px; margin-top: 20px;" type="button"
						 value="중복 확인" onclick="idChk()">
						<input style=" margin-top: 20px; " type="button" value="사용 하기" onclick="okBut()">
					</li>	
				</ul>
			</form>
	</div>
</body>
</html>