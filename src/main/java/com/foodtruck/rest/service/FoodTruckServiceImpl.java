/**
 * 
 */
package com.foodtruck.rest.service;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

import org.springframework.beans.factory.annotation.Autowired;

import com.foodtruck.rest.dao.FoodTruckDao;
import com.foodtruck.rest.model.FoodTruck;
import com.foodtruck.rest.utils.FoodTruckLocationComparator;
import com.foodtruck.rest.utils.GeolocationUtil;
import com.google.common.collect.MinMaxPriorityQueue;

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
		
	}

	@Override
	public List<FoodTruck> get() {
		return foodTruckDao.getAll();
	}
	
	@Override
	public List<FoodTruck> getRandom() {
		List<FoodTruck> all = foodTruckDao.getAll();
		Collections.shuffle(all);
		return all.subList(0, 20);
	}

	@Override
	public List<FoodTruck> indistance(double latitude, double longitude,
			double distance) {
		List<FoodTruck> all = foodTruckDao.getAll();
		Iterator<FoodTruck> it = all.iterator();
		while(it.hasNext()){
			FoodTruck ft = it.next();
			if(ft.getLatitude() == null || ft.getLongitude() == null) it.remove();
			else if(GeolocationUtil.distance(latitude, longitude, ft.getLatitude(), ft.getLongitude()) > distance){
				it.remove();
			}
		}
		return all;
	}

	@Override
	public Queue<FoodTruck> cloest(double latitude, double longitude, int count) {
		
		List<FoodTruck> all = foodTruckDao.getAll();
		Queue<FoodTruck> minQueue = MinMaxPriorityQueue
				.orderedBy(new FoodTruckLocationComparator(latitude, longitude))
				.maximumSize(count)
				.create();
		for(FoodTruck ft: all){
			if(ft != null) minQueue.offer(ft);
		}
		return minQueue;
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
