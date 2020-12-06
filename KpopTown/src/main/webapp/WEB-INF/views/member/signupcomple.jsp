<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입완료</title>
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
	<%@ include file="../include/header.jsp" %>
<section id="main">
	<div class="container">
		<h1>환영합니다 회원가입 되었습니다 :)</h1>
		<h1>로그인</h1>
		<!-- 로그인 폼 -->
		<form action="/kpop/member/signin" method="post">
			<div class="signin-wrap">	
            	<div class="signin-info">
                	<div class="signin-input">
                   	 	<input type="text" name="userid" id="userid" placeholder="아이디">
                   		<input type="password" name="userpass" id="userpass" placeholder="비밀번호">
                	</div>
                	<!-- signin-input -->
            
            	<!-- 로그인 버튼 -->
           		<div class="signin-Btn">
                	<input type="submit" id="singin_Btn" value="로그인"/>
                </div>
                <!-- signin-Btn -->
                
             </div>
             <!-- signin-info -->
             
             <div class="fail-signin">	          		
			 	<c:if test="${msg == false }">
					<span>아이디 또는 비밀번호를 다시 확인해주세요.</span>
				</c:if>
			</div>
			<!-- fail-singin End -->
          </div>
          <!-- signin-wrap -->  
			
		  <!-- 아이디,비밀번호 찾기 버튼 -->
       	  	<div class="find-Btn">
              	<input type="button" id="signup-location"value="회원가입"/>
                <input type="button" id="findid-location" value="아이디 찾기"/>
                <input type="button" id="findpw-location" value="비밀번호 찾기"/>
             </div>  
            <!-- find-Btn -->  
  		
  		</form>
	</div>
</section>
<!-- main End -->
	
		<%@include file="../include/footer.jsp" %>
</section>
</body>
</html>