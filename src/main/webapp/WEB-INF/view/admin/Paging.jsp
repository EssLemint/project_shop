<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>



<style type="text/css">
nav>ul {
		list-style-type: none;
 		background-color: #FFFFFF;
 		padding: 0px;
		display: table;
		overflow: hidden;
 		margin-left: auto; 
 		margin-right: auto; 
}

nav>ul>li {
	background-color:  white;
 		float: left; 
		margin-right: 5px;
}

nav>ul>li>a {
	display: block;
      color: black;
      text-align: center;
      padding: 16px; 
      text-decoration: none;
      border-collapse: collapse;
      border: 1px solid black;
}

nav>ul>li>a:hover {
	color: white;
	background-color: black;
	font-weight: bold;
}

.active {
	color: black;
	background-color: white;
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

		var curPageObj = $('#curPage');

// 			value = 234324;

// 			val(234324);

// 			val();

		curPageObj.val(pageNumber);

// 		alert(curPageObj.val());

 

		$("#pagingForm").submit();

	}

	

	$(document).ready(function(){

		var curPageDoc = $('#curPage');

		

		var id = '#pageButton' + curPageDoc.val();

		

		$(id).addClass('active');

		

	});

	

	

</script>





<nav id='pageNation'>

	<ul>

		<li><a href="#" style="background-color: black; color: white;"
			onclick="goPage(${pagingMap.memberPaging.prevPage});"> <span>≪</span>

		</a></li>



		<c:forEach var="num" begin="${pagingMap.memberPaging.blockBegin}"
			end="${pagingMap.memberPaging.blockEnd}">



			<li id="pageButton${num}"><a href="#" onclick="goPage(${num});">

					<c:out value="${num}" />

			</a></li>



		</c:forEach>



		<li><a href="#" style="background-color: black; color: white;"
			onclick="goPage(${pagingMap.memberPaging.nextPage});"> <span>≫</span>

		</a></li>

	</ul>

</nav>