package com.album.kpop;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.album.service.MainService;
import com.album.service.ShopService;
import com.album.vo.EventVO;
import com.album.vo.productVO;


/**
 * Handles requests for the application home page.
 */
@Controller
//@SessionAttributes("login")
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private ShopService shopservice;
	@Autowired
	private MainService mainservice;
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws Exception 
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model , productVO pvo) throws Exception {
		logger.info("Welcome home! The client locale is {}.");

		List<EventVO> event = shopservice.eventList();
		List<productVO> newRelease = mainservice.newRelease();
		List<productVO> mainProduct = mainservice.mainProduct();
		
		
		
		System.out.println(event);
		System.out.println(newRelease);
		
		
		model.addAttribute("event", event);
		model.addAttribute("newRelease", newRelease);
		model.addAttribute("mainProduct", mainProduct);
		

		return "home";
	}
  // Hoem ¸Þ¼Òµå end 

	
}

