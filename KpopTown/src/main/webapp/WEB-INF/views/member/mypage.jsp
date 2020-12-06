<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.13.0/css/all.css"
        integrity="sha384-Bfad6CLCknfcloXFOyFnlgtENryhrpZCe29RTifKEixXQZ38WheV+i/6YWSzkz3V" crossorigin="anonymous">
<link rel="stylesheet" href="../resources/css/restet.css">
<link rel="stylesheet" href="/kpop/resources/css/index.css">
<link rel="stylesheet" href="../resources/css/member.css">
<script src="../resources/js/jquery-3.5.1.js"></script>
<script  type="text/javascript"  src="../resources/js/member.js"></script>
</head>
<style>
</style>
<body>
	<section id="full-wrap">
			<%@include file="../include/header.jsp" %>
		
		<section id="main">
			<div class="container mypage-container">
				<div class="mypage">
					<ul class="member-Info">
				
						<li>
							<a href="/kpop/member/modify">
								<i class="fas fa-user-edit"></i>
								회원정보 수정
							</a>
						</li>
						
						<li>
							<a href="/kpop/member/delet">
								<i class="fas fa-user-times"></i>
								회원탈퇴
							</a>
						</li>
					</ul>
					<!-- member-Info End -->
					
					<ul class="member-Info order">	
						<li>
							<a href="/kpop/shop/cartList">
								<i class="fas fa-shopping-cart"></i>
								장바구니
							</a>
						</li>
						
						<li>
							<a href="/kpop/shop/orderList">
								<i class="fas fa-th-list"></i>
								주문목록
							</a>
						</li>
					</ul>
					<!-- member-order End -->
					
				</div>
				<!-- mypage End -->
			</div>
		</section>
		
			<%@include file="../include/footer.jsp"  %>
	</section>

</body>
</html>