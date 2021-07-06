<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품추가</title>
<style type="text/css">
div {
	margin: 0 0 0 0px;
}


#product {
	float: left;
	margin-left: 15px;
}

.bttn {
	border: none;
	color: white;
	background-color: #555555;
	font-size: 12px;
	display: inline-block;
	text-align: center;
	text-decoration: none;
	cursor: pointer;
	width: 60px;
	height: 25px;
	border-radius: 4px;
}
</style>
<script type="text/javascript"
	src="/zordy/resources/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">

	$(document).ready(function() {
		$("#gdsImg").change(
				function() {
					if (this.files && this.files[0]) {
						var reader = new FileReader;
						reader.onload = function(data) {
							$(".select_img img").attr("src", data.target.result).width(300);
						}
						reader.readAsDataURL(this.files[0]);
					}
					
			})
	});
		
	$("textarea.autosize").on('keydown keyup', function () {
		  $(this).height(1).height( $(this).prop('scrollHeight')+12 );	
		});
	
	function deleteFileFnc(obj){
		$('#img_pre').attr('src', '');
		$('#gdsImg').val("");
		obj.remove();
	}

	function check() {
	  if(fileContent.name.value == "") {
		fileContent.id.focus();
	    return false;
	  }

	  else if(fileContent.stock.value == "") {
		fileContent.stock.focus();
	    return false;
	  }
	  
	  else if(fileContent.price.value == "") {
		fileContent.price.focus();
		return false;
	  }
	  else return true;

	}
	
	function onlyNumber(event){
	    event = event || window.event;
	    var keyID = (event.which) ? event.which : event.keyCode;
	    if ( (keyID >= 48 && keyID <= 57) || (keyID >= 96 && keyID <= 105) || keyID == 8 || keyID == 46 || keyID == 37 || keyID == 39 ) 
	        return;
	    else
	        return false;
	}
	 
	function removeChar(event) {
	    event = event || window.event;
	    var keyID = (event.which) ? event.which : event.keyCode;
	    if ( keyID == 8 || keyID == 46 || keyID == 37 || keyID == 39 ) 
	        return;
	    else
	        event.target.value = event.target.value.replace(/[^0-9]/g, "");
	}

	function imgChangeFnc() {
		var deleteBtn = document.getElementById("deleteBtn");
		
		var str = "";
		
		str += '<a href="#this" id="delete">삭제</a>';
		
		deleteBtn.innerHTML = str;
		 		
		$("a[id^='delete']").on('click', function(e) {
			e.preventDefault();
			deleteFileFnc($(this));
		});
		
	}
	
function addChk() {
		
		var formObj = document.getElementById("form");
    	var nameObj = document.getElementById("name");
    	var stockObj = document.getElementById("stock");
    	var priceObj = document.getElementById("price");
    	var prdetailObj = document.getElementById("prdetail");
    	var gdsImgObj = document.getElementById("gdsImg");
    	
    	// 상품명 검사
    	if (nameObj.value == "") {
			alert("상품명를 입력하세요")
			document.nameObj.focus();
			return false;
    	}else if (nameObj.value.length < 1 || nameObj.value.length > 30) {
			alert("상품명는 1~30 자 입니다.")
			document.nameObj.focus();
			return false;
    	}
    	// 수량 검사
    	if (stockObj.value =="") {
    		alert("재고을 지정해주세요")
			document.nameObj.focus();
			return false;
		}
    
    	 // 금액 검사
    	 if (priceObj.value == "") {
			alert("가격을 입력해주세요")
			document.passObj.focus();
			return false;
		}
   
    	 //상세설명 검사
    	 if (prdetailObj.value == "") {
    		alert("상세설명 입력해주세요")
      		document.addressMainObj.focus();
   			return false;
    	 }else if (nameObj.value.length < 1 || nameObj.value.length > 1300) {
			alert("상품상세는 1~1300 자 입니다.")
			document.nameObj.focus();
			return false;
    	}
   		 //이미지 검사
   		 if (gdsImgObj.value == "") {
			alert("이미지를 선택해 주세요")
			document.addressDetailObj.focus();
			return false;
   		 }
    	 
    	 formObj.submit();
	}
	
// 	//3자리 단위마다 콤마 생성
// 	function addCommas(x) {
// 	    return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
// 	}
	 
// 	//모든 콤마 제거
// 	function removeCommas(x) {
// 	    if(!x || x.length == 0) return "";
// 	    else return x.split(",").join("");
// 	}
	
// 	//숫자 자동 , 찍는거
// 	$("input:text[numberOnly]").on("focus", function() {
// 	    var x = $(this).val();
// 	    x = removeCommas(x);
// 	    $(this).val(x);
// 	}).on("focusout", function() {
// 	    var x = $(this).val();
// 	    if(x && x.length > 0) {
// 	        if(!$.isNumeric(x)) {
// 	            x = x.replace(/[^0-9]/g,"");
// 	        }
// 	        x = addCommas(x);
// 	        $(this).val(x);
// 	    }
// 	}).on("keyup", function() {
// 	    $(this).val($(this).val().replace(/[^0-9]/g,""));
// 	});

</script>

</head>
<body>
	<jsp:include page="/resources/mainjsp/AdminMainPage.jsp" />
	<div style="width: 1360px; height: 1000px;">

		<div id="product" style="margin-top: 50px;">
			<div>
				<h1>상품등록</h1>
			</div>

			<form action='./productAddCtr.do' method='post'
				enctype='multipart/form-data' onsubmit="return check()" id="form">
				<div id='fileContent'>
					<div style="width: 900px; height: 350px; border: 5px solid #e6e6e6;">
						<div style="margin-top: 30px;">
						<a style="font-size: 20px;margin-left: 50px;">상품명</a>
							<input type="text" id="name"
								name="name"	style="height: 20px; margin-right: 10px;">

						<a style="font-size: 20px;margin-left: 30px;">재고</a>
						<input type="text" id="stock" style="height: 20px; margin-right: 10px;"
							name="stock" onkeydown='return onlyNumber(event)'
							onkeyup='removeChar(event)'>

						<a style="font-size: 20px;margin-left: 30px;">가격</a>
						<input type="text" id="price" style="height: 20px; text-align: right;"
							name="price" onkeydown='return onlyNumber(event)'
							onkeyup='removeChar(event)'>
						</div>
					<div>
						<textarea rows="15" cols="98" id="prdetail" name="detail" 
						style="resize: none; margin-left: 50px; margin-top: 30px; margin-bottom: 20px;"
						placeholder="제품 상세 설명을 입력해주세요!"></textarea>
					</div>
					</div>
					<div style="width: 900px; height: 370px; border: 5px solid #e6e6e6;">
					<div class="inputArea" id="imageArea" style="margin-top: 30px;">
						<a style="margin-left: 50px; font-size: 20px;">상품 이미지 추가</a><br>
						
						 <input type="file" id="gdsImg" style="margin-left: 50px; margin-top: 50px; width: 77px;"
							name="file" onchange="imgChangeFnc();" />
							
						<div class="select_img" style="width: 300px; height: 300px; float: right; margin-right: 200px;">
							<img alt="" id="img_pre" src="" style="width: 100%; height: 100%;" />
						</div>

						<span id="deleteBtn">
						
						</span>
					</div>
					</div>
				</div>
				<input class="bttn" type='button' style="margin-left: 50px; margin-top: 20px;" value='등록' onclick="addChk();">
			</form>
		</div>
	</div>
</body>
</html>

<!-- <label for="gdsImg"></label> -->

