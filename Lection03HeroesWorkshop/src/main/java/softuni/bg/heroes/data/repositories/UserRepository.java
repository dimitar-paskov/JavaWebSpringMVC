/**
 * @author dimitar
 *
 */
package softuni.bg.heroes.data.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import softuni.bg.heroes.data.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	boolean existsByUsername(String username);
	Optional<User> findByUsernameAndPassword(String username, String password);
	User findByUsername(String username);
	
}
