<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%> 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>   
 <%@taglib  prefix="spring" uri="http://www.springframework.org/tags" %> 
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>K-POP Town</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.13.0/css/all.css"
        integrity="sha384-Bfad6CLCknfcloXFOyFnlgtENryhrpZCe29RTifKEixXQZ38WheV+i/6YWSzkz3V" crossorigin="anonymous">
    <link rel="stylesheet" href="/kpop/resources/css/index.css">
    <link rel="stylesheet" href="/kpop/resources/css/restet.css">
    <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/jquery.slick/1.3.15/slick.css">
    <link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
</head>

<body>
	<section id="full-wrap">
		<%@include file="include/header.jsp" %>
	
	<section id="main-wrap">
	
	<!-- banner slide -->
	<div class="banner-slider">
	
		<div class="one-time">
		
			<div style="background: #edebe7;">
				<a href="http://localhost:8080/kpop/shop/shopview?goodsnumber=163">
					<img src="resources/img/baner1.png">
				</a>
            </div>

			<div style="background: #b5b5b5;">
				<a href="http://localhost:8080/kpop/shop/shopview?goodsnumber=164">
					<img src="resources/img/baner2.png">
				</a>
            </div>
                    
            <div style="background: #B7B7B7;">
                <a href="http://localhost:8080/kpop/shop/shopview?goodsnumber=219">
                    <img src="resources/img/baner3.jpg">
				</a>
			</div>
                    
			<div>
				<a href="http://localhost:8080/kpop/shop/shopview?goodsnumber=218">
					<img src="resources/img/baner4.png">
				</a>
            </div>
                    
            <div style="background: #1d2402;">
				<a href="http://localhost:8080/kpop/shop/shopview?goodsnumber=182">
					<img src="resources/img/baner5.png">
				</a>
            </div>
            
        </div>
        <!-- one-time End -->
     
     </div>
	<!-- banner slide end-->
            
    <!-- about-icon End -->        
	<div class="about-icon">
    	<div class="icon-container">
			<div><img src="resources/img/cd.png"></div>
			<div><img src="resources/img/lightstick.png"></div>
			<div><img src="resources/img/event.png"></div>
		</div>
	</div>
	<!-- about-icon End-->
	                         
	<!-- new Release -->
	<div class="new-Release">
		<p>New Release</p>
		<div class="new-Releasecont">
			<div class="new-container container">
				<!-- slider -->
				 <div class="new-Slide">
					<c:forEach var="newRelease" items="${newRelease}">
						 <div class="newRelease-List">
						 	<a href="/kpop/shop/shopview?goodsnumber=${newRelease.goodsNumber}">
						 		<img src="${pageContext.request.contextPath}/resources/${newRelease.img}">
						 	</a>
						</div>
					</c:forEach>
                  </div>
                  <!-- new-Slide End -->


                        <span class="newprev" id="new_prev"><i class="fas fa-chevron-left"></i></span>
                        <span class="newnext" id="new_next"><i class="fas fa-chevron-right"></i></span>
                    </div>
                    <!-- new-container End -->
		</div>
    	<!--new-Releascont-->
	</div>
	<!-- new Release end -->
	
	<!-- godos-banner -->
		<div class="goods-container container">
		<p data-aos="fade-right" data-aos-offset="330">offical goods</p>
			<!-- slider -->
			<div class="goods-slider">
				<div class="multiple-items">
                	
                	<div data-aos="fade-up" data-aos-offset="300" data-aos-duration="4000">
                    	<a href="/kpop/shop/shopview?goodsnumber=255">
                    	<img src="${pageContext.request.contextPath}/resources/img/goods.jpg">
						</a>
					</div>
                           
					<div data-aos="fade-up" data-aos-offset="300" data-aos-duration="4000">
						<a href="/kpop/admin/product/adview?goodsnumber=255">
                           <img src="${pageContext.request.contextPath}/resources/img/goods2.jpg">
						</a>
					</div>
                           	
					<div data-aos="fade-up" data-aos-offset="300" data-aos-duration="4000">
                         <a href="/kpop/shop/shopview?goodsnumber=260">
                            <img src="${pageContext.request.contextPath}/resources/img/goods3.jpg">
                         </a>
					</div>
                            
					<div data-aos="fade-up" data-aos-offset="300" data-aos-duration="4000">
						<a href="/kpop/shop/shopview?goodsnumber=259">
                           <img src="${pageContext.request.contextPath}/resources/img/goods4.jpg">
						</a>    
					</div>
                            
					<div data-aos="fade-up" data-aos-offset="300" data-aos-duration="4000">
						<a href="/kpop/shop/shopview?goodsnumber=256">
                           <img src="${pageContext.request.contextPath}/resources/img/goods5.jpg">
						</a>  
					</div>
                            
					<div data-aos="fade-up" data-aos-offset="300" data-aos-duration="4000">
						<a href="/kpop/shop/shopview?goodsnumber=258">
							<img src="${pageContext.request.contextPath}/resources/img/goods6.jpg">
						</a> 
					</div>

				</div>
				<!-- nultiple-items end-->

				<span class="prev" id="aro1_prev"><i class="fas fa-chevron-left"></i></span>
				<span class="next" id="aro1_next"><i class="fas fa-chevron-right"></i></span>
				
			</div>
			<!-- goods slider end-->
		</div>
		<!-- goods-container end-->

	 <!-- 이벤트 -->
	<div class="eventwrap">
		<div class="event container">
				<c:forEach var="event" items="${event}">
					<div class="event-img">
                        <a href="/kpop/shop/eventView?evNumber=${event.evNumber}">
                        	<img class="evImg" src="${pageContext.request.contextPath}/resources/${event.evImg}">
                        </a>
                        <div class="event-Hover">
                        	<span>${event.evTitle}</span>
                        </div>
                        <!-- event-Hover End -->
                   	 </div>
                   	 <!-- event-img -->
				</c:forEach>
		</div>
		<!-- event End-->
	</div>
	<!--event wrap End-->
	
	 <div class="rank container">

                <div class="albumrank">
                    <p data-aos="fade-up" data-aos-offset="300" data-aos-duration="4000">Best Albums</p>
                    <div data-aos="fade-up" data-aos-offset="300" data-aos-duration="4000" class="rankcont">
                        <div class="no1">
                            <div class="img-1rank">
                            	<a href="/kpop/shop/shopview?goodsnumber=218">
                            		<img src="${pageContext.request.contextPath}/resources/img/best.jpg">
                            	</a>
                            </div>
                            <p><a href="/kpop/shop/shopview?goodsnumber=218">방탄소년단 (BTS) - 앨범 [BE (Deluxe Edition)]</a></p>
                            <p class="price">KRY 39,400원</p>
                        </div>
                        <!--no1 End-->
                        <div class="other">
                            <div class="rank-other">
                                <div class="ranking-other"> 
                                	<a href="/kpop/shop/shopview?goodsnumber=196"> 
                                		<img src="${pageContext.request.contextPath}/resources/img/best2.jpg">
                                	</a>
                                </div>
                                <div class="ranktext-other">
                                    <p><a href="/kpop/shop/shopview?goodsnumber=196"> NCT - 키트앨범 [The 2nd Album RESONANCE Pt.1]</a></p>
                                    <p class="price">KRY 19,300원</p>
                                </div>
                                <!--ranktext-other End -->
                            </div>
                            <!--rank-other End-->

                            <div class="rank-other">
                                <div class="ranking-other"> 
                                	<a href="/kpop/shop/shopview?goodsnumber=163"> 
                                		<img src="${pageContext.request.contextPath}/resources/img/best3.jpg">
                                	</a>
                                </div>
                                <div class="ranktext-other">
                                    <p><a href="/kpop/shop/shopview?goodsnumber=163"> 세븐틴 - 스페셜앨범 [Semicolon]</a></p>
                                    <p class="price">KRY 16,300원</p>
                                </div>
                                <!--ranktext-other End -->
                            </div>
                            <!--rank-other End-->

                            <div class="rank-other">
                                <div class="ranking-other">
                                	<a href="/kpop/shop/shopview?goodsnumber=204"> 
                                		<img src="${pageContext.request.contextPath}/resources/img/best4.jpg">
                                	</a>
                                 </div>
                                <div class="ranktext-other">
                                    <p><a href="/kpop/shop/shopview?goodsnumber=204"> 몬스타엑스 - 정규앨범 3집 [FATAL LOVE]</a></p>
                                    <p class="price">KRY 19,300원</p>
                                </div>
                                <!--ranktext-other End -->
                            </div>
                            <!--rank-other End-->
                        </div>
                        <!--other End -->
                    </div>
                    <!--rankconts End-->

                </div>
                <!-- albumrank End-->

                <!-- goods rank -->
                <div class="goodsrank">
                    <p data-aos="fade-up" data-aos-offset="300" data-aos-duration="4000" data-aos-delay="300">Best
                        goods</p>
                    <div data-aos="fade-up" data-aos-offset="300" data-aos-duration="4000" data-aos-delay="300" class="rankcont">
                        <div class="no1">
                            <div class="img-1rank">
                            	<a href="/kpop/shop/shopview?goodsnumber=251"> 
                            		<img src="${pageContext.request.contextPath}/resources/img/gbest.jpg">
                            	</a>
                            </div>
                            <p><a href="/kpop/shop/shopview?goodsnumber=251"> [2021시즌그리팅] NCT 127 - 2021 시즌 그리팅</a></p>
                            <p class="price">KRW 38,000</p>
                        </div>
                        <!--no1 End-->
                        <div class="other">
                            <div class="rank-other">
                                <div class="ranking-other"> 
                                	<a href="/kpop/shop/shopview?goodsnumber=250"> 
                                		<img src="${pageContext.request.contextPath}/resources/img/gbest2.jpg">
                                	</a>
                                </div>
                                <div class="ranktext-other">
                                    <p><a href="/kpop/shop/shopview?goodsnumber=250">[2021시즌그리팅] 엑소 - 2021 시즌 그리팅</a></p>
                                    <p class="price">KRY 38,000원</p>
                                </div>
                                <!--ranktext-other End -->
                            </div>
                            <!--rank-other End-->


                            <div class="rank-other">
                                <div class="ranking-other">
                                	<a href="/kpop/shop/shopview?goodsnumber=253">
                                		<img src="${pageContext.request.contextPath}/resources/img/gbest3.jpg">
                                	</a>
                                </div>
                                <div class="ranktext-other">
                                    <p><a href="/kpop/shop/shopview?goodsnumber=253">[2021시즌그리팅] 몬스타엑스 - 2021 시즌 그리팅</a></p>
                                    <p class="price">KRY 40,000원</p>
                                </div>
                                <!--ranktext-other End -->
                            </div>
                            <!--rank-other End-->

                            <div class="rank-other">
                                <div class="ranking-other"> 
                                	<a href="/kpop/shop/shopview?goodsnumber=220">
                                		<img src="${pageContext.request.contextPath}/resources/img/gbest4.jpg">
                                	</a>
                                </div>
                                <div class="ranktext-other">
                                    <p><a href="/kpop/shop/shopview?goodsnumber=220">[2021시즌그리팅] 아스트로 - 2021 시즌 그리팅 (READY 버전)</a></p>
                                    <p class="price">KRY 40,000원</p>
                                </div>
                                <!--ranktext-other End -->
                            </div>
                            <!--rank-other End-->
                        </div>
                        <!--other End -->
                    </div>
                    <!--rankconts End-->
                </div>
                <!-- goodsrank End -->
            </div>
            <!-- rank End -->
  

	<div class="product-container container">
		<p>PRODUCT</p>
		 <div class="product">
			<c:forEach var="mainProduct" items="${mainProduct}">
				<div class="product-Info">	
				
					<div class="produtimg">
                       	<a href="/kpop/shop/shopview?goodsnumber=${mainProduct.goodsNumber}">
                        	<img src="${pageContext.request.contextPath}/resources/${mainProduct.img}">
                       	</a>
					</div>
					<!--productimg End -->
                        
					<p class="text">${mainProduct.goodsName}</p>
					<span class="product-price">
						<fmt:formatNumber value="${mainProduct.origPrice }" pattern="###,###,###" />원
					</span>
					→ <span class="dc-price">
						<fmt:formatNumber value="${mainProduct.dcPrice }" pattern="###,###,###" />원
					</span>
				</div>
				<!-- product-Info -->
			</c:forEach>  
		</div>
		<!-- product End -->
	</div>
	<!--product-container End-->
	      
              	
	
	</section>
	<!-- main-wrpa End -->
	     <%@include file="include/footer.jsp" %>
	
	</section>
	<!-- full-wrap End -->
	
	 <!--==========================================
                      script
    =============================================--->
      
    <script src="/kpop/resources/js/jquery-3.5.1.js"></script>
    <script type="text/javascript" src="https://kenwheeler.github.io/slick/slick/slick.js"></script>
    <script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
    <script src="/kpop/resources/js/main.js"></script>
 
 <!-- 스크롤 효과 -->
 <script>
        AOS.init({
            easing: '',
            duration: 1000
        })
    </script>
 
<!-- Event hover -->   
<script>
	$(".event-img").mouseover(function(){
	/*	$(this).css("opacity", 0.5); */
		$(this).find("img.evImg").css("opacity",0.6);
		$(this).find("img.evImg").css("transition","ease 0.5s");
		$(this).children("div.event-Hover").css("display","block");
		
	})
	
	$(".event-img").mouseout(function(){
		$(this).find("img.evImg").css("opacity",1);
		$(this).find("img.evImg").css("transition","ease 0.5s");
		$(this).children("div.event-Hover").css("display","none");
	
	})
</script> 
</body>