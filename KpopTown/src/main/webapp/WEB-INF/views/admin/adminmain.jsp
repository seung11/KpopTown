<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지 메인</title>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.13.0/css/all.css"
        integrity="sha384-Bfad6CLCknfcloXFOyFnlgtENryhrpZCe29RTifKEixXQZ38WheV+i/6YWSzkz3V" crossorigin="anonymous">
<script type="text/javascript" src="../resources/js/jquery-3.5.1.js"></script>
<link rel="stylesheet" href="../resources/css/admin.css">
<link rel="stylesheet" href="../resources/css/restet.css">
<link rel="stylesheet" href="/kpop/resources/css/index.css">
</head>
<body>
	<section id="full-wrap">
	<%@ include file="../include/header.jsp" %>
		<section id="main">
			<div class="main-wrap">		
				<div class="admin-container">
					 <ul class="admin-Info">
						<li>
							<a href="/kpop/admin/product/insert">
								<i class="far fa-keyboard"></i>
								상품등록
							</a>
						</li>
						
						<li>
							<a href="/kpop/admin/product/adlist">
								<i class="fas fa-th-list"></i>
								상품목록
							</a>
						</li>
						
						<li>
							<a href="/kpop/admin/shop/orderList">
								<i class="fas fa-truck"></i>
								주문관리
							</a>
						</li>
						
						<li>
							<a href="#">
								<i class="fas fa-users"></i>
								회원관리
							</a>
						</li>
						
						<li>
							<a href="/kpop/admin/shop/reviewList">
								<i class="fas fa-edit"></i>
								상품평 관리
							</a>
						</li>
						
						<li>
							<a href="/kpop/admin/shop/event">
								<i class="fas fa-gift"></i>
								이벤트 등록
							</a>
						</li>
					 </ul>
				</div>
				<!-- admin-container End -->
				
			</div>
			<!-- main-wrap End -->
		</section>
		<!-- full-wrap End -->
			<%@include file="../include/footer.jsp" %>
	</section>
</body>
</html>