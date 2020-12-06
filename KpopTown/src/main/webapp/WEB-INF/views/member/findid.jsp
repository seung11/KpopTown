<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.13.0/css/all.css"
        integrity="sha384-Bfad6CLCknfcloXFOyFnlgtENryhrpZCe29RTifKEixXQZ38WheV+i/6YWSzkz3V" crossorigin="anonymous">
<link rel="stylesheet" href="../resources/css/restet.css">
<link rel="stylesheet" href="/kpop/resources/css/index.css">
<link rel="stylesheet" href="../resources/css/member.css">
<script src="../resources/js/jquery-3.5.1.js"></script>
<script  type="text/javascript"  src="../resources/js/member.js"></script>
</head>
<body>
	<section id="wrap">
			<%@include file="../include/header.jsp" %>
		<section id="main">
			<div class="container">	
				<h1>아이디 찾기</h1>
				<div class="findid-wrap">
					<!-- 이메일,번호로 찾기 선택 라디오 버튼 -->
					<div class="radio-Btn">
				 		<!-- 이메일로찾기 라디오버튼-->
				 		<ul>
				 			<li><label>이메일로 찾기</label></li>
				 			<li><input type="radio" id="findid_BtnEmail" checked="checked"></li>
				 		</ul>
				 		
				 		<!-- 휴대폰번호로 찾기 라디오버튼-->
				 		<ul>
				 			<li><label>휴대폰번호로 찾기</label></li>
				 			<li><input type="radio" id="findid_BtnPhone"></li>
				 		</ul>
			    	</div>
					<!-- radio-Btn End -->
				 
				
		<!-- 이메일로 찾기 폼 -->
		<form role="form" method="post">
			<div id="email" class="idfind-form" >
				<div class="idfind-input" >
					<ul>
						<li>이름</li>
							<li>
								<input type="text" id="userName" name="userName" required placeholder="이름">
							</li>
					</ul>
							
					<ul>
						<li>이메일</li>
						<li>
							<input type="email" id="userEmail" name="userEmail" required placeholder="가입한 이메일주소">
						</li>
					</ul>
				</div>
				<!-- idfind-input End -->		
						 
				<div class="Btn">
					<button type="submit" id="findid_Btn">아이디찾기</button>
				</div>
					
			</div>
			<!-- idfind-form End -->
		</form>	
	
				
			 <!-- 휴대폰번호찾기 -->
				<form role="form" method="post">
						
					<div id="phon" class="idfind-form" style="display:none;">
						<div class="idfind-input">
							<ul>
								<li>이름</li>
								<li>
									<input type="text" id="userName2" name="userName" required placeholder="이름">
								</li>
							</ul>
							<ul>
								<li>전화번호</li>
								<li>
									<input type="text" maxlength="11" id="userPhone" name="userPhone" required placeholder="가입한 전화번호">
								</li>
							</ul>
						</div>
						<!-- idfind-input End -->	
							
						<div class="Btn">
							<button type="submit" id="findid_Btn2">아이디찾기</button>
						</div>
					</div>
					<!-- idfind-form End -->
				</form>	
				
				
				
				
				
				
				<div class="find-Btn">
              	
                <input type="button" id="signup-location"value="회원가입"/>
                <input type="button" id="singnin-location" value="로그인"/>
                <input type="button" id="findpw-location" value="비밀번호 찾기"/>
                
            </div>  
            <!-- find-Btn -->  
		      </div>
		    <!-- findid-wrap End-->
		    
		    
		    <!-- modal 영역 -->
		    <div class="modal-wrap">
		    	<div class="modal">
		     		<ul>
		     			<li><span>사용자 아이디</span></li>
		     			<li><span id="findid">test</span></li>	   	
		     		</ul>
		     	
		     		<span class="fas fa-times" id="modal-cancel"></span>
		     	</div>
		     	<!-- modal -->
		     	
		     
		     </div>
		     <!-- modal-wrap End -->
		</div>
		<!-- container End -->
			
		
		</section>
		
		<%@include file="../include/footer.jsp" %>
	</section>
</body>
</html>