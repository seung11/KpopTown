<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품 리뷰 관리</title>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400;500;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="/kpop/resources/css/restet.css">
    <link rel="stylesheet" href="/kpop/resources/css/index.css">
    <link rel="stylesheet" href="/kpop/resources/css/admin.css">
    <link rel="stylesheet" href="/kpop/resources/css/adReview.css">
    <script type="text/javascript" src="/kpop/resources/js/jquery-3.5.1.js"></script>
</head>
<body>
	<section id="full-wrap">
		<%@ include file="../include/header.jsp" %>
		<section id="main-wrap">
			<div class="main">
			<%@include file="../include/aside.jsp" %>
				<div class="Review">
					<h1> 제품 리뷰 목록 </h1>
						<div class="admin-container">
					<c:forEach var="review" items="${review}">
							<ul class="review-Info">
								<li>
									<span>작성자</span>
									<p>${review.userid}</p>
								</li>
								
								<li>
									<span>작성된 제품</span>
									<a href="/kpop/shop/shopview?goodsnumber=${review.goodsNumber}">바로가기</a>
								</li>
								
								<li>
									<span>작성내용</span>
									<div class="rwCon">
										<span>제목</span><p>${review.rwTitle}</p>
										<span>내용</span><p>${review.rwCon}</p>
										
										<div class="delete">
										<form role="form" method="post">
										<input type="hidden" name="rwNumber" value="${review.rwNumber}" />
										<input type="submit" class="delete_${review.rwNumber}_Btn" value="삭제" />
										</form>
									</div>
									</div>
								</li>
								
							</ul>
					</c:forEach>
						</div>
						<!-- admin-container End -->
				</div>
				<!-- Review End -->
			</div>
			<!-- mainEnd -->		
		</section>
		<!-- main-wrap End -->
		<%@ include file="../include/footer.jsp" %>
	</section>	
	

</body>
</html>