package com.example.intro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lection01SpringIntroApplication {

	public static void main(String[] args) {
		

		SpringApplication.run(Lection01SpringIntroApplication.class, args);
//		fake();
//		fake(new BeersServiceImpl());
//		fake2(() -> List.of("NovaBira", "Kamenitsa")); //Functional interface - lambda
		
		
//		ConfigurableApplicationContext ctx = SpringApplication.run(Lection01SpringIntroApplication.class, args);
//		ApplicationContext ctx = SpringApplication.run(Lection01SpringIntroApplication.class, args);
//		BeersService beersService = ctx.getBean(BeersService.class);  // Service locator 
//		beersService.getBeers().forEach(System.out::println);
		
		
	}
	
//	public static void fake() {
//		BeersService beersService = new BeersServiceImpl(); // coupling, not testable
//		beersService.getBeers().forEach(System.out::println);
//		
////		beersService = new BeersServiceImpl(); //testing Bean @Scope("prototype")
////		beersService.getBeers().forEach(System.out::println);
//	}	
	
//	public static void fake2(BeersService beersService) {
//		
//		beersService.getBeers().forEach(System.out::println);
//	}

}
