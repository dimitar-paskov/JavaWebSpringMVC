/**
 * @author dimitar
 *
 */
package softuni.bg.heroes.web.controllers;

import javax.servlet.http.HttpSession;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import softuni.bg.heroes.services.models.LoginUserServiceModel;
import softuni.bg.heroes.services.models.auth.RegisterUserServiceModel;
import softuni.bg.heroes.services.services.AuthService;
import softuni.bg.heroes.web.models.RegisterUserModel;

@Controller
@RequestMapping("/users")
public class AuthController {

	private AuthService authService;
	private ModelMapper mapper;

	public AuthController(AuthService authService, ModelMapper mapper) {
		this.authService = authService;
		this.mapper = mapper;
	}

	@GetMapping("/login")
	public String getLoginForm() {
		return "auth/login.html";
	}

	@GetMapping("/register")
	public String getRegisterForm() {
		return "auth/register.html";
	}

	@PostMapping("/register")
	public String register(@ModelAttribute RegisterUserModel model) {

		RegisterUserServiceModel serviceModel = mapper.map(model, RegisterUserServiceModel.class);

		authService.register(serviceModel);

		return "redirect:/";
	}

	@PostMapping("/login")
	public String login(@ModelAttribute RegisterUserModel model, HttpSession session) {

		RegisterUserServiceModel serviceModel = mapper.map(model, RegisterUserServiceModel.class);
		try {
			LoginUserServiceModel loginUserServiceModel = authService.login(serviceModel);
			session.setAttribute("user", loginUserServiceModel);
			return "redirect:/";
		} catch (Exception ex) {
			return "redirect:/users/login";
		}

	}

}
