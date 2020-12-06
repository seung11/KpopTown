<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
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

<section id="wrap">
    <%@ include file="../include/header.jsp" %>
    
  <section id="main">
  	<div class="container">	
  	 		<h1>회원탈퇴</h1>
	<form role="form" method="post" onsubmit="return check()">
		<div class="delet-wrap">
	       <!-- 회원정보수정 input -->
	       <div class="delet-info id-info">
	      	 <label>아이디</label>
	      	 <div class="delet-input">
	      	 	<input type="hidden" id="userid"  name="userid" value="${member.userid }" readonly="readonly" />
	      	 	<span class="id_span">${member.userid }</span>	
	      	</div>
	      	<!-- delet-input -->
	      </div> 
	      <!-- delet-info End -->
	      	
	     <div class="delet-info pw-info">
	      	<label>비밀번호</label>
	      	<div class="delet-input">
	      		<input type="password" name="userPass" id="userPass" placeholder="8자이상+영문,숫자 포함" required="required">
	      	</div>
	      	<!--delet-input End -->
	      </div>
	     <!-- delet-info End -->
	      		
	     <div class="delet-info repw-info">
	      	<label>비밀번호 확인</label>
	      	<div class="delet-input">
	      		<input type="password" id="re-userpass" placeholder="비밀번호 재입력" required="required">
	      		<div id="re_pwmsg"></div>
	        </div>
	      	<!--delet-input End -->
	     </div>
	     <!--delet-info End -->
	      	
	  	<!-- 탈퇴버튼 -->	
		 <div class="delet_Btn">	
	    	 <input type="submit" class="delet-ok" value="탈퇴"/> 
	     	 <input type="reset"  class="signup-reset" value="취소"/>
	    </div> 
	    <!-- signup-info --> 
	      </div>
	      <!--  signup-form -->
	      
	  </form>
	  </div>
	  <!-- contianer End -->
	  </section>  
	  <!-- main -->
	  
	  <%@include file="../include/footer.jsp" %>
</section>
</body>

</html>