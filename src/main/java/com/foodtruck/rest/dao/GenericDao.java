/**
 * 
 */
package com.foodtruck.rest.dao;

import java.io.Serializable;
import java.util.List;

/**
 * A Generic Data Access Object Interface 
 * @author winters
 *
 */
public interface GenericDao<Entity, PrimaryKey extends Serializable> {

	/**
	 * get all entities
	 * @return
	 */
	List<Entity> getAll();
	
	/**
	 * get entity by id
	 * @param id
	 * @return
	 */
	Entity get(PrimaryKey id);
	
	/**
	 * save the entity
	 * @param theEntity
	 * @return
	 */
	Serializable save(Entity theEntity);
	
	/**
	 * save or update the entity
	 * @param theEntity
	 * @return
	 */
	void saveOrUpdate(Entity theEntity);
	
	/**
	 * update the entity
	 * @param theEntity
	 * @return TODO
	 * @return
	 */
	Entity update(Entity theEntity);
	
	/**
	 * delete the entity
	 * @param theEntity
	 * @return
	 */
	void delete(PrimaryKey id);
	
}
