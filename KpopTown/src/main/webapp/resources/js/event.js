$(document).ready(function(){
// 파일업로드
	$("#evImg").change(function(){
		
		if(this.files && this.files[0]){
			let reader = new FileReader;
			console.log(reader);
			reader.onload = function(data){
				$(".select_img img").attr("src" , data.target.result).width(500);
				
			}
			reader.readAsDataURL (this.files[0]);
		}
		
	});

	// 수정 , 삭제
		 		
	let formObj = $("form[role='form']");
	console.log(formObj);
	let goodsnumber = $(".btn-delete").val();
	console.log(goodsnumber);	 		 
		 		 
		//삭제
		$("#delete_Btn").click(function(){
			let con = confirm("정말로 삭제하시겠습니까?");		 
			if(con) {      
				formObj.attr("method","get")
				formObj.attr("action", "/kpop/admin/product/delete");
				formObj.submit();
			}
		});
		 		 
		//수정 
		$("#modify_Btn").click(function(){
			console.log("수정");
			formObj.attr("action", "/kpop/admin/product/goodsmodify");
			formObj.attr("method", "get")
			formObj.submit();
		});	 
		 		 
});
	
	// 가격 작성시 문자 입력시 지워짐
	let regExp = /[^0-9]/gi; // 정규식, 숫자만 허용 
	
	// 상품가격과 수량을 입력할 때마다 numCheck() 함수를 호출해서 this를 같이 보낸다
	$("#orgprice").keyup(function(){
		numCheck($(this)); 
		// numCheck() 함수는 현재 선택된 선택자를 selector에 저장한 뒤 , selector에 입력된 값을 정규식 표현에 맞게 변경한다
	});
	
	$("#dcprice").keyup(function(){
		numCheck($(this)); 
		// numCheck() 함수는 현재 선택된 선택자를 selector에 저장한 뒤 , selector에 입력된 값을 정규식 표현에 맞게 변경한다
	});
	
	$("#stock").keyup(function(){
		numCheck($(this));
	});
	
	function numCheck(selector){
		let tempVal = selector.val();
		selector.val(tempVal.replace(regExp,""));
	}
	

	 



