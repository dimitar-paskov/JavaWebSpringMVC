/**
 * @author dimitar
 *
 */
package softuni.bg.heroes.services.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import softuni.bg.heroes.data.models.Hero;
import softuni.bg.heroes.data.models.User;
import softuni.bg.heroes.data.repositories.HeroesRepository;
import softuni.bg.heroes.data.repositories.UserRepository;
import softuni.bg.heroes.services.models.HeroCreateServiceModel;
import softuni.bg.heroes.services.services.HeroesService;
import softuni.bg.heroes.services.services.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	private HeroesService heroesService;
	private UserRepository userRepository;
	private HeroesRepository heroesRepository;
	private ModelMapper mapper;
	
	public UserServiceImpl(HeroesService heroesService, UserRepository userRepository, HeroesRepository heroesRepository, ModelMapper mapper) {
		this.heroesService = heroesService;
		this.userRepository = userRepository;
		this.heroesRepository = heroesRepository;  
		this.mapper = mapper;
	}

	@Override
	public void createHeroForUser(String username, HeroCreateServiceModel heroServiceModel) {
		User user = userRepository.findByUsername(username); 
		Hero hero = heroesService.create(heroServiceModel);
		hero.setUser(user);  
		
		heroesRepository.saveAndFlush(hero);
	}

	
}
