<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품리스트</title>
 <link rel="stylesheet" href="/kpop/resources/css/index.css">
 <link rel="stylesheet" href="/kpop/resources/css/restet.css">
 <link rel="stylesheet" href="/kpop/resources/css/shoplist.css">
</head>
<body>

<section id="full-wrap">
	<%@include file="../include/header.jsp" %>
	 <section id="main">
	 	<div class="container">
	 	<div class="product-wrap">
	 		<c:forEach var="eventList" items="${eventList}" varStatus="status">
	 			<c:if test="${status.first}">
	 				<h1>EVENT</h1>
	 			</c:if>
	 			<div class="product-list">
	 				<ul>
	 					<li>
	 						<a href="/kpop/shop/eventView?evNumber=${eventList.evNumber}">
	 							<img src="${pageContext.request.contextPath}/resources/${eventList.evImg}">
	 						</a>
	 					</li>
	 					<li class="list_goodsname"><a href="/kpop/shop/eventview?evNumber=${eventList.evNumber}">${eventList.evTitle}</a></li>
	 				</ul>
	 			</div>
	 			<!-- product-list -->
			
	 		</c:forEach>
	 					
	 		</div>
			<!-- product-wrap -->
	 	</div>
		<!-- container End -->	
	</section>
	<!-- main End -->
	<%@include file="../include/footer.jsp" %>
</section>
<!-- full-wrap End -->
</body>
</html>