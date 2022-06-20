/**
 * @author dimitar
 *
 */
package softuni.bg.heroes.services.services;

import softuni.bg.heroes.services.models.LoginUserServiceModel;
import softuni.bg.heroes.services.models.auth.RegisterUserServiceModel;

public interface AuthService {
	
	void register(RegisterUserServiceModel model);

	LoginUserServiceModel login(RegisterUserServiceModel serviceModel) throws Exception; 

}
