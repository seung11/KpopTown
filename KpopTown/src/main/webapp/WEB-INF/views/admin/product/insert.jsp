<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품 등록</title>
<script type="text/javascript" src="/kpop/resources/js/jquery-3.5.1.js"></script>
<script src="/kpop/resources/ckeditor/ckeditor.js"></script>
<script src="/kpop/resources/js/admin.js"></script>
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
			<h1>제품 등록</h1>
		<form role="form" method="post"  enctype="multipart/form-data">
		<div class="form-contaienr">
			<div class="category-container input">
				<label>카데고리선택</label>
				<select class="category" name="cateCode">
					<option vlaue="">전체</option>
				</select>
			</div>
			<!-- cateogry-container End -->
						
			<!-- 제품등록 input 영역 -->			                         
       		<div class="input">
       			<label for="goodsName">상품명</label>
       			<input type="text" id="goodsName" name="goodsName">
      		 </div>  
       
     		 <div class="input">
       			<label for="stock">재고수량</label>
       			<input type="text" id="stock" name="Stock">
       		</div> 
        
       		<div class="input">
       			<label for="origprice">상품가격</label>
       			<input type="text" id="origprice" name="origPrice">
       		</div>  
       
       		<div class="input">
       			<label for="origprice">할인율</label>
       			<input type="text" id="dc" name="Dc">
      		 </div>  
                         
       		<div class="input">
       			<label for="dcPrice">판매가격</label>
       			<input type="text" id="gdsprice" name="dcPrice">
       		</div>  
                         
       		<div class="input">
       			<label for="point">마일리지</label>
       			<input type="text" id="point" name="Point">
      		</div>  
                         
       		<div class="input">
       			<label for="releasedate">발매일</label>
       			<input type="text" id="releasedate" name="releaseDate">
       		</div>  
       
       		<div class="input">
       			<label for="company">제작사</label>
       			<input type="text" id="company" name="Company">
       		</div>
                  
       		<div class="input">
       			<label for="goodsdetail">상품소개</label>
       			<textarea rows="10" cols="100" id="goodsdetail" name="goodsDetail"></textarea>
       		</div>   
       
        
      <%=request.getRealPath("/") %>
      <!-- 이미지 업로드 -->
            <div class="input">
       			<label for="img">이미지포스터 </label>
       			<input type="file" id="Img" name="file">
       			<div class="select_img"><img src=""></div>
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
	// 카테고리
	
	// 컨트롤러에서 데이터 받기 
	let jsonData = JSON.parse('${category}');
	console.log(jsonData);
	
	let cateArr = new Array();
	let cateObj = new Object();

	// 셀렉트 박스에 데이터 삽입할 데이터 준비 
	for(let i = 0; i<jsonData.length; i++){
		cateObj = new Object();  // 초기화
		
		cateObj.cateCode = jsonData[i].cateCode;
		cateObj.cateName = jsonData[i].cateName;
		
		cateArr.push(cateObj);
	
		
	}
	

	// 셀렉트 박스에 데이터 삽입 
	let cateSelect = $("select.category");
	for(let i = 0; i<cateArr.length; i++){
		cateSelect.append("<option value='" + cateArr[i].cateCode + "'>"
				+ cateArr[i].cateName + "</option>");	
	}
	
	//ck에디터
	 let ckeditor_config = {
			 resize_enaleb : false,
			 enterMode : CKEDITOR.ENTER_BR,
			 shiftEnterMode : CKEDITOR.ENTER_P,
			 filebrowserUploadUrl : "/kpop/admin/product/ckUpload"
	 	};
	 		 CKEDITOR.replace("goodsdetail", ckeditor_config);
	</script>
</body>
</html>