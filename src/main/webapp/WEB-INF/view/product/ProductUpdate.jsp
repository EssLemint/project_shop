<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 수정</title>
<script type="text/javascript"
	src="/zordy/resources/js/jquery-3.4.1.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>


<script type="text/javascript">
// $(document).ready(function() {
// 	$("#gdsImg").change(
// 			function() {
// 				if (this.files && this.files[0]) {
// 					var reader = new FileReader;
// 					reader.onload = function(data) {
// 						$(".select_img img").attr("src", data.target.result).width(300);
// 					}
// 					reader.readAsDataURL(this.files[0]);
// 				}
// 			})		
// });


$(document).ready(function() {	
	$("a[id^='delete']").on('click', function(e) {
		e.preventDefault();
		deleteExistPicFnc($(this));
	});		
});


function deleteExistPicFnc(obj){
	var selectOne = obj.parent().parent().parent();
// 	.attr('id');
// 	alert(selectOnr);
	
	selectOne.remove();
}
	
function deleteFileFnc(obj){
// 	alert($(obj).attr('id'));
// 	alert($('#img_pre').attr('id'));
	
	$('#img_pre').removeAttr('src');
	$('#gdsImg').val("");
	obj.remove();
}



$("textarea.autosize").on('keydown keyup', function () {
	  $(this).height(1).height( $(this).prop('scrollHeight')+12 );	
	});
	
var obj = $('#existFile');

function addFileFnc(){
	var obj = $("#existFile");
	
	var htmlStr = "";
	
	htmlStr += '<div class="inputArea" id="imageArea">';
	htmlStr += '<div>';
	htmlStr += '</div>';
	htmlStr += '<div class="select_img">';
	htmlStr += '<img alt="" id="img_pre"';
	htmlStr += 'src="" style="width: 300px; height: 300px;" />';
	htmlStr += '</div>';
	htmlStr += '<div>';
	htmlStr += '<input type="file" id="gdsImg"';
	htmlStr += 'width: 77px;"';
	htmlStr += 'name="file" onchange="imgChangeFnc();" />';
	htmlStr += '<span id="deleteBtn">';
	htmlStr += '</span>';
	htmlStr += '</div>';
	htmlStr += '</div>';

	obj.html(htmlStr);
	
	$("#gdsImg").change(
		function() {
			if (this.files && this.files[0]) {
				var reader = new FileReader;
				reader.onload = function(data) {
					$(".select_img img").attr("src", data.target.result).width(300);
			}
			reader.readAsDataURL(this.files[0]);
		}
	});	
}

function pageMoveDeleteFnc(no){
	 var url = "./productDeleteCtr.do";
	 var productFormObj = document.getElementById('productInfoForm');
	 
	 productFormObj.action = url;
	 productFormObj.submit();
	 
}

function imgChangeFnc() {
	var deleteBtn = document.getElementById("deleteBtn");
// 	alert(deleteBtn)
	var str = "";
	
	str += '<a href="#this" id="deletepic">삭제</a>';
	
	deleteBtn.innerHTML = str;
	 		
	$("a[id^='deletepic']").on('click', function(e) {
// 		alert("여기로 온다");
		e.preventDefault();
		deleteFileFnc($(this));
	});
	
}

</script>

<style>
#mainli{
	margin-left: 40px;
}

ul {
	list-style: none;
	margin-right: 40px;
	padding: 0;
}

li {
	margin: 0px;
	padding: 0px;
	border: 0;
}

textarea.autosize {
	min-height: 50px;
}

#product{
	float: left;
	margin-left: 15px;
	margin-top: 20px;
	margin-left: 80px;
}

.bttn {
 	border: none;
    color: white;
	background-color: #555555;
	font-size: 14px;
	display: inline-block;
	text-align: center;
    text-decoration: none;
    cursor: pointer;
    width: 80px;
    height: 30px;
    border-radius: 4px;
 }
 
</style>
</head>
<body>
<body>
<div style="width: 1500px; height: 1000px;">
	<jsp:include page="/resources/mainjsp/AdminMainPage.jsp"/>
	<div id="product">
		<h1 style="text-align: center;">상품수정</h1>
		<div>
			<form id="productInfoForm" action='./productUpdateCtr.do' method='post'
				enctype="multipart/form-data">
				<div>
					<div style="width:900px; border: 5px solid #e6e6e6;">
						<div style="margin-top: 30px;">
							<a style="font-size: 20px;margin-left: 50px;">						
							    상품명
								</a>
									<input type="text" value="${productDto.name}" name="name" style="height: 20px; margin-right: ">
							<a style="font-size: 20px;margin-left: 50px;">				
								상품 재고
							</a>
									<input type="text" value="${productDto.stock}" name="stock" style="height: 30px;">
							<a style="font-size: 20px;margin-left: 50px; ">				
								금액
							</a>
									<input type="text" value="${productDto.price}" name="price" style="height: 30px; text-align: right;">
						</div>
							<textarea class="autosize" rows="15" cols="98" name="detail"
								style="resize: none; margin-top: 40px; margin-left: 70px; margin-bottom: 20px;">${productDto.detail}</textarea>
					</div>
					<div style="width: 900px; height: 400px; border: 5px solid #e6e6e6;">
					<div style="margin-top: 30px;">
						<a style="font-size: 20px;margin-left: 50px;">상품 이미지</a>
						</div>
						<div id="existFile" >
							<div>
									<c:choose>
											<c:when test="${empty fileList}">
												<input type="hidden" id="fileIdx" name="fileIdx" value="">
												<input type="file" id="file0" name="file0">
												<a href="#this" id="delete0" onclick="addFileFnc();">삭제</a>
												<br>
											</c:when>
											<c:otherwise>
												<c:forEach var="file" items="${fileList}" varStatus="obj">
												<div>
													<input type="hidden" id="fileIdx_${obj.index}" name="fileIdx"
														value="${file.P_IMAGE_NO}"> 
													<img alt="image not found" style="width: 300px; height: 300px; 
																float: left; margin-right: 0px;"
														src="<c:url value='/img/${file.P_IMAGE_STORED_FILE_NAME}'/>" />
												</div>
												<div style="clear: right; margin-left:  80px; padding-left: 120px;">
									<span id="deleteBtn" style="display: inline-block; margin-top: 10px; float: left;">
										<a href="#this" id="delete" style="font-weight: bold;">삭제하기</a> 
									</span>
												
													
												</div>
												</c:forEach>
											</c:otherwise>
										</c:choose>
										<input type="hidden" id="defaultFileIdx" name="fileIdx"
											value="-1">
								</div>
							</div>	
					</div>
					
					
	
					
				</div>
				<div>
					<input class="bttn" type="button" value="파일추가" onclick="addFileFnc();"> 
					<input class="bttn" type='submit' value='저장'> 
					<input class="bttn" type='button' value='삭제' onclick='pageMoveDeleteFnc(${productDto.no});'> 
					<input class="bttn"	type='button' value='취소'> 
					<input type="hidden" name='no'	value='${productDto.no}'> 
	<!-- 					<input type="hidden" -->
	<%-- 						name='createDate' value='${productDto.createDate}'> --%>
				</div>
			</form>
		</div>
	</div>

</div>
</body>
</html>