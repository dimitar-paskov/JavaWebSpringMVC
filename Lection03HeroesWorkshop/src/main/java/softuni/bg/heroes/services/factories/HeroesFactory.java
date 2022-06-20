/**
 * @author dimitar
 *
 */
package softuni.bg.heroes.services.factories;

import softuni.bg.heroes.data.models.Gender;
import softuni.bg.heroes.data.models.Hero;

public interface HeroesFactory {

	Hero create(String name, Gender gender);
}
