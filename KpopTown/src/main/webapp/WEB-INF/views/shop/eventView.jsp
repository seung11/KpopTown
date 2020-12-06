<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="/kpop/resources/js/jquery-3.5.1.js"></script>
<script src="/kpop/resources/js/shop.js"></script>
<script src="/kpop/resources/ckeditor/ckeditor.js"></script>
<link rel="stylesheet" href="/kpop/resources/css/restet.css">
<link rel="stylesheet" href="/kpop/resources/css/index.css">
<link rel="stylesheet" href="/kpop/resources/css/view.css">
<title>이벤트 상세보기</title>

</head>
<body>
<section id="wrap">
	<%@include file="../include/header.jsp" %>

<section id="main">
<div class="container">
  <form action="" role="form" method="post">		

<input type ="hidden" name="evNumber" id="evNumber" class="evNumber" value="${view.evNumber}"/>
	<div class="detail-view">
	
	   <div class="detail">
	   	
	   		<p>${view.evCon}</p>
	   		<%-- <img src="/kpop/resources/${view.detailimg }"> --%>
	   </div>
	   <!-- datail End -->
	
		
	</div>
	<!-- detail-view -->
	</form>
 </div>
<!--container  -->
</section>

	<%@include file="../include/footer.jsp" %>
</section>
<!--  wrap End -->

</body>
</html>