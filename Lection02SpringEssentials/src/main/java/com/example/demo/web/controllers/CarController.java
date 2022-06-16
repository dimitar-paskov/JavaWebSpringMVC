/**
 * @author dimitar
 *
 */
package com.example.demo.web.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.modles.CarServiceModel;
import com.example.demo.service.services.CarService;

@Controller
@RequestMapping("/cars")
public class CarController {
	
	private final CarService carService;
	
//	@Autowired
	public CarController(CarService carService) {
		this.carService = carService;
	}
	
	@GetMapping("/create")
	public ModelAndView create() {
		
		return new ModelAndView("create");
		
	}
	
	@PostMapping("/create")
	public ModelAndView createConfirm(@ModelAttribute CarServiceModel model ) {
		
		this.carService.save(model);
		
		
		return new ModelAndView("redirect:/cars/all");
		
	}
	
	@GetMapping("/all")
	public ModelAndView all(ModelAndView modelAndView) {
		
		List<CarServiceModel> cars = this.carService.getCars();
		
		modelAndView.addObject("cars", cars);
		modelAndView.setViewName("all"); 
		return modelAndView;
		
	}

}
