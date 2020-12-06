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
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400;500;700&display=swap" rel="stylesheet">
 	<link rel="stylesheet" href="/kpop/resources/css/orderlist.css">
    <link rel="stylesheet" href="/kpop/resources/css/restet.css">
    <link rel="stylesheet" href="/kpop/resources/css/index.css">
    <script type="text/javascript" src="/kpop/resources/js/jquery-3.5.1.js"></script>
</head>
<body>
	<section id="full-wrap">
		<%@ include file="../include/header.jsp" %>
		<section id="main">
			<div class="container">
				<div class="orderList-container">
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
							<c:forEach var="orderView" items="${orderView}" varStatus="status">
								<li class="orderList-Info">
									<div class="orderDate">
										<p><fmt:formatDate value="${orderView.orderDate}" pattern="yyyy-MM-dd"/></p>
									</div>
									
									<div class="orderid">
										<p>${orderView.orderId}</p>
									</div>
									<div class="orderInfo">
										<img src="${pageContext.request.contextPath}/resources/${orderView.img}">
										<p>${orderView.goodsName}</p>	
									</div>
									
									<div class="orderStock">
										<p>${orderView.cartStock}</p>
									</div>
									
									<div class="orderPrice">
										<p><fmt:formatNumber pattern="###,###,###" value="${orderView.dcPrice * orderView.cartStock}" />원</p>
									</div>
									
									<div class="orderdelivery">
										<p>${orderView.delivery}</p>
									</div>
									
								</li>
								
								<c:if test="${status.last}" >
								<div class="delivery">
									<div class="delivery-contianer">
										<label>배송정보</label>
										<table>
											<tr>
												<th>수령인</th>
												<td>${orderView.orderRec}</td>
											</tr>
											<tr>
												<th>연락처</th>
												<fmt:formatNumber var="orderPhone" value="${orderView.orderPhone}" pattern="###,###,###"/>
												<td><c:out value="${fn:replace(orderPhone, ',', '-')}" /></td>
											</tr>
											
											<tr>
												<th>배송지</th>
												<td>(${orderView.userZipe}) ${orderView.userAddr} ${orderView.userAddr2}</td>
											</tr>
										</table>
									</div>
									<!-- delivery-contianer End -->
									
										<div class="amount">
											<span>총 결제금액</span>
											<p><fmt:formatNumber pattern="###,###,###" value="${orderView.amount}"/>원</p>
										</div>
										<!-- amount End -->
										
										
									</div>
									<!-- delivery End -->
								</c:if>
							</c:forEach>
						</ul>
						
				</div>
				<!-- orderList-container End -->
			</div>
			<!-- container End -->
			
		</section>
		<!-- main End -->
		<%@ include file="../include/footer.jsp" %>
	</section>	
	

</body>
</html>