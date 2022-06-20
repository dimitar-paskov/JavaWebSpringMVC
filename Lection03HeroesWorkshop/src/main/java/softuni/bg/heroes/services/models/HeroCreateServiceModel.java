/**
 * @author dimitar
 *
 */
package softuni.bg.heroes.services.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import softuni.bg.heroes.data.models.Gender;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HeroCreateServiceModel {
    private String name;
    private Gender gender;
}
