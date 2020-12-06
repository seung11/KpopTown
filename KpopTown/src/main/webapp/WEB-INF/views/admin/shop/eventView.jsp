<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="/kpop/resources/js/jquery-3.5.1.js"></script>
<link rel="stylesheet" href="/kpop/resources/css/admin.css">
<link rel="stylesheet" href="/kpop/resources/css/restet.css">
<link rel="stylesheet" href="/kpop/resources/css/index.css">

<title>상세보기</title>
</head>
<body>
<section id="full-wrap">
	<%@ include file="../include/header.jsp" %>	
	<section id="main-wrap">	
		<div class="main">
		<!-- side include -->
		<%@include file="../include/aside.jsp" %>

			<div class="admin-container">
			<form action="" role="form" method="post">		

			<input type ="hidden" name="evNumber" id="evNumber" class="evNumber" value="${view.evNumber}"/>
				<div class="detail-view">
	  				<div class="detail">
					<p>${view.evCon}</p>
	 		  </div>
	  		 <!-- datail End -->
			</div>
			<!-- detail-view -->
			</form>
		
		<div class="ad_Btn">
			<button type="button" id="evModify_Btn" class="btn evbtn-warning">수정</button>
			<button type="button" id="evDelete_Btn" class="btn evbtn-delete">삭제</button>
		</div>
	
	</div>
	<!-- admin-container End -->
	</div>
	<!-- main End -->

</section>
<!--  main-wrap End -->
  <%@include file="../include/footer.jsp" %>
</section>
<!--  wrap End -->
<script>
//이벤트 수정 , 삭제
	
let evformObj = $("form[role='form']");
console.log(evformObj);
let evNumber = $(".evBtn-delete").val();
console.log(evNumber);	 		 
	 		 
	//삭제
	$("#evDelete_Btn").click(function(){
		let con = confirm("정말로 삭제하시겠습니까?");		 
		if(con) {      
			evformObj.attr("method","get")
			evformObj.attr("action", "/kpop/admin/shop/evdelete");
			evformObj.submit();
		}
	});
	 		 
	//수정 
	$("#evModify_Btn").click(function(){
		console.log("수정");
		evformObj.attr("action", "/kpop/admin/shop/evmodify");
		evformObj.attr("method", "get")
		evformObj.submit();
	});	 
	 	


</script>
</body>
</html>