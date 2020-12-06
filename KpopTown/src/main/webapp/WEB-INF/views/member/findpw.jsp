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
				<h1>비밀번호 찾기</h1>
				<div class="findpw-wrap">
				<!-- 비밀번호 찾기 폼 -->
				<form role="form" method="post">
					<div id="email" class="pwfind-form" >
						<div class="pwfind-input" >
							<ul>
								<li>아이디</li>
								<li>
									<input type="text" class="userid" name="userid" required="required" placeholder="아이디">
								</li>
							</ul>
							<ul>
								<li>이메일</li>
								<li>
									<input type="email" id="userEmail" name="userEmail" required="required" placeholder="가입한 이메일주소">
								</li>
							</ul>
						</div>
						<!-- pwfind-input End -->		
						 <div class="Btn">
						 	<button type="submit" id="findpw_Btn">비밀번호찾기</button>
						 </div>
					</div>
					<!-- pwfind-form End -->
				</form>
				
				<div class="find-Btn">
              	
                <input type="button" id="signup-location"value="회원가입"/>
                <input type="button" id="singnin-location" value="로그인"/>
                <input type="button" id="findid-location" value="아이디 찾기"/>
                
            </div>  
            <!-- find-Btn -->  
		      </div>
		    <!-- findpw-wrap End-->
		    
		   
		</div>
		<!-- container End -->
			
		
		</section>
		
		<%@include file="../include/footer.jsp" %>
	</section>
</body>
</html>