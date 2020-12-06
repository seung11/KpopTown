/**
 * 
 */

$(document).ready(function(){
	
	// 장바구니 합계 게산 
	$(".Check").click(function(){
		let sum = 0;
		let allsum = 0;
		let count = $(".Check").length;
		
		$(this).is(":checked");
		for(let i=0; i<count; i++){
			if($(".Check")[i].checked == true){
			sum += parseInt($(".Check")[i].value);
			console.log($(".Check")[i].value);
			}
			
			$(".select_sum").html(sum + "원");
		}
	});	
	
	
	// 전체선택 + 전체선택시 총 합계
	$("#allCheck").click(function(){
		
		let all = $("#allCheck").prop("checked");
		let sum = 0;
		let count = $(".Check").length;
		if(all){
			$(".Check").prop("checked",true);
		for	(let  i=0; i<count; i++){
			sum += parseInt($(".Check")[i].value);
			$(".select_sum").html(sum + "원");
		}
		}else{
			$(".Check").prop("checked",false);
			$(".select_sum").html("");
		}
	
	});

	// 개별선택시 전체선택 체크박스 해제
	$(".Check").click(function(){
		$("#allCheck").prop("checked",false);

	});
	
	
	
	// 삭제여부 확인, 컨트롤러 전송 
	$(".select_delete").click(function(){
		let confirm_val = confirm("삭제 하시겠습니까?");
		
		if(confirm_val){
			let checkArr = new Array();
			
			$("input[class='Check']:checked").each(function(){
				checkArr.push($(this).attr("data-cartnum"));
			});
			
			$.ajax({
				url:"/kpop/shop/deleteCart",
				type: "post",
				data : {Check:checkArr},
				success : function(result){
					
					if(result == 1){
						
						location.href="/kpop/shop/cartList";
					}else{
						alert("삭제실패");
					}
				}
			});
		}
	});

	
	//개별삭제 
	$(".delete_Btn").click(function(){
		let confirm_val = confirm("삭제 하시겠습니까?");
		
		if(confirm_val){
			let checkArr = new Array();
			checkArr.push($(this).attr("data-cartnum"));
			
			$.ajax({
				url:"/kpop/shop/deleteCart",
				type:"post",
				data : {Check:checkArr},
				success:function(result){
					if(result==1){
					  location.href="/kpop/shop/cartList";
					}else{
					  alert("삭제실패");
					}
				}
			
			});
		}
	});	
	
	//  주문정보 입력 
	$(".orderGo_Btn").click(function(){

		$(".order-container").fadeIn(600);
	})
	
	$(".cancel_Btn").click(function(){
		$(".order-container").fadeOut(600);
	})
});

	