<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
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
	#lione{
	margin-top: 20px;
	}
	#email{
	width : 300px;
	height : 35px;
	margin-bottom: 10px;
	}
	#phone{
	width : 300px;
	height : 35px;
	}
	#searchid{
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
<script type="text/javascript">
	function returnBtn() {
		location.href= './login.do'
		
	}

</script>
</head>
<body>
	<h1 id="coffee">Coffee</h1>
	<h1 id="been">Been Tree</h1>
	<h2>아이디 찾기</h2>
	<div>
		<form action="./searchIdCtr.do" method="post">
			<ul style="margin: 0px; padding: 0px;">
				<li>
					<input type="email" id="email" name="email" placeholder="이메일을 입력해주세요">
				</li>
				<li>
					<input type="text" id="phone" name="phone" placeholder="연락처를 입력해주세요 (-) 제외">
				</li>
				<li>
					<hr style="width: 300px; margin-top: 20px;">
				</li>
				<li id="lione">
					<input type="submit" id="searchid" value="아이디 찾기">
					<input type="button" id="returnpage" value="돌아가기" onclick="returnBtn()">
				</li>
				
			</ul>
		</form>
	</div>
</body>
</html>