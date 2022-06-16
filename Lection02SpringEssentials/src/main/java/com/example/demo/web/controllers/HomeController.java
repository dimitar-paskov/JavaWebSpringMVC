/**
 * @author dimitar
 *
 */
package com.example.demo.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
//	@RequestMapping(value = "/home", method= RequestMethod.GET)
//	public ModelAndView home() {
//		
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.setViewName("home");
//		
//		return modelAndView;
//	}
	
	@GetMapping(value = "/")
	public ModelAndView home() {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("home");
		
		return modelAndView;
	}
	
//	@RequestMapping(value = "/home", method= RequestMethod.GET)
//	public ModelAndView home(ModelAndView modelAndView) {
//		
//		modelAndView.setViewName("home");
//		
//		return modelAndView;
//	}
	
//	@RequestMapping(value = "/home", method= RequestMethod.GET)
//	public ModelAndView home(ModelAndView modelAndView, RedirectAttributes redirectAttributes) {
//		
//		redirectAttributes.addFlashAttribute("msg", "Password is not correct");
//		
//		modelAndView.setViewName("redirect:/home");
//		
//		return modelAndView; 
//	}
	
//	@RequestMapping(value = {"/home", "/index"}, method= RequestMethod.GET)
//	public ModelAndView exampleForTwoRoutes() {
//		
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.setViewName("home");
//		
//		return modelAndView;
//	}

}
