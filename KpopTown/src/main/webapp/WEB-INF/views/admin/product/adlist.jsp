<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 상품목록</title>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.13.0/css/all.css"
        integrity="sha384-Bfad6CLCknfcloXFOyFnlgtENryhrpZCe29RTifKEixXQZ38WheV+i/6YWSzkz3V" crossorigin="anonymous">
<script type="text/javascript" src="/kpop/resources/js/jquery-3.5.1.js"></script>
<link rel="stylesheet" href="/kpop/resources/css/admin.css">
<link rel="stylesheet" href="/kpop/resources/css/restet.css">
<link rel="stylesheet" href="/kpop/resources/css/index.css">
</head>
<style>
 
  img{
  width: 80px; height: 80px;}
</style>
<body>
	<section id="full-wrap">
		 <%@include file="../include/header.jsp" %>
	<section id="main-wrap">
		<div class="main">
			<%@include file="../include/aside.jsp" %>
			<div class="admin-container">
				<ul class="list-title">
					<li>포스터이미지</li>
					<li>제품번호</li>
					<li>카테고리</li>
					<li>제품명</li>
					<li>제품가격</li>
					<li>할인률</li>
					<li>할인가격</li>
					<li>재고수량</li>
					<li>제품등록날짜</li>
				</ul>
				
					<c:forEach var="list" items="${list }">
					<ul class="list-info">
						<li><a href="/kpop/admin/product/adview?goodsnumber=${list.goodsNumber}"><img src="${pageContext.request.contextPath}/resources/${list.img}"></a></li>
						<li>${list.goodsNumber }</li>
						<li>${list.cateName }</li>
						<li class="list_goodsname"><a href="/kpop/admin/product/adview?goodsnumber=${list.goodsNumber}">${list.goodsName}</a></li>
						<li><fmt:formatNumber value="${list.origPrice }" pattern="###,###,###" />원</li>
						<li>${list.dc }%</li>
						<li><fmt:formatNumber value="${list.dcPrice }" pattern="###,###,###" />원</li>
						<li>${list.stock }</li>
						<li><fmt:formatDate value="${list.regDate}" pattern="yyyy.MM.dd"/></li>
				</ul>
					</c:forEach>
					
				<div class="pageing">
					<ul class="page_Btn">
						<!-- 이전 -->
    					<c:if test="${pageMaker.prev}">
   							<li>
        						<a href="/kpop/admin/product/adlist?page=${pageMaker.startPage-1 }">
        						<i class="fa fa-chevron-left"></i>
        						</a>
   							</li>
   						</c:if>
   						
    			<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="pageNum">
   					 <li class="pageNum">
       					<a href="/kpop/admin/product/adlist?page=${pageNum}">${pageNum}</a>
           			</li>
    			</c:forEach>
    			<!-- 다음 -->
  		 		<c:if test="${pageMaker.next && pageMaker.endPage >0 }">
   					<li>
        				<a href="/kpop/admin/product/adlist?page=${pageMaker.endPage+1 }">
        				<i class="fa fa-chevron-right"></i>
        				</a>
    				</li>
    			</c:if>
				</ul>
				<!-- page_Btn End -->
 
				</div>	
					
			</div>
			<!-- admin-container End -->
		</div>
		<!-- main-wrap End -->
	</section>
	<!-- main End -->
	 <%@include file="../include/footer.jsp" %>
	</section>
	<!-- full-wrap End -->
<!-- 	
	<script>
	$(".drop-menu").mouseover(function(){
		$(".drop-menu>ul").stop().slideDown(600);
	});
	$(".drop-menu").mouseout(function(){
		
		$(".drop-menu>ul").stop().slideUp(600);
	});
	
	
</script>

 -->
</body>
</html>