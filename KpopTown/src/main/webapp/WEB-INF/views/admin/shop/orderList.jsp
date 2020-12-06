<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문목록</title>
 	<link rel="stylesheet" href="/kpop/resources/css/adorderlist.css">
    <link rel="stylesheet" href="/kpop/resources/css/restet.css">
    <link rel="stylesheet" href="/kpop/resources/css/index.css">
    <link rel="stylesheet" href="/kpop/resources/css/admin.css">
    <script type="text/javascript" src="/kpop/resources/js/jquery-3.5.1.js"></script>
</head>
<body>
	<section id="full-wrap">
		<%@ include file="../include/header.jsp" %>
		<section id="main-wrap">
			<div class="main">
			<%@include file="../include/aside.jsp" %>
				<div class="admin-container">
					<h1>주문목록</h1>
						<ul class="orderList">
							<li class="orderList-title">
								<label class="orderDate-title">주문날짜</label>
								<label class="orderid-title">주문번호</label>
								<label class="orderInfo-title">상품정보</label>
								<label class="orderStock">주문수량</label>
								<label class="orderPrice-title">주문금액</label>
								<label class="orderdelivery-title">상태</label>
								
							</li>
							<c:forEach var="orderList" items="${orderList}">
								<li class="orderList-Info">
									<div class="orderDate">
										<p><fmt:formatDate value="${orderList.orderDate}" pattern="yyyy-MM-dd"/></p>
									</div>
									
									<div class="orderid">
										<p>${orderList.orderId}</p>
										<a href="/kpop/admin/shop/orderView?n=${orderList.orderId}"><button class="orderview_Btn">주문상세보기</button></a>
									</div>
									<div class="orderInfo">
										<img src="${pageContext.request.contextPath}/resources/${orderList.img}">
										<p>${orderList.goodsName}</p>	
									</div>
									
									<div class="orderStock">
										<p>${orderList.cartStock}</p>
									</div>
									
									<div class="orderPrice">
										<p><fmt:formatNumber pattern="###,###,###" value="${orderList.dcPrice * orderList.cartStock}" />원</p>
									</div>
									
									<div class="orderdelivery">
										<p>${orderList.delivery}</p>
									</div>
									
								</li>
							</c:forEach>
						</ul>
				</div>
				<!-- admin-container End -->
			</div>
			<!-- container End -->
			
		</section>
		<!-- main End -->
		<%@ include file="../include/footer.jsp" %>
	</section>	
	

</body>
</html>