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
<title>상세보기</title>
<script>
// 제품 리뷰 목록 
function reviewList() {
	
	var goodsnumber = ${view.goodsNumber};
	
	// 비동기식 데이터 요청
	$.getJSON("/kpop/shop/shopview/reviewList" + "?goodsnumber=" + goodsnumber, function(data){
		var str = "";
		
		$(data).each(function(){
			
			console.log(data);
			
		
			str += "<li data-rwNumber='" + this.rwNumber + "'>"
				 + "<div class='userInfo'>"
				 + "<span class='userid'>" + this.userid+ "</span>"
				// + "<span class='date'>" + rwDate + "</span>"
				 + "</div>"
				 + "<div class='ConInfo'>"
				 + "<div class='rwTitle'>" + this.rwTitle + "</div>"
				 + "<div class='rwCon'>" + this.rwCon + "</div>"
				 + "</div>"
				 + "<div class='reviewButton'>"
				 + "<button type='button' class='review-Delete' data-rwNumber='" + this.rwNumber + "'>삭제</button>"
				 + "<button type='button' class='review-Modify' data-rwNumber'"+ this.rwNumber +"'>수정</button>"
				 + "</div>"
				 + "</li>";											
		});
		
		// 조립한 HTML코드를 추가
		$("div.reviewList ul").html(str);
	});
	
}
</script>
</head>
<body>
<section id="wrap">
	<%@include file="../include/header.jsp" %>

<section id="main">
<div class="container">
  <form action="" role="form" method="post">		

<input type ="hidden" name="gnum" id="gnum" class="goodsnumber" value="${view.goodsNumber}"/>
	<div class="detail-view">
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
		    			<input class='dcprice-input' type="hidden" value="${view.dcPrice}">
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
		    		<input class='dcprice-input' type="hidden" value="${view.dcPrice}">
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
					<span>제작사</span>
					<span>${view.company}</span>
				</li>
		
			</ul>
			
			<ul class="cartStock">
				<li class="cart"><span>주문수량 </span>
					<button type="button" class="minus">-</button> 
					<input type="text"  id="num" class="numBox"  min="1" max="${view.stock}" value="1"  readonly="readonly"> 
					<button type="button" class="plus">+</button>
					<input type="hidden" value="${view.stock}" class="gdsStock_hidden" />
				</li>
			</ul>
	
			<ul>
				<li class="total-price">
					<h1 class="total-title">총 금액</h1>
					<span><input type="text" class="total" readonly="readonly"></span>
				</li>
			</ul>
	
			<ul class="addCart"> 
				<li> 
					<button type="button" id="addCart_Btn">장바구니</button>
				</li>
			</ul>
					
			<div class="hanteo">
				<img class="ht" src="/kpop/resources/img/HTfamily_web_KR.png">
				<img class="gaon" src="/kpop/resources/img/gaon_web_COM.jpg" >
			</div>
			<!--hanteo End -->
	 	</div>
		<!-- view-text -->
	</div>
	<!-- poster-title -->
		
	<!-- 제품 소개 -->
	<div class="detail">
	   	<p>${view.goodsDetail}</p>
	</div>
	<!-- datail End -->
</div>
	<!-- detail-view -->
	
	 <!-- 반품 교환 안내 -->
	 <div class="return-container">
	 	<h1 class="return-title">반품/교환안내</h1>
		<table class="return">
				<tr>
					<th>반품/교환 방법</th>
					<td>"MyPage>주문조회>반품/교환신청", 1:1상담 > 반품/교환 또는 고객센터(070-1234-5678)
						 판매자 배송상품은 판매자와 반품/교환이 협의된 상품에 한해 가능</td>
				</tr>
		
				<tr>
					<th>반품/교환 가능기간</th>
					<td>o 변심반품 수령 후 20일(단, 중고매장 상품은 구매 후 구매 다음날로 부터 7일<br>
						o 파본 등 상품결함 시 '문제점 발견 후 30일(단, 수령일로 부터 3개월)' 이내
					</td>
				</tr>
				
				<tr>
					<th>반품/교환 비용</th>
					<td>o 변심 혹은 구매착오의 경우에만 반송료 고객 부담<br>
							* 취소수수료 : 수입제반비용(국내 까지의 운송비, 관세사비, 보세창고료, 내륙 운송비, 통관비 등)과 재고리스크(미판매 리스크, 환차손)에 따른 비용 등
							단, 아래의 주문/취소 조건인 경우, 취소 수수료 면제
 							- 오늘 00시~06시 주문을 오늘 06시 이전 취소
 							- 오늘 06시 이후 주문 후 다음 날 06시 이전 취소
					</td>
				</tr>
				
				<tr>
					<th>반품/교환 불가 사유</th>
					<td>
						o 소비자의 책임 있는 사유로 상품 등이 손실 또는 훼손된 경우 <>
						o 소비자의 사용, 포장 개봉에 의해 상품 등의 가치가 현저히 감소한 경우 <br>
						o 복제가 가능 또는 단기간 내 완독 가능 상품의 자체 포장이나 래핑을 훼손한 경우 <br>
						o 세트 상품 일부만 반품 불가(전체 반품 후 낱권 재구매) <br>
						o 시간의 경과에 의해 재판매가 곤란한 정도로 가치가 현저히 감소한 경우
					</td>
				</tr>
				
				<tr>
					<th>소비자 피해보상 환불지연에 따른 배상</th>
					<td>
						o 상품의 불량에 의한 반품, 교환, A/S, 환불, 품질보증 및 피해보상 등에 관한 사항은 소비자분쟁해결기준 (공정거래위원회 고시)에 준하여 처리됨 <br>
						o 대금 환불 및 환불 지연에 따른 배상금 지급 조건, 절차 등은 전자상거래 등에서의 소비자 보호에 관한 법률에 따라 처리함
					</td>
				</tr>
		</table>
	 </div>
	 <!-- return-container End -->
	 
	 <!-- 리뷰 -->
	 
	 
</form>	
	 
	<div class="review-container">
			<c:if test="${member == null }">
				<a href="/kpop/member/signin"><input type="button" class="review_Btn" value="리뷰작성"></a>
			</c:if>
			
			<c:if test="${member != null }">
			<input type="button" id="review_Btn" class="review_Btn" value="리뷰작성">
		<div class="Review-Form">
						<form role="form" method="post" autocomplete="off">
						
							<input type="hidden" name="goodsnumber" id="goodsnumber" value="${view.goodsNumber}">
						
							<div class="review-area">
									<div class="title-input">
									<span>제목</span><input type="text" name="rwTitle" id="rwTitle">
									</div>
								<textarea name="rwCon" id="rwCon" class="rwCon"></textarea>
							</div>
							<div class="input_area">
								<button type="button" id="RewSubmit_Btn" class="RewSubmit_Btn">소감 남기기</button>
								
							</div>
							
							
						</form>
					</div>
			</c:if>
	 		
	 	<div class="reviewList">
			<label>Review</label>
			<ul></ul>     
			<script>
				reviewList();
			</script>
		</div>
		<!-- reviewList End -->
	
	
	

 </div>
<!-- review-Container -->
	 
	
	 
</div>
<!-- contaienr End -->

	

</section>

	<%@include file="../include/footer.jsp" %>
</section>
<!--  wrap End -->

</body>
</html>