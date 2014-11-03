package com.foodtruck.rest.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * A generic Entity class
 * @author winters
 *
 * @param <PrimaryKey>
 */
@MappedSuperclass
public abstract class BaseEntity<PrimaryKey> {

	/**
	 * Entity primary key
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", columnDefinition = "serial", unique = true)
	protected PrimaryKey id;

	public PrimaryKey getId() {
		return id;
	}

	public void setId(PrimaryKey id) {
		this.id = id;
	}
	
}
