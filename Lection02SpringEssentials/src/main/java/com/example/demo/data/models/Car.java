/**
 * @author dimitar
 *
 */
package com.example.demo.data.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cars")
@Getter
@Setter
@NoArgsConstructor
public class Car {
	
	@Id
	@GeneratedValue(generator = "uuid-string")
	@GenericGenerator( name = "uuid-string", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id", nullable = false, unique = true, updatable = false)
	private String id;
	
	@Column(name = "model", nullable = false)
	private String model;
	
	@Column(name = "brand", nullable = false)
	private String brand;
	
	@Column(name = "engine", nullable = false)
	private String engine;
	
	@Column(name = "year", nullable = false)
	private Integer year;

}
