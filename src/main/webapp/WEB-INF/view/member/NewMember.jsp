<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
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
	h2{
	text-align: center;
	}
	div{
	text-align: center;
	}
	li{
	list-style: none;
	}
	#id{
	width : 275px;
	height : 35px;
	font-size: 12px;
	}
	#email{
	width : 350px;
	height : 35px;
	font-size: 12px;
	}
	#pass{
	width : 350px;
	height : 35px;
	font-size: 12px;
	}
	#passwordchk{
	width : 350px;
	height : 35px;
	margin-bottom: 15px;
	font-size: 12px;
	}
	#addressMain{
	height : 35px;
	font-size: 12px;
	}
	#addressDetail{
	width : 350px;
	height : 35px;
	font-size: 12px;
	}
	#name{
	width : 350px;
	height : 35px;
	font-size: 12px;
	}
	#phone{
	width : 350px;
	height : 35px;
	font-size: 12px;
	}
	#signup{
	margin-right: 60px;
	width: 100px;
	height: 25px;
	border: 0;
	outline: 0;
	color: #FFF;
	background-color: #9ececc;
	}
	#returnpage{
	width: 100px;
	height: 25px;
	border: 0;
	outline: 0;
	color: #FFF;
	background-color: #9ececc;
	
	}

</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    function sample5_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                var addr = data.address; // 최종 주소 변수

                // 주소 정보를 해당 필드에 넣는다.
                document.getElementById("addressMain").value = addr;
            }
	        
        }).open({
        	autoClose: true
        });
  
   
    }
    
    function joinChk() {
		
    	var formObj = document.getElementById("form");
    	var idObj = document.getElementById("id");
    	var nameObj = document.getElementById("name");
    	var passObj = document.getElementById("pass");
    	var passChkObj = document.getElementById("passwordchk");
     	var addressMainObj = document.getElementById("addressMain");
     	var addressDetailObj = document.getElementById("addressDetail");
    	var emailObj = document.getElementById("email");
    	var phoneObj = document.getElementById("phone");
    	
    	// 아이디 검사
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
    	// 이름 검사
    	if (nameObj.value =="") {
    		alert("이름을 입력해주세요")
			document.getElementById("nameA").innerHTML="이름을 입력해주세요";
			document.nameObj.focus();
			document.nameObj.select();
			return false;
		}
    	if (nameObj.value.length < 2 ||nameObj.value.length > 7) {
    		alert("이름은 2~6자 까지 입력 가능합니다.")
    		document.getElementById("nameA").innerHTML="이름은 2~6자 까지 입력 가능합니다.";
			document.nameObj.focus();
			document.nameObj.select();
			return false;
		}
    	for (var i = 0; i < nameObj.value.length; i++) {
			ch = nameObj.value.charAt(i)
        if (!(ch >= '가' && ch <= '힝')) {
            alert("이름은 한글만 입력 가능합니다.")
            document.getElementById("nameA").innerHTML="이름은 한글만 입력 가능합니다.";
            document.idObj.focus();
            document.idObj.select();
            return false;
        }
    	}
    	 // 패스워드 검사
    	 if (passObj.value == "") {
			alert("패스워드를 입력해주세요");
			document.getElementById("nameA").innerHTML="&nbsp";
			document.getElementById("passA").innerHTML="패스워드를 입력해주세요.";
			document.passObj.focus();
			document.passObj.select();
			return false;
		}
    	 if (passObj.value == idObj.value) {
			alert("패스워드와 아이디가 같습니다.")
			document.getElementById("passA").innerHTML="패스워드와 아이디가 같습니다.";
			document.passObj.focus();
			document.passObj.select();
			return false;
		}
    	 if (passObj.value.length <= 3 || passObj.value.length >= 21) {
    		alert("패스워드는 4~20 자 입니다.")
    		document.getElementById("passA").innerHTML="패스워드는 4~20 자 입니다.";
    		document.passObj.focus();
 			document.passObj.select();
 			return false;
		}
    	 if (passChkObj.value == "") {
     		alert("패스워드 확인란을 입력해주세요")
     		document.getElementById("passA").innerHTML="&nbsp";
      		document.getElementById("passChkA").innerHTML="패스워드 확인란을 입력해주세요";
     		document.passChkObj.focus();
   			document.passChkObj.select();
   			return false;
 		}
    	 
    	 if (passObj.value != passChkObj.value) {
    		alert("패스워드가 서로 다릅니다.")
     		document.getElementById("passChkA").innerHTML="패스워드가 서로 다릅니다.";
    		document.passChkObj.focus();
  			document.passChkObj.select();
  			return false;
		}
    	 //주소검사
    	 if (addressMainObj.value == "") {
    		alert("주소 검색을 이용하여 주소를 입력해주세요")
      		document.getElementById("passChkA").innerHTML="&nbsp";
    		document.addressMainObj.focus();
   			document.addressMainObj.select();
   			return false;
    	 }
   		 //상세주소 검사
   		 if (addressDetailObj.value == "") {
			alert("상세 주소를 입력해주세요")
			document.getElementById("addressDetailA").innerHTML="상세 주소를 입력해주세요";
			document.addressDetailObj.focus();
			document.addressDetailObj.select();
		}
   		 //이메일 검사
   		 if (emailObj.value == "") {
   			alert("이메일을 입력해주세요")
   			document.getElementById("addressDetailA").innerHTML="&nbsp";
			document.getElementById("emailA").innerHTML="이메일을 입력해주세요";
   			document.emailObj.focus();
			document.emailObj.select();
		}
   		 //연락처 검사
   		 if (phoneObj.value == "") {
			alert("연락처를 입력해주세요")
			document.getElementById("emailA").innerHTML="&nbsp";
			document.getElementById("phoneA").innerHTML="연락처를 입력해주세요";
			document.phoneObj.focus();
			document.phoneObj.select();
		}
   		for (var i = 0; i < phoneObj.value.length; i++) {
			ch = phoneObj.value.charAt(i)
        if (!(ch >= '0' && ch <= '9')) {
            alert("연락처는 숫자만 입력 가능합니다.")
          	document.getElementById("phoneA").innerHTML="연락처는 숫자만 입력 가능합니다.";
            document.phoneObj.focus();
            document.phoneObj.select();
            return false;
        }
   		}
    	 
    	 formObj.submit();
 		 return true;
 			
 	
	}
    
    function openPop() {
    	window.open("./idChk.do" ,"", "left="+(screen.availWidth-660)/2+",top="+(screen.availHeight-430)/2+", width=500, height=300");
	}
    
    function returnBtn() {
		location.href= './login.do'	
	}
</script>
<script type="text/javascript">

	
</script>
</head>
<body>
	<h1 id="coffee">Coffee</h1>
	<h1 id="been">Been Tree</h1>
	<h2>회원가입</h2>
	<div>
		<form id="form" action="./addCtr.do" method="post">
			<ul>
				<li>
					<input type="text"  id="id" name="id" placeholder="아이디중복체크를 이용해 주세요" readonly="readonly"
					value="${id}">
					<input type="button" value="중복체크" onclick="openPop()"><br>
					<a style="font-size: 12px; text-align: left; color: red;">
					&nbsp</a>
				</li>
					
				<li>
					<input type="text" id="name" name="name" placeholder="이름은 2~6자 한글만 입력 가능합니다."><br>
					<a id="nameA" style="font-size: 12px; text-align: left; color: red;">
					&nbsp</a>
				</li>
				<li>
					<input type="password" id="pass" name="pass" placeholder="패스워드는 4~20 자 입니다."><br>
					<a id="passA" style="font-size: 12px; text-align: left; color: red;">
					&nbsp</a>
				</li>
				<li>
					<input type="password" id="passwordchk" name="passwordchk" placeholder="패스워드 확인란"><br>
					<a id="passChkA" style="font-size: 12px; text-align: left; color: red;">
					&nbsp</a>
				</li>
				<li>
					<input type="text" style="width: 270px;" id="addressMain" 
					name="addressMain" placeholder="주소 검색을 이용해 주세요" readonly="readonly">
					<input type="button" onclick="sample5_execDaumPostcode()" value="주소 검색"><br>
					<a style="font-size: 12px; text-align: left; color: red;">
					&nbsp</a>
				</li>
				<li>
					<input type="text" id="addressDetail" name="addressDetail" placeholder="상세주소를 입력해주세요"><br>
					<a id="addressDetailA" style="font-size: 12px; text-align: left; color: red;">
					&nbsp</a>
				</li>
				<li>
					<input type="email" id="email" name="email" placeholder="이메일을 입력해주세요"><br>
					<a id="emailA" style="font-size: 12px; text-align: left; color: red;">
					&nbsp</a>
				</li>
				
				<li>
					<input type="text" id="phone" name="phone" placeholder="연락처를 입력해 주세요 (- 제외)"><br>
					<a id="phoneA" style="font-size: 12px; text-align: left; color: red;">
					&nbsp</a>
				</li>
				<li>
					<input type="button" style="margin-top: 20px; margin-right: 20px;" id="signup" name="signup" value="가입하기" onclick="joinChk()">
					<input type="button" id="returnpage" name="returnpage" value="돌아가기" onclick="returnBtn()">
				</li>
			</ul>
		</form>
	</div>
</body>
</html> 