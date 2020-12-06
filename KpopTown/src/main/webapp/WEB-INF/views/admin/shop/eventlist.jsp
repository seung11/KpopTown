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
					<li>이벤트명</li>
					<li>이벤트등록날짜</li>
				</ul>
				
				<c:forEach var="event" items="${event}">
					<ul class="list-info">
						<li><a href="/kpop/admin/shop/eventView?evNumber=${event.evNumber}"><img src="${pageContext.request.contextPath}/resources/${event.evImg}"></a></li>
						<li>${event.evNumber }</li>
						<li class="list_goodsname"><a href="/kpop/admin/shop/eventView?evNumber=${event.evNumber}">${event.evTitle}</a></li>
						<li><fmt:formatDate value="${event.regdate}" pattern="yyyy.MM.dd"/></li>
					</ul>
				</c:forEach>
			
			</div>
			<!-- admin-container End -->
		</div>
		<!-- main-wrap End -->
	</section>
	<!-- main End -->
	 <%@include file="../include/footer.jsp" %>
	</section>
	<!-- full-wrap End -->

</body>
</html>