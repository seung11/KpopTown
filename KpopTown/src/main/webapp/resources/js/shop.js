/**
 * 
 */
$(document).ready(function(){
	
	/*이건 뭐지?? 왜 해놨던거지??*/
/*	let data =$(".info-text").val()
	let result = data.split(",");
	let time = "";
 $(result).each (function(i){
		console.log(data);
		
		let resultarr = result[i];
		
		$(resultarr).each(function(j){
			time = time +"<li>" + resultarr + "</li>";
		
		})
		
		$(".time").append(time);
 })
	*/

	$(".plus").click(function(){
		var num = $(".numBox").val();
		var plusNum = Number(num) + 1;
		var stock = $(".gdsStock_hidden").val();
			
	 // gdsstock 수량 넘어가면 최대수량으로 고정되고 더이상 증가 되지 않음 
		if(plusNum  >  stock) {
		$(".numBox").val(num);
		alert("최대구매 수량은" + stock +"개 입니다");
		} else {
		 let num = $(".numBox").val(plusNum);	
			 
		}
	});

	// - 버튼을 누르면 수량이 감소하되, 1보다 밑으로 감소하지 않음
	$(".minus").click(function(){
		var num = $(".numBox").val();
		var minusNum = Number(num) - 1; 
		if(minusNum <= 0) {
			$(".numBox").val(num);
		} else {
			$(".numBox").val(minusNum);		
		
		}
	});

	/*var stock = $(".gdsStock_hidden") 값 확인 할 때 
	 * object Object로 나와서   값 확인 하는 용도로 사용 */
  /*   for (var stock in object) {
      alert("stock: " + stock + " / " + object[stock])
      
      	alert(JSON.stringify(stock ));
	
      }*/
	
	// 합계 계산하기
	let dcprice = $(".dcprice-input").val();
	let numBox= $(".numBox").val();
	if(numBox == 1){
		$(".total").attr("placeholder",dcprice+"원");
	}
	$(".cart>button").click(function(){
		let dcprice = $(".dcprice-input").val();
		let numBox= $(".numBox").val();
		$(".total").attr("placeholder",(numBox*dcprice)+"원");
	})	
	
	
	
	// 카트담기 
	 $("#addCart_Btn").click(function(){
		   let gnum = $("#gnum").val();
		   let cartStock = $(".numBox").val();
		      
		   let data = {
		     goodsNumber : gnum,
		     cartStock : cartStock
		     };
		   
		   $.ajax({
		    url : "/kpop/shop/shopview/addCart",
		    type : "post",
		    data : data,
		    success : function(result){
		    if(result == 1){
		    	alert("카트 담기 성공");
		  		$(".numBox").val("1");
		  		console.log(cartStock);
		      }else{
		    	  alert("로그인후 이용하세요");
		    	  $(".numBox").val("1");
		      }
		  
		    },
		    error : function(){
		     alert("카트 담기 실패");
		    }
		   });
		  });
	
	

	
	
// 리뷰작성 활성화 
$("#review_Btn").click(function(){
	$(".Review-Form").slideToggle(500);
});

//ck에디터
let ckeditor_config = {
		 resize_enaleb : false,
		 enterMode : CKEDITOR.ENTER_BR,
		 shiftEnterMode : CKEDITOR.ENTER_P,
		 filebrowserUploadUrl : "/kpop/shop/shopview/ReviewUpload"
	};
		 CKEDITOR.replace("rwCon", ckeditor_config);

	
// 리뷰작성 ajax전송 
			$("#RewSubmit_Btn").click(function(){
				
				var formObj = $(".Review-Form form[role='form']");
				var goodsnumber = $("#goodsnumber").val();
				var rwCon =  CKEDITOR.instances.rwCon.getData();
				var rwTitle = $("#rwTitle").val();
				
				// ReplyVO 형태로 데이터 생성
				var data = {
						goodsNumber : goodsnumber,
						rwCon : rwCon,
						rwTitle : rwTitle
						};
				
				$.ajax({
					url : "/kpop/shop/shopview/reistReview",
					type : "post",
					data : data,
					success : function(){
						reviewList();  // 리스트 새로고침
						$("#rwTitle").val("");  // 텍스트에어리어를 초기화
						CKEDITOR.instances.rwCon.setData("");
					}
				});
			});
			
//리뷰 삭제
$(document).on("click", ".review-Delete", function(){
				

let deletConfirm = confirm("정말로 삭제하시겠습니까?"); 
				
if(deletConfirm) {
	var data = {rwNumber : $(this).attr("data-rwNumber")}; 
	$.ajax({
		url : "/kpop/shop/shopview/reviewDelete",	
		type : "post",
		data : data,
		success : function(result){
			// 작성자 아이디랑 세션 아이디가 일치할 때 
			if(result == 1) {
				reviewList();  // 리스트 새로고침
			} else {
				// 아이디가 일치 하지 않을 때 
				alert("작성자만 삭제 할 수 있습니다.")  									
			}
		},
		error : function(){
			// 로그인 하지 않아서 에러 발생
			alert("로그인후 이용해주세요.")
		}
	});
	}
});




});

	