package springessentials.data.models;

import java.util.List;

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
import springessentials.data.models.base.BaseEntity;
import springessentials.data.models.enums.Gender;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "heroes")
public class Hero  extends BaseEntity {
	
	@Column
	private String name;
	
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
	
	@ManyToMany
	@JoinTable(name = "hero_items",
	joinColumns = {@JoinColumn(name = "hero_id")},
	inverseJoinColumns = {@JoinColumn(name = "item_id" )})
	private List<Item> items;
	
	
	@OneToOne()
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;
	
/*
 * private String name;
	private Gender gender;
	private Integer level;
	private Integer stamina;
	private Integer strength;
	private Integer attack;
	private Integer defence;
	private List<Item> items;*/
}


