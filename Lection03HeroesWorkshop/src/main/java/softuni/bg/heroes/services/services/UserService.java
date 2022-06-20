/**
 * @author dimitar
 *
 */
package softuni.bg.heroes.services.services;

import softuni.bg.heroes.services.models.HeroCreateServiceModel;

public interface UserService {

	void createHeroForUser(String username, HeroCreateServiceModel serviceModel); 

}
