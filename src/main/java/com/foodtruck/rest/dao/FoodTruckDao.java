/**
 * 
 */
package com.foodtruck.rest.dao;

import com.foodtruck.rest.model.FoodTruck;

/**
 * @author winters
 *
 */
public interface FoodTruckDao extends GenericDao<FoodTruck, Long> {

	FoodTruck getFoodTruckById(Long id);
	
}
