/**
 * @author dimitar
 *
 */
package softuni.bg.heroes.services.services.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import softuni.bg.heroes.data.models.User;
import softuni.bg.heroes.data.repositories.UserRepository;
import softuni.bg.heroes.services.models.LoginUserServiceModel;
import softuni.bg.heroes.services.models.auth.RegisterUserServiceModel;
import softuni.bg.heroes.services.services.AuthService;
import softuni.bg.heroes.services.services.AuthValidationService;
import softuni.bg.heroes.services.services.HashingService;

@Service
public class AuthServiceImpl implements AuthService {
	
	private UserRepository userRepository;
	private AuthValidationService authValidationService;
	private ModelMapper mapper;
	private HashingService hashingService;
	
	public AuthServiceImpl(AuthValidationService authValidationService,
			UserRepository userRepository, ModelMapper mapper, HashingService hashingService) {
		this.userRepository = userRepository;
		this.authValidationService = authValidationService;
		this.mapper = mapper;
		this.hashingService = hashingService;
	}
	

	@Override
	public void register(RegisterUserServiceModel model) {
		
		//validate password, password match, existing user
		//create or throw
		
		if(!authValidationService.isValid(model)) {
			// do something
			return;
		}
		
		User user = mapper.map(model, User.class);
		user.setPassword(hashingService.hash(user.getPassword())); 
		userRepository.save(user);
		
	}


	@Override
	public LoginUserServiceModel login(RegisterUserServiceModel serviceModel) throws Exception {
		
		String passwordHash = hashingService.hash(serviceModel.getPassword());
		
		Optional<User> userOptional = userRepository.findByUsernameAndPassword(serviceModel.getUsername(), passwordHash);
		
		if(userOptional.isEmpty()) {
			 throw new Exception("InvalidUser");
		}
		
		User user = userOptional.get();
		
		String heroName = user.getHero() == null ? null :user.getHero().getName();
		
		return new LoginUserServiceModel(serviceModel.getUsername(), heroName);
		
	}

}
