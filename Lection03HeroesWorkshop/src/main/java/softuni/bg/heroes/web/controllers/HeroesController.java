/**
 * @author dimitar
 *
 */
package softuni.bg.heroes.web.controllers;

import javax.servlet.http.HttpSession;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import softuni.bg.heroes.errors.HeroNotFoundException;
import softuni.bg.heroes.services.models.HeroCreateServiceModel;
import softuni.bg.heroes.services.models.HeroDetailsServiceModel;
import softuni.bg.heroes.services.models.LoginUserServiceModel;
import softuni.bg.heroes.services.services.HeroesService;
import softuni.bg.heroes.services.services.UserService;
import softuni.bg.heroes.web.controllers.base.BaseController;
import softuni.bg.heroes.web.models.HeroCreateModel;
import softuni.bg.heroes.web.models.HeroDetailsViewModel;

@Controller
@RequestMapping("/heroes")
public class HeroesController extends BaseController {

	private HeroesService heroService;
	private ModelMapper mapper;
	private UserService userservice;

	public HeroesController(HeroesService heroService, ModelMapper mapper, UserService userservice) {
		this.heroService = heroService;
		this.mapper = mapper;
		this.userservice = userservice;
	}

	@GetMapping("/details/{name}")
	public ModelAndView getHeroDetails(@PathVariable String name, ModelAndView modelAndView) {

		HeroDetailsServiceModel serviceModel = heroService.getByName(name);
		HeroDetailsViewModel viewModel = mapper.map(serviceModel, HeroDetailsViewModel.class);
		modelAndView.addObject("hero", viewModel);
		modelAndView.setViewName("heroes/hero-details.html");

		return modelAndView;
	}

	@GetMapping("/create")
	public String getCreateHeroForm(HttpSession session) {
		if (!isAuthenticated(session)) {
			return "redirect:/users/login";
		}

		return "heroes/create-hero.html";
	}

	@PostMapping("/create")
	public String createHero(@ModelAttribute HeroCreateModel hero, HttpSession session) {

		if (!isAuthenticated(session)) {
			return "redirect:/";
		}

		String username = getUsername(session);
		HeroCreateServiceModel serviceModel = mapper.map(hero, HeroCreateServiceModel.class);
		try {
			userservice.createHeroForUser(username, serviceModel);
			LoginUserServiceModel loginUserServiceModel = new LoginUserServiceModel(username, hero.getName());
			session.setAttribute("user", loginUserServiceModel);
			return "redirect:/heroes/details";

		} catch (Exception e) {
			return "redirect:/heroes/create";
		}

	}

	@ExceptionHandler(HeroNotFoundException.class)
	public ModelAndView handleException(HeroNotFoundException exception) {
		ModelAndView modelAndView = new ModelAndView("custom-error");
		modelAndView.addObject("message", exception.getMessage());
		modelAndView.setStatus(HttpStatus.NOT_FOUND);

		return modelAndView;
	}

}
