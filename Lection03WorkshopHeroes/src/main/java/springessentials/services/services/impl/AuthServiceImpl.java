package springessentials.services.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import springessentials.data.models.User;
import springessentials.data.repositories.UserRepository;
import springessentials.services.models.auth.LoginUserServiceModel;
import springessentials.services.models.auth.RegisterUserServiceModel;
import springessentials.services.services.AuthService;
import springessentials.services.services.AuthValidationService;
import springessentials.services.services.HashingService;

@Service
public class AuthServiceImpl implements AuthService {
	
	private final AuthValidationService authValidationService;
	private final UserRepository userRepository;
	private final ModelMapper modelMapper;
	private final HashingService hashingService;
	
	public AuthServiceImpl(AuthValidationService authValidationService, 
			UserRepository userRepository,
			ModelMapper modelMapper,
			HashingService hashingService) {
		this.hashingService = hashingService;
		this.modelMapper = modelMapper;
		this.userRepository = userRepository;
		this.authValidationService = authValidationService;
	}

	@Override
	public void register(RegisterUserServiceModel model) {
		
		if(!authValidationService.isValid(model)){
			//do sth
			return;
		}
		
		User user = modelMapper.map(model, User.class);
		user.setPassword(hashingService.hash(user.getPassword()));  
		
		userRepository.save(user);
		
	}

	@Override
	public LoginUserServiceModel login(RegisterUserServiceModel serviceModel) throws Exception { 
		
		String passwordHash = hashingService.hash(serviceModel.getPassword());
		
		User user = userRepository.findByUsernameAndPassword(serviceModel.getUsername(), passwordHash).orElseThrow();
		
		String heroName = user.getHero()==null? null : user.getHero().getName();

		return new LoginUserServiceModel(serviceModel.getUsername(), heroName);

		
	}

}
