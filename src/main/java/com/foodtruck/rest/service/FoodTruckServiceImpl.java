/**
 * 
 */
package com.foodtruck.rest.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.foodtruck.rest.dao.FoodTruckDao;
import com.foodtruck.rest.model.FoodTruck;

/**
 * @author winters
 *
 */
public class FoodTruckServiceImpl implements FoodTruckService {

	@Autowired
	private FoodTruckDao foodTruckDao;
	
	@Override
	public void create(FoodTruck foodTruck) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public FoodTruck get(Long foodtruckId) {
		return foodTruckDao.getFoodTruckById(foodtruckId);
	}

	@Override
	public void update(FoodTruck foodTruck) {
		// TODO Auto-generated method stub
		
	}
	
	
//	@Autowired
//	private AccountDao accountDao;
//	
//	@Override
//	public void create(Account account) {
//		accountDao.create(account);
//	}
//	
//	@Override
//	public Account get(Long id) {
////		Account account = new Account();
////		account.setId(id);
////		account.setEmail("ABC");
////		
////		return account;
//		return accountDao.get(id);
//	}
//
//	@Override
//	public void udpate(Account account) {
//		accountDao.update(account);
//	}
//
//	@Override
//	public void delete(Account account) {
//		accountDao.delete(account);
//	}

}
