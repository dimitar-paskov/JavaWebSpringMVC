/**
 * @author dimitar
 *
 */
package softuni.bg.heroes.data.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import softuni.bg.heroes.data.models.Hero;

public interface HeroesRepository extends JpaRepository<Hero, Long> {

	Optional<Hero> getByNameIgnoreCase(String name); 

	
	
}
