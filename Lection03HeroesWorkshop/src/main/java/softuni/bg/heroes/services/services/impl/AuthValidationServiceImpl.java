/**
 * @author dimitar
 *
 */
package softuni.bg.heroes.services.services.impl;

import org.springframework.stereotype.Service;

import softuni.bg.heroes.data.repositories.UserRepository;
import softuni.bg.heroes.services.models.auth.RegisterUserServiceModel;
import softuni.bg.heroes.services.services.AuthValidationService;

@Service
public class AuthValidationServiceImpl implements AuthValidationService {
	
	private final  UserRepository userRepository;
	
	public AuthValidationServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public boolean isValid(RegisterUserServiceModel user) {

		return this.isEmailValid(user.getEmail())
				&& this.arePasswordsValid(user.getPassword(), user.getConfirmPassword())
				&& this.isUsernameTaken(user.getUsername());
	}

	private boolean arePasswordsValid(String password, String confirmPassword) {

		return password.equals(confirmPassword); 
	}

	private boolean isUsernameTaken(String username) {

		return !userRepository.existsByUsername(username); 
	}

	private boolean isEmailValid(String email) {
		return true;
	}

}
