window.onload = function(){

	
// 반응형 토글 메뉴 
  let toggler = document.querySelector('.toggle');
  let nav = document.querySelector('.nav');
  
 toggler.addEventListener('click',(e) => {
    e.target.classList.toggle('fa-bars')
    e.target.classList.toggle('fa-times')
    // e.target.style.color == "white"; 
    // if( e.target.style.color == "white"){
    //   e.target.style.color = "black"; 
    // }
    
    nav.classList.toggle('menu-close')
     
 });

// 슬라이드
 
 $('.one-time').slick({
	    dots: false,
	    arrows:false,
	    infinite: true,
	    speed: 300,
	    slidesToShow: 1,
	    // prevArrow: $('#banner_prev'),
	    // nextArrow: $('#banner_next'),
	    adaptiveHeight: true,
	    autoplay: true,

	      });


	      $('.multiple-items').slick({
	        infinite: true,
	        arrows : true, 
	        prevArrow: $('#aro1_prev'),
			    nextArrow: $('#aro1_next'),
	        slidesToShow: 3,
	        slidesToScroll: 3
	      });     


	      $('.new-Slide').slick({
	        infinite: true,
	        arrows : true, 
	        prevArrow: $('#new_prev'),
			    nextArrow: $('#new_next'),
	        slidesToShow: 4,
	        slidesToScroll: 4
	      });  



}
