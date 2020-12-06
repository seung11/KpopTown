/**
 * 
 */
let idcheck = false;
let pwcheck = false;
let repwcheck = false;

$(document).ready(function(){

	/*======================================
	 * 			회원가입
	 * ====================================*/
	
//아이디 중복검사
$('.id_input').on("propertychange change keyup paste input", function(){
	let userid = $('.id_input').val();
	let data = {userid : userid}				
	let idreg = /^(?=.*?[a-z])(?=.*?[0-9])(?=.*?[`~!@#$%^&*()-_=+\]]).{8,}$/;   //id 유효성 검사를 위한 정규식 
	let idvalue =  	$("#userid").val();
		
		$(".id-info").css("height","80px"); // idmsg에 문구 입력되면 heignt 조절
	
	$.ajax({
		type : "post",
		url : "/kpop/member/IdChek",
		data : data,
		success : function(result){
			if(result == 'fail'){ 	
				
				//중복된 아이디 일때 
						$("#idmsg").html("이미 사용중인 아이디 입니다"); //유효성검사 text 나오지 않게 
						$("#idmsg").css("color","#ff7675");
				 } else {
							// 중복된 아이디 아닐때 + 유효성 검사 통과
							if (idreg.test(idvalue)){
							$("#idmsg").html("사용가능한 아이디 입니다");
							$("#idmsg").css("color","#355989");
							idcheck = true;
							}else {
								
								// 유효성 검사 통과 x 
								$("#idmsg").html("8자이상+숫자가 포함 되어야 합니다");
								$("#idmsg").css("color","#ff7675");
						 
								idcheck = false;
							}
				 		}
				}// success 종료
		}); // ajax 종료	
			
	}); // 아이디 유효성검사 종료

	 
//비밀번호 유효성 검사 
$("#userPass").on("keyup blur",function(){
	  // 비밀번호 유효성 검사 (영문+숫자 포함하여 총 길이는 8자 이상
	  let pwreg = /^(?=.*?[a-z])(?=.*?[0-9])(?=.*?[`~!@#$%^&*()-_=+\]]).{8,}$/;
	  let pwvalue = $("#userPass").val();
			$(".pw-info").css("height","80px") // pwmsg에 문구 입력되면 heignt 조절
			console.log(pwvalue);
			if(pwreg.test(pwvalue)){
				// 사용가능 
				$("#pwmsg").html("사용할 수 있는 비밀번호 입니다");
				$("#pwmsg").css("color","#355989");
				
				pwcheck = true;
			}else{
				// 사용불가능
				$("#pwmsg").html("영문+숫자가 모두 포함 되어야 합니다");
				$("#pwmsg").css("color","#ff7675");
				pwcheck = false;
			}// if문 종료
			
	  }); // 비밀번호 유효성 검사 종료
	    
	    
// 비밀번호 재확인 
$("#re-userPass").on("keyup blur",function(){
	    
		let repwvalue = $("#re-userPass").val();
	    let pwvalue = $("#userPass").val();
	    
	    $(".repw-info").css("height","80px")
	    	
	    	if(pwvalue==repwvalue){
	    		// 일치
	    		$("#re_pwmsg").html("비밀번호가 일치합니다");
	    		$("#re_pwmsg").css("color","#355989")
	    		 repwcheck = true;
	    	}else {
	    		// 불일치
	    		$("#re_pwmsg").html("비밀번호 일치하지 않습니다");
	    		$("#re_pwmsg").css("color","#ff7675")
	    		repwcheck = false;
	    	} // if문 종료
	    
	  }); // 비밀번호 재확인 종료
	    

$("#userName").on("keyup blur",function(){
    let userName = $("#userName").val();
    let nameCheck = /[가-힣]/;
    
    
    	
    	if(!nameCheck.test(userName)){
    		console.log(userName);
    		// 일치
    		$(".name-Info").css("height","80px")
    		$("#name_msg").html("한글만 사용 가능합니다");
    		$("#name_msg").css("color","#ff7675")
    		repwcheck = true;
    	}else{
    		$("#name_msg").html("");
    		$(".name-Info").css("height","59px")
    	}
    	// if문 종료
    
  }); 

// 핸드폰 문자 입력 불가능 
let regExp = /[^0-9]/gi;
$("#userPhone").keyup (function(){
	numCheck($(this)); 
});
function numCheck(selector){
	let tempVal = selector.val();
	selector.val(tempVal.replace(regExp,""));
}

/*====================================
 *      페이지 이동 관련
 * ==================================*/	    


	//클릭시 회원가입 이동 
	$("#signup-location").click(function(){
	   $(location).attr('href','/kpop/member/signup')
	});
	    
	//클릭시 아이디찾기 이동 
	$("#findid-location").click(function(){
		$(location).attr('href','/kpop/member/findid')
	});
	
	//클릭시 비밀번호찾기 이동 
	$("#findpw-location").click(function(){
		$(location).attr('href','/kpop/member/findpw')
	})
	//클릭시 로그인 이동
	$("#singnin-location").click(function(){
		$(location).attr('href','/kpop/member/signin')
	});

	

/*=======================================
 * 		 아이디/비밀번호 찾기
 * ====================================*/	

	//클릭시 이메일로 찾기 활성화 
	$("#findid_BtnEmail").click(function(){
		$("#phon").hide();
	    $("#email").show();
	    $("#findid_BtnPhone").prop("checked",false);
	 });
	
	//클릭시 전화번호로 찾기 활성화 
	$("#findid_BtnPhone").click(function(){
	    $("#phon").show();
	    $("#email").hide();
	    $("#findid_BtnEmail").prop("checked",false);
	 });
	  
	
	
	 //이메일로 아이디 찾기 
	 $("#findid_Btn").click(function(){
		 
		 let userName = $("#userName").val();
		 let userEmail = $("#userEmail").val();
	   
	    let data = {
	    		userName:userName,
	    		userEmail:userEmail
	    	}
	    console.log(JSON.stringify(data));
	    	   	
	    	$.ajax({
	    		url:"/kpop/member/findid",
	    		type:"post",
	    		data:data,
	    		success:function(result){
	    			
	    			//  정보가 없을때 
	    			if(result == 0 ){
	    				required : true
	    				alert("일치하는 정보가 없습니다");
	    				// 새로고침 
	    				location.reload();
	    			}else{
	    				// 정보가 있을때 
	    				required : true
	    				$(".modal-wrap").fadeIn(600); // 모달 활성화 
	    				$("#findid").html(result);
	    				
	    				$("#modal-cancel").click(function(){ // 모달 클릭시 종료
	    					$(".modal-wrap").fadeOut(600);
	    					location.reload();
	    				}); // 모달 종료
	    			
	    			} //if문 종료
	    			
	    		}//function 종료
	    	
	    	})// ajax종료
	    	return false;
	 })// 아이디 찾기 종료
	  
	 //휴대폰번호로 아이디 찾기 
	 $("#findid_Btn2").click(function(){
		 
		 let userName2 = $("#userName2").val();
		 let userPhone = $("#userPhone").val();
	   
	    let data = {
	    		userName:userName2,
	    		userPhone:userPhone
	    	}
	    console.log(JSON.stringify(data));
	    	   	
	    	$.ajax({
	    		url:"/kpop/member/findid",
	    		type:"post",
	    		data:data,
	    		success:function(result){
	    			
	    			//  정보가 없을때 
	    			if(result == 0 ){
	    				required : true
	    				alert("일치하는 정보가 없습니다");
	    				// 새로고침 
	    				location.reload();
	    			}else{
	    				// 정보가 있을때 
	    				required : true
	    				$(".modal-wrap").fadeIn(600); // 모달 활성화 
	    				$("#findid").html(result);
	    				
	    				$("#modal-cancel").click(function(){ // 모달 클릭시 종료
	    					$(".modal-wrap").fadeOut(600);
	    					location.reload();
	    				}); // 모달 종료
	    			
	    			} //if문 종료
	    			
	    		}//function 종료
	    	
	    	})// ajax종료
	    	return false;
	 })// 아이디 찾기 종료

});
