/**
 * @author dimitar
 *
 */
package softuni.bg.heroes.services.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LoginUserServiceModel {
	
	public LoginUserServiceModel(String username, String heroName){
		this.username = username;
		this.heroName = heroName;
	}
	
	private String username;
	private String heroName;

}
