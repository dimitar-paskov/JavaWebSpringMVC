package springessentials.services.services;

import springessentials.services.models.auth.LoginUserServiceModel;
import springessentials.services.models.auth.RegisterUserServiceModel;

public interface AuthService {
	
	void register(RegisterUserServiceModel model);

	LoginUserServiceModel login(RegisterUserServiceModel serviceModel) throws Exception; 
	

}
