<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<style type="text/css">
	nav > ul{
		list-style-type: none;
 		background-color: #FFFFFF;
 		padding: 0px;
		display: table;
		overflow: hidden;
 		margin-left: auto; 
 		margin-right: auto; 
	}

	nav > ul > li {
		background-color: #FFFFFF;
 		float: left; 
		margin-right: 5px;
	}
	
/* 	nav > ul > li > a{ */
	
/* 	  display: block; */
/*       color: black; */
/*       text-align: center; */
/* /*       padding: 16px; */ */
/*       text-decoration: none; */
/*       border-collapse: collapse; */
/*       border: 1px solid black; */
/* 	} */
	
/* 	nav > ul > li > a:hover { */
/* 	  color: #FFFFFF; */
/*       background-color: #000000; */
/*       font-weight: bold; */
/* 	} */
	
	.active{
	  color: #0100FF;
      background-color: #D5D5D5;
      font-weight: bold;
      margin-left: 5px;  
	}
	#lefta, #righta{
/* 	 width: 30px; */
	}
	
	#lefta, #righta,#numa{
	  display: block;
      color: black;
      text-align: center;
      padding: 16px; 
      text-decoration: none;
      border-collapse: collapse;
      border: 1px solid black;
		
	}
	#lefta, #righta,#numa:hover{
	  color: #FFFFFF;
      background-color: #000000;
      font-weight: bold;
	}
	

</style>

<script type="text/javascript">
// 	function goPage(pageNumber){
// 		var curPageObj = document.getElementById('curPage');
		
// 		curPageObj.value = pageNumber;
// // 		alert(curPageObj.value);
// 		document.getElementById('pagingForm').submit();
		
// 	}
	
// 	window.onload = function(){
// 		var curPageDoc = document.getElementById('curPage');
		
// 		var pageNationObj = document.getElementById('pageNation');
		
// 		var liObjArr = pageNationObj.getElementsByTagName('li');
		
// 		liObjArr[curPageDoc.value].style.backgroundColor = '#5D5D5D';
// 		liObjArr[curPageDoc.value].style.color = '#FFD9EC';
// 	}

	function goPage(pageNumber){
		var curPageObj = $('#tempCurPage');
		

		curPageObj.val(pageNumber);

		var formObj = document.getElementById('pagingForm');
		
		var htmlStr = '';
		htmlStr += '<input type="hidden" name="curPage"';
		htmlStr += 'value="' + curPageObj.val() + '">';

		$("#pagingForm").html($("#pagingForm").html() + htmlStr);
		
		$("#pagingForm").submit();
	}
	
	$(document).ready(function(){
// 		블록의 현재 위치
		var curPageDoc = $('#tempCurPage');
			
		var index = curPageDoc.val();
// 		1~10   1~10    11~20   1~10  21~30 1~10
		index = ((index-1)%10)+1;
		
		$('#pageNation').find('li').eq(index).addClass('active');
		
	});
	
	
</script>


	<nav id='pageNation'>
		<ul>
			<li>
				<a href="#" onclick="goPage(${pagingMap.memberPaging.prevPage});" id="lefta" >
					<span>≪</span>
				</a>
			</li>
			
			<c:forEach var="num" begin="${pagingMap.memberPaging.blockBegin}" 
				end="${pagingMap.memberPaging.blockEnd}">
				
				<li>
					<a href="#" onclick="goPage(${num});" id="numa">
						<c:out value="${num}"/>
					</a>
				</li>
			
			</c:forEach>
			
			<li>
				<a href="#" onclick="goPage(${pagingMap.memberPaging.nextPage});" id="righta">
					<span>≫</span>
				</a>
			</li>
		</ul>
	</nav>


