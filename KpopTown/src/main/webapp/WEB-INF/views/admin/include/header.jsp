<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<body>
 <!-- header 영역 시작 -->
        <section id="header-wrap">
            <div class="toggle">
                <i class="fa fa-bars"></i>
            </div>
            <div class="menu-close nav">
                <div class="menu">
                    <a href="/kpop" class="home_Btn">
                    <img src="/kpop/resources/img/logo.png" alt="로고" class="logo">
					</a>
                    <ul class="cate">
                        <li><a href="/kpop/shop/shoplist?c=100" data-text="idol">아이돌</a></li>
                        <li><a href="/kpop/shop/shoplist?c=101" data-text="Ballade">발라드/R&B</a></li>
                        <li><a href="/kpop/shop/shoplist?c=102" data-text="hiphop">인디/힙합</a></li>
                        <li><a href="/kpop/shop/shoplist?c=103" data-text="Trot">트로트</a></li>
                        <li><a href="/kpop/shop/shoplist?c=104" data-text="other genres">그외장르</a></li>
                        <li><a href="/kpop/shop/shoplist?c=105" data-text="dvd">DVD</a></li>
                        <li><a href="/kpop/shop/shoplist?c=106" data-text="goods">굿즈</a></li>
                        <li><a href="/kpop/shop/eventList" data-text="Event">Event</a></li>
                    </ul>
                </div>
                <!--catelogo End-->

              <div class="memberSearch">
                  <ul class="member">
               	   <c:if test="${member == null }">
  					<li><a href="/kpop/member/signin">LOGIN</a></li>
  					<li><a href="/kpop/member/signup">JOIN</a></li>
  				</c:if>
  				
  				<c:if test="${member != null && member.grade != 9}">
  					<li><a href="/kpop/member/logout">LOGOUT</a></li>
  					<li><a href="/kpop/member/signup">JOIN</a></li>
  				</c:if>
  				
  				<c:if test="${member!=null && member.grade == 9 }">
  					<li><a href="/kpop/admin/adminmain">관리자 화면</a></li>
					<li><a href="/kpop">일반 화면</a></li>
					<li><a href="/kpop/member/logout">LOGOUT</a></li>
  				</c:if>
                        <li><a href="/kpop/shop/cartList">CART</a></li>      
                        <li><a href="/kpop/member/mypage">MYPAGE</a></li>
                        <!-- <li><a href="#">KO</a></li> -->
                    </ul>
                  <div class="search-Container">
                     <input class="search" name="keyword" type="text" placeholder="상품을 검색하세요">
                   	 <i class="fas fa-search"></i>
                  </div> 
                </div>
                <!--membersearch End-->
            </div>
            <!-- nav End-->

        </section>
</body>
</html>