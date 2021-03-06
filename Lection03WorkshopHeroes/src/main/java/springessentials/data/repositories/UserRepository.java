package springessentials.data.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springessentials.data.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	boolean existsByUsername(String username);
	
	Optional<User> findByUsernameAndPassword(String username, String password);

}
