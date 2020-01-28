package org.hdcd.homeController;


import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class homeController {
	private static Logger logger = LoggerFactory.getLogger(homeController.class);

	@RequestMapping(value = "/", method=RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("welcom {}", locale);
		

		model.addAttribute("serverTime", "음냠");
		System.out.println("여기까지는 오니");
		return "index";
	
	}
}
