<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.13.0/css/all.css"
    integrity="sha384-Bfad6CLCknfcloXFOyFnlgtENryhrpZCe29RTifKEixXQZ38WheV+i/6YWSzkz3V" crossorigin="anonymous">
    <link rel="stylesheet" href="/kpop/resources/css/cartlist.css">
    <link rel="stylesheet" href="/kpop/resources/css/restet.css">
    <link rel="stylesheet" href="/kpop/resources/css/index.css">
    <script type="text/javascript" src="/kpop/resources/js/jquery-3.5.1.js"></script>
	<script src="/kpop/resources/js/cart.js"></script>
</head>
<body>
	<section id="full-wrap">
		<%@ include file="../include/header.jsp" %>
		<section id="main">
			<div class="container">
				<div class="CartList">
				
					<div class="cartList-container">
						<c:set var="sum" value="0" />
							<ul>
								<c:forEach items="${cartList}" var="cartList" varStatus="status">
								<c:if test="${status.first}">
								<li class="allList">
									<div class="allCheck">
										<input type="checkbox" name="allCheck" id="allCheck" value="${sum+(cartList.dcPrice * cartList.cartStock)}" />
		    							<label for="allCheck">모두선택</label> 
		    							<button type="button" class="select_delete">선택삭제</button>
									</div>
									<!-- allCheck End -->
							
								</li>
								</c:if>
									<li class="cartList-li">
										<div class="Check_Box">
												<input type="checkbox" name="Check" class="Check" data-cartnum="${cartList.cartNum}"
												value="${(cartList.dcPrice * cartList.cartStock)}" />
										</div>
										<!-- Check_Box End -->
										
										<div class="Cart_info">
											<a href="/kpop/shop/shopview?goodsnumber=${cartList.goodsNumber}">
												<img src="${pageContext.request.contextPath}/resources/${cartList.img}"/>
											</a>
											<ul>
												<li> 
													<span>상품명</span>
													<p><a href="/kpop/shop/shopview?goodsnumber=${cartList.goodsNumber}">${cartList.goodsName}</a></p>
												</li>
												<li> 
													<span>제품가격</span>
													<p><fmt:formatNumber pattern="###,###,###" value="${cartList.dcPrice}" />원</p>
												</li>
													<li> 
													<span>제품 포인트</span>
													<p><fmt:formatNumber pattern="###,###,###" value="${cartList.point * cartList.cartStock}" />원</p>
												</li>
												<li> 
													<span>구입수량</span>
													<p>${cartList.cartStock}개</p>
												</li>
												
												<li>
													
													<span>구입금액</span>
													<p><fmt:formatNumber pattern="###,###,###" value="${(cartList.dcPrice * cartList.cartStock)}"  />원</p>
												</li>
											</ul>
										</div>
										<!-- Cart_info End -->
										
										<div class="one-Delete">
											<button type="button" class="delete_Btn" data-cartnum="${cartList.cartNum}">삭제</button>
										</div>
									</li>
					
									<c:set var="sum" value="${sum+(cartList.dcPrice * cartList.cartStock)}" />
									<c:set var="pointsum" value="${pointsum+(cartList.point * cartList.cartStock)}" />
									<c:set var="sellCount" value="${sellCount+cartList.cartStock}" />
									<!-- 판매량 미처리 -->
									<%-- <c:set var="goodsnumber" value="${cartList.goodsnumber}" /> --%>
					
								</c:forEach>
							</ul>
							
							<div class="totalsum-container">
								<ul>
									<li class="sum"> 
										<span>총가격 </span>
										<div class="select_sum"></div>
									</li>
									
									<li >
										<input type="button" value="주문하기"  class="orderGo_Btn"/>
									</li>
								</ul>
				
							</div>
							<!-- totalsum-container End -->
					</div>
					<!-- cartList-container End -->
					
					
				</div>
				<!-- CartList-->
		<!--  주문정보 입력 -->		
		<div class="order-container">
			<form role="form" method="post" autocomplete="off">
			
				<input type="hidden" name="Amount" value="${sum}" />
				<!-- order table에 합계포인트 넣어줌 -->
				<input type="hidden" name="Point" value="${pointsum}" />
				<!-- member table에 포인트 추가해줌 -->
				<input type="hidden" name="userPoint" value="${pointsum}" />
					
					<div class="order-info">
	     				<label>수령인</label>
	      				<div class="order-input">
	      					<input type="text" name="orderRec" id="orderRec" required="required">
	     				</div>
	      				<!-- order-input End -->
	     			</div>
	     			<!-- order-info End -->
	      	   	
	    			<div class="order-info">
	     				<label>연락처</label>
	      				<div class="order-input">
	      					<input type="tel" maxlength="11" name="orderPhone" id="orderphone"  placeholder="-제외하고 입력해주세요" required="required">
	      				</div>
	      				<!-- order-input End -->
	     			</div>
	     			<!-- order-info End -->
	      	
	     	<!-- 주소 API -->
	     	<div class="addrAPI">
	        	<div class="order-info addr-info">
	        		<label>주소</label>
	        		<div class="order-input addr-input">
	        		<div class="zipe">
	      				<input type="text" name="userZipe"   class="zipe-input" id="sample2_postcode" placeholder="우편번호">
						<input type="button"  class="zipe-Btn" onclick="sample2_execDaumPostcode()" value="우편번호 찾기"><br>
				 	</div>
				 	<!-- zipe End -->
				 	
					<input type="text" name="userAddr"  id="sample2_address" placeholder="주소">
					<input type="text" name="userAddr2" id="sample2_detailAddress" placeholder="상세주소">
					<input type="hidden" name="extraAddr" id="sample2_extraAddress" placeholder="참고항목">
				</div>
				<!-- order-input End -->
			</div>
			<!-- order-info End -->
					<!-- iOS에서는 position:fixed 버그가 있음, 적용하는 사이트에 맞게 position:absolute 등을 이용하여 top,left값 조정 필요 -->
					<div id="layer" style="display:none;position:fixed;overflow:hidden;z-index:1;-webkit-overflow-scrolling:touch;">
					<img src="//t1.daumcdn.net/postcode/resource/images/close.png" id="btnCloseLayer" style="cursor:pointer;position:absolute;right:-3px;top:-3px;z-index:1" onclick="closeDaumPostcode()" alt="닫기 버튼">
					</div>

<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    // 우편번호 찾기 화면을 넣을 element
    var element_layer = document.getElementById('layer');

    function closeDaumPostcode() {
        // iframe을 넣은 element를 안보이게 한다.
        element_layer.style.display = 'none';
    }

    function sample2_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("sample2_extraAddress").value = extraAddr;
                
                } else {
                    document.getElementById("sample2_extraAddress").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample2_postcode').value = data.zonecode;
                document.getElementById("sample2_address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("sample2_detailAddress").focus();

                // iframe을 넣은 element를 안보이게 한다.
                // (autoClose:false 기능을 이용한다면, 아래 코드를 제거해야 화면에서 사라지지 않는다.)
                element_layer.style.display = 'none';
            },
            width : '100%',
            height : '100%',
            maxSuggestItems : 5
        }).embed(element_layer);

        // iframe을 넣은 element를 보이게 한다.
        element_layer.style.display = 'block';

        // iframe을 넣은 element의 위치를 화면의 가운데로 이동시킨다.
        initLayerPosition();
    }

    // 브라우저의 크기 변경에 따라 레이어를 가운데로 이동시키고자 하실때에는
    // resize이벤트나, orientationchange이벤트를 이용하여 값이 변경될때마다 아래 함수를 실행 시켜 주시거나,
    // 직접 element_layer의 top,left값을 수정해 주시면 됩니다.
    function initLayerPosition(){
        var width = 300; //우편번호서비스가 들어갈 element의 width
        var height = 400; //우편번호서비스가 들어갈 element의 height
        var borderWidth = 5; //샘플에서 사용하는 border의 두께

        // 위에서 선언한 값들을 실제 element에 넣는다.
        element_layer.style.width = width + 'px';
        element_layer.style.height = height + 'px';
        element_layer.style.border = borderWidth + 'px solid';
        // 실행되는 순간의 화면 너비와 높이 값을 가져와서 중앙에 뜰 수 있도록 위치를 계산한다.
        element_layer.style.left = (((window.innerWidth || document.documentElement.clientWidth) - width)/2 - borderWidth) + 'px';
        element_layer.style.top = (((window.innerHeight || document.documentElement.clientHeight) - height)/2 - borderWidth) + 'px';
    }
</script>
	 
	  </div>    	
	  <!-- arrdAPI End -->   

						  
						  <div class="order_Btn">
						  		<button type="submit" class="orderOk_Btn">주문</button>
						  		<button type="button" class="cancel_Btn">취소</button>
						  </div>
					</form>
				</div>
				<!-- order-container End -->
			</div>
			<!-- container End -->
			</section>
			<!-- main End -->
			
			<%@ include file="../include/footer.jsp" %>
	</section>

</body>
</html>