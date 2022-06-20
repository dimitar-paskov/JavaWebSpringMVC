/**
 * @author dimitar
 *
 */
package softuni.bg.heroes.data.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import softuni.bg.heroes.data.models.base.BaseEntity;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="users")
public class User extends BaseEntity {
	
	@Column
	private String username;
	
	@Column
	private String password;
	
	@Column
	private String email;
	
	@OneToOne(mappedBy = "user")
	private Hero hero;
	

}
