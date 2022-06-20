/**
 * @author dimitar
 *
 */
package softuni.bg.heroes.data.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import softuni.bg.heroes.data.models.base.BaseEntity;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "items")
public class Item extends BaseEntity{
	
	@Column
	private String name;
	
	@Column
	@Enumerated(EnumType.STRING)
	private Slot slot;
	
	
	@Column
	private Integer stamina;
	
	@Column
	private Integer strength;
	
	@Column
	private Integer attack;
	
	@Column
	private Integer defence;

	@ManyToMany(mappedBy = "items")
	List<Hero> heroes; 
}
