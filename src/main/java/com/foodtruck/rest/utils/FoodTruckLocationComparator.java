/**
 * 
 */
package com.foodtruck.rest.utils;

import java.util.Comparator;

import com.foodtruck.rest.model.FoodTruck;

/**
 * @author winters
 *
 */
public class FoodTruckLocationComparator implements Comparator<FoodTruck> {

	private final double latitude;
	private final double longitude;
	
	public FoodTruckLocationComparator(double latitude, double longitude){
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	@Override
	public int compare(FoodTruck o1, FoodTruck o2) {
		double dist1 = GeolocationUtil.distance(latitude, longitude, o1.getLatitude(), o1.getLongitude());
		double dist2 = GeolocationUtil.distance(latitude, longitude, o2.getLatitude(), o2.getLongitude());
		if(dist1 > dist2) return 1;
		else if(dist1 == dist2) return 0;
		else return -1;
	}

}
