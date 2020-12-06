<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품리스트</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.13.0/css/all.css"
        integrity="sha384-Bfad6CLCknfcloXFOyFnlgtENryhrpZCe29RTifKEixXQZ38WheV+i/6YWSzkz3V" crossorigin="anonymous">
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
	 		<c:forEach var="list" items="${list}" varStatus="status">
	 			<c:if test="${status.first}">
	 				<h1>${list.cateName}</h1>
	 			</c:if>
	 		
	 			<div class="product-list">
	 				<ul>
	 					<li>
	 						<a href="/kpop/shop/shopview?goodsnumber=${list.goodsNumber}">
	 							<img src="${pageContext.request.contextPath}/resources/${list.img}">
	 						</a>
	 					</li>
	 					
	 					<li class="list_goodsname">
	 						<a href="/kpop/shop/shopview?goodsnumber=${list.goodsNumber}">${list.goodsName}</a>
	 					</li>
	 					
	 					<li class="prodcut-price">
	 						<c:if test="${list.dc == 0}">
	 						<li class="dc-price">KRW <fmt:formatNumber value="${list.dcPrice }" pattern="###,###,###" />원</li>
	 						
	 						</c:if>
	 						<c:if test="${list.dc != 0 }">
	 							<span class="orig-price"><fmt:formatNumber value="${list.origPrice }" pattern="###,###,###" />원</span>
								<span class="dc">${list.dc}%</span>
								<li class="dc-price">KRW <fmt:formatNumber value="${list.dcPrice }" pattern="###,###,###" />원</li>
	 						</c:if>
	 							
							
						</li>			
					
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