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
					<h1>회원정보  수정 성공</h1>
				<div class="modify-wrap">
					<div class="compleText">
						<p>회원정보가 정상적으로 수정 되었습니다</p>
						<p>보안을 위해 다시 로그인 해주세요 :)</p>
					</div>
					<div class="complete_Btn">
              			<input type="button" id="singnin-location"  class="modify-signin" value="로그인"/>
                
            		</div>  
           			 <!-- find-Btn -->  
		     	</div>
		    	<!-- findid-wrap End-->
		  </div>
		<!-- container End -->
			
		
		</section>
		
		<%@include file="../include/footer.jsp" %>
	</section>
</body>
</html>