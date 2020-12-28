package springessentials.web.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	private String getIndex(HttpSession session) {
		
		if(session.getAttribute("username")==null) {
			
		}
		
		return "home/index.html";
	}
	
	@GetMapping("/home")
	private String getHome() {
		
		return "home/home.html";
	}

}
