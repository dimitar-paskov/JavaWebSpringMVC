/**
 * @author dimitar
 *
 */
package com.example.intro.web.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.intro.services.services.BeersService;
import com.example.intro.web.models.BeerViewModel;
import com.example.intro.web.models.CreateBeerViewModel;

@Controller
public class BeersController {
	
	private final BeersService beersService;
	private ModelMapper mapper; 

	@Autowired
	public BeersController(@Qualifier("beersService1") BeersService beersService, ModelMapper mapper) {
		this.beersService = beersService;
		this.mapper = mapper;
	}
	
//	public BeersController(ApplicationContext context) {    //service locator
//		this.beersService = context.getBean(BeersService.class);
//	}
	
	@GetMapping("/")
	public ModelAndView getAllBeers(ModelAndView modelAndView) {
//		modelAndView.addObject("text", "Hello Model and View");
		
		List<BeerViewModel> beers = beersService.getBeers()
				.stream()
				.map(beer -> mapper.map(beer, BeerViewModel.class))
				.collect(Collectors.toList());
		
		modelAndView.addObject("beers", beers);
		modelAndView.setViewName("index.html");
		return modelAndView;
	}
	
//	@GetMapping("/{beerName}") //there can be two or more path variables
	//public ModelAndView getBeerDetails(@PathVariable("beerName") String beerName,@PathVariable("secondBeer") String secondBeer, ModelAndView modelAndView) {
	//public ModelAndView getBeerDetails(ModelAndView modelAndView, @PathVariable("beerName") String beerName,@PathVariable("secondBeer") String secondBeer) {
	public ModelAndView getBeerDetails(@PathVariable("beerName") String beerName,ModelAndView modelAndView) {
		
		modelAndView.addObject("beer", beerName);
		modelAndView.setViewName("details.html");
		
		return modelAndView;
	}
	
//	@PostMapping("/")
//	public String createBeer(@RequestParam String name) {
//		
//		beersService.createBeer(name);
//		
//		return "redirect:/";
//		
//	}
	
	@PostMapping("/")
	public String createBeer(@ModelAttribute CreateBeerViewModel model) {
		
		beersService.createBeer(model.getName());
		
		return "redirect:/";
		
	}
	
	
}
