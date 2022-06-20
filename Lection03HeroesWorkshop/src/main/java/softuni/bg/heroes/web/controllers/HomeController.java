/**
 * @author dimitar
 *
 */
package softuni.bg.heroes.web.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String getIndex(HttpSession session) {

		return "home/index.html";
	}
	
	@GetMapping("/home")
	public String getHome() {
		return "home/home.html";
	}

}
