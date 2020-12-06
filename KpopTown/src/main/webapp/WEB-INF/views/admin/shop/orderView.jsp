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
 	<link rel="stylesheet" href="/kpop/resources/css/adorderlist.css">
    <link rel="stylesheet" href="/kpop/resources/css/restet.css">
    <link rel="stylesheet" href="/kpop/resources/css/index.css">
    <link rel="stylesheet" href="/kpop/resources/css/admin.css">
    <script type="text/javascript" src="/kpop/resources/js/jquery-3.5.1.js"></script>
</head>
<body>
	<section id="full-wrap">
		<%@ include file="../include/header.jsp" %>
		<section id="main-wrpa">
			<<div class="main">
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
										<form role ="form" method="post" class="deliveryForm">
										<input type="hidden" name="orderId" value="${orderView.orderId}" >
											<input type="hidden" name="Delivery" class="delivery" value="">
										<div class="deliveryChange">

											<button type="button" class="delivery1_btn">배송중</button>
											<button type="button" class="delivery2_btn">배송완료</button>		
										</div>
										</form>
									</div>
									
								</li>
								
								<c:if test="${status.last}" >
								<div class="delivery">
									<div class="delivery-contianer">
										<label>배송정보</label>
										
										<input class="orderPhone" type="hidden" value="${orderView.orderPhone}" >
										<table>
											<tr>
												<th>수령인</th>
												<td>${orderView.orderRec}</td>
											</tr>
											<tr>
												<th>연락처</th>
												<td class="Phone"></td>
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
				<!-- admin-container End -->
			</div>
			<!-- main End -->
			
		</section>
		<!-- main-wrap End -->
		<%@ include file="../include/footer.jsp" %>
	</section>	
	
	<!-- 배송정보 표시 스크립트 -->
<script>
	$(".delivery1_btn").click(function(){
		$(".delivery").val("배송중");
		run();
	});
	
	$(".delivery2_btn").click(function(){
		$(".delivery").val("배송완료");
		run();
	});
	
	function run(){
		$(".deliveryForm").submit();
	}
	
	// 전화번호 문자열 자른뒤 구분자 넣기
	let orderPhone = $(".orderPhone").val();
	let orderPhone1 = orderPhone.substr(0,3);
	let orderPhone2 = orderPhone.substr(3,4);
	let orderPhone3 = orderPhone.substr(7,4);
/* 	
	console.log(orderPhone3); */
	$(".Phone").html(orderPhone1 + "-" + orderPhone2 + "-" + orderPhone3);
</script>
</body>
</html>