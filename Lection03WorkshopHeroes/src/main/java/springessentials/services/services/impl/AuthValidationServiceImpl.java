package springessentials.services.services.impl;

import org.springframework.stereotype.Service;

import springessentials.data.repositories.UserRepository;
import springessentials.services.models.auth.RegisterUserServiceModel;
import springessentials.services.services.AuthValidationService;

@Service
public class AuthValidationServiceImpl implements AuthValidationService{
	
	private final UserRepository userRepository; 

	public AuthValidationServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public Boolean isValid(RegisterUserServiceModel user) {

		return 
				this.isUsernameFree(user.getUsername()) &&
				this.arePasswordsValid(user.getPassword(), user.getConfirmPassword()) &&
				this.isEmailValid(user.getEmail());
	}

	private boolean arePasswordsValid(String password, String confirmPassword) {
		
		return password.equals(confirmPassword);  
	}

	private boolean isUsernameFree(String username) {
		return !userRepository.existsByUsername(username); 
	}

	private Boolean isEmailValid(String email) {
		return true; 
	}

}
