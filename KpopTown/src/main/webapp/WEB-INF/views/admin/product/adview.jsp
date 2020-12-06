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
<script src="/kpop/resources/js/admin.js"></script>
<link rel="stylesheet" href="/kpop/resources/css/admin.css">
<link rel="stylesheet" href="/kpop/resources/css/restet.css">
<link rel="stylesheet" href="/kpop/resources/css/index.css">

<title>상세보기</title>
</head>
<body>
<section id="full-wrap">
	<%@ include file="../include/header.jsp" %>
	
	<section id="main-wrap">
		
  	
  	<form role="form" method="post">		
 	<input type ="hidden" name="goodsNumber" class="goodsnumber" value="${view.goodsNumber}"/>
		
	<div class="main">
		<!-- side include -->
		<%@include file="../include/aside.jsp" %>
	<!-- 상세내용  -->	
	<div class="admin-container">
		<div class="poster-title"> 
			<div class="poster-img">
				<img src="${pageContext.request.contextPath}/resources/${view.img}">
			</div>
			
			 <div class="view-text">
		    	<h1 class="title">${view.goodsName}</h1>
		    	<!--  할인율이 0 이라면 할인표시 하지 않음  -->
		    	<c:if test="${view.dc == 0 }">
		    		<div class="original">
		    			<span class="dcprice">KRW <fmt:formatNumber value="${view.dcPrice}" pattern="###,###,###"/></span>
		    		</div>
		    	</c:if>
		    	
		    	<!-- 할인율이 0이 아니라면 할인표시 함 -->
		    	<c:if test="${view.dc != 0 }">
		    	<div class="price-Container">
		    	<div class="original">
		    		<span class="orig-price">KRW<fmt:formatNumber value="${view.origPrice}" pattern="###,###,###"/></span>
		    		<span class="dc">${view.dc}%↓</span>
		    	</div>
		    	<!-- original -->
		    	<div class="discount">
		    		<span class="dcprice">KRW <fmt:formatNumber value="${view.dcPrice}" pattern="###,###,###"/></span>
		   		</div>
		    	<!-- discount -->
		    	</div>
		    	</c:if>
		    	<hr>
		    	
		    	<ul>
			<li>
				<span>마일리지</span>
				<span>${view.point}원</span>
			</li>
			<li>
				<span>출시일</span>
				<span>${view.releaseDate}</span>
			</li>
			<li>
				<span>재고수량</span>
				<span>${view.stock}</span>
			</li>
			<li>
				<span>제작사</span>
				<span>${view.company}</span>
			</li>
		</ul>
		
		
		<div class="hanteo">
			<img class="ht" src="/kpop/resources/img/HTfamily_web_KR.png">
			<img class="gaon" src="/kpop/resources/img/gaon_web_COM.jpg" >
	
		</div>
		    </div>
		    <!-- view-text -->
		</div>
		<!-- poster-title -->
		
	
	   <div class="detail">
	   	
	   		<p>${view.goodsDetail}</p>
	   		<%-- <img src="/kpop/resources/${view.detailimg }"> --%>
	   </div>
	   <!-- datail End -->
		
		<div class="ad_Btn">
			<button type="button" id="modify_Btn" class="btn btn-warning">수정</button>
			<button type="button" id="delete_Btn" class="btn btn-delete">삭제</button>
		</div>
	
	</div>
	<!-- admin-container End -->
	</div>
	<!-- main End -->
	</form>	

</section>
<!--  main-wrap End -->
  <%@include file="../include/footer.jsp" %>
</section>
<!--  wrap End -->

</body>
</html>