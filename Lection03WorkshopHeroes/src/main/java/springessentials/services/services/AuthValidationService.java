package springessentials.services.services;

import springessentials.services.models.auth.RegisterUserServiceModel;

public interface AuthValidationService {
	
	Boolean isValid(RegisterUserServiceModel model);

}
