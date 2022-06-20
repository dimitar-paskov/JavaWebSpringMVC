/**
 * @author dimitar
 *
 */
package softuni.bg.heroes.data.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name="heroes")
public class Hero extends BaseEntity{
	
	
	@Column(unique = true)
	private String name;
	
	@Column
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@Column
	private Integer level;
	
	@Column
	private Integer stamina;
	
	@Column
	private Integer strength;
	
	@Column
	private Integer attack;
	
	@Column
	private Integer defence;

	@OneToOne()
	@JoinColumn(name="user_id", referencedColumnName = "id")
	private User user;
	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name = "hero_items",
			joinColumns = { @JoinColumn(name = "hero_id")}, 
			inverseJoinColumns = { @JoinColumn(name="item_id")})
	private List<Item> items;

}
