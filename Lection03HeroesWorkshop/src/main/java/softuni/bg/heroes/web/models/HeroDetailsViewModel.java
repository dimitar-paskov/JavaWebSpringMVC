/**
 * @author dimitar
 *
 */
package softuni.bg.heroes.web.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import softuni.bg.heroes.data.models.Gender;

@Getter
@Setter 
@NoArgsConstructor
public class HeroDetailsViewModel {
	
	 private String name;
	    private Gender gender;
	    private int level;
	    private int stamina;
	    private int strength;
	    private int attack;
	    private int defence;

	    private HeroItemViewModel weapon;
	    private HeroItemViewModel pads;
	    private HeroItemViewModel gauntlets;
	    private HeroItemViewModel pauldrons;
	    private HeroItemViewModel helmet;

}
