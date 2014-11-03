/**
 * 
 */
package com.foodtruck.rest.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.foodtruck.rest.model.FoodTruck;

/**
 * @author winters
 *
 */
@Transactional
@Repository("foodTruckDao")
public class FoodTruckDaoImpl extends GenericDaoImpl<FoodTruck, Long>
		implements FoodTruckDao {
	
	public FoodTruckDaoImpl(){
		super(FoodTruck.class);
	}

	
	/**
     * {@inheritDoc}
     */
	@Override
	public FoodTruck getFoodTruckById(Long id) {
		FoodTruck result = (FoodTruck) getSessionFactory().getCurrentSession().get(FoodTruck.class, id);
		return result;
	}

}
