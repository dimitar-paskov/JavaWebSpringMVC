/**
 * @author dimitar
 *
 */
package softuni.bg.heroes.services.services;

import softuni.bg.heroes.data.models.Hero;
import softuni.bg.heroes.services.models.HeroCreateServiceModel;
import softuni.bg.heroes.services.models.HeroDetailsServiceModel;

public interface HeroesService {

	HeroDetailsServiceModel getByName(String name);

	Hero create(HeroCreateServiceModel heroServiceModel);  

}
