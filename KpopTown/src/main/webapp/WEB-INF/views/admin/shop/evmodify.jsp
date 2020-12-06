<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이벤트 등록</title>
<script type="text/javascript" src="/kpop/resources/js/jquery-3.5.1.js"></script>
<script src="/kpop/resources/ckeditor/ckeditor.js"></script>
<script src="/kpop/resources/js/event.js"></script>
<link rel="stylesheet" href="/kpop/resources/css/admin.css">
<link rel="stylesheet" href="/kpop/resources/css/restet.css">
<link rel="stylesheet" href="/kpop/resources/css/index.css">

<style>
	table{ border-collapse: collapse; border:1px solid #000;}
</style>
</head>
<body>
<section id="full-wrap">
	<%@include file="../include/header.jsp" %>
<section id="main-wrap">
	<div class="main">
		<%@include file="../include/aside.jsp" %>
		<div class="admin-container">
			<h1>이벤트 등록</h1>
		<form role="form" method="post"  enctype="multipart/form-data">
		<div class="form-contaienr">
	
			<!-- 제품등록 input 영역 -->			                         
       		<div class="input">
       			<label for="evTitle">이벤트제목</label>
       			<input type="text" id="evTitle" name="evTitle" value="${event.evTitle}">
      		 </div>  
       
        
       		<div class="input">
       			<label for="evCon">내용</label>
       			<textarea rows="10" cols="100" id="evCon" name="evCon">${event.evCon}</textarea>
       		</div>   
       
        
      <%=request.getRealPath("/") %>
      <!-- 이미지 업로드 -->
            <div class="input">
       			<label for="evImg">이미지 </label>
       			<input type="file" id="evImg" name="file">
       			<div class="select_img"> <img src=""></div>
       			<img src="${pageContext.request.contextPath}/resources/${event.evImg}">
 				 <input type="hidden" name="evImg" value="${event.evImg}" />
       			
       		</div>
      
        
         <div class="input submit-wrap">
  		 	<input class="submit" type="submit" value="등록" >
       	 </div>  
		
			</div>
			<!--form-contaienr End -->			
			</form>
		</div>
		<!-- admin-container End -->
	</div>
	<!-- main End-->
	</section>
	<!-- main-wrap End -->
<%@include file="../include/footer.jsp" %>
</section>

	
<script>	
	//ck에디터
	 let ckeditor_config = {
			 resize_enaleb : false,
			 enterMode : CKEDITOR.ENTER_BR,
			 shiftEnterMode : CKEDITOR.ENTER_P,
			 filebrowserUploadUrl : "/kpop/admin/shop/eventImg"
	 	};
	 		 CKEDITOR.replace("evCon", ckeditor_config);
	</script>
</body>
</html>