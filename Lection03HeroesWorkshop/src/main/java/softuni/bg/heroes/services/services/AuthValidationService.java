/**
 * @author dimitar
 *
 */
package softuni.bg.heroes.services.services;

import softuni.bg.heroes.services.models.auth.RegisterUserServiceModel;

public interface AuthValidationService {
	
	boolean isValid(RegisterUserServiceModel user);

}
