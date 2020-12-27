package springessentials.data.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cars")
@Getter
@Setter
public class Car {

	@Id
	@GeneratedValue(generator = "uuid-generator")
	@GenericGenerator(name = "uuid-generator",strategy = "org.hibernate.id.UUIDGenerator" )
	private String id;
	
	@Column(nullable = false)
	private String model;
	
	@Column(nullable = false)
	private String brand;
	
	@Column(nullable = false)
	private String engine;
	
	@Column(nullable = false)
	private Integer year;
	
}
