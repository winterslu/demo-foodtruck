package com.foodtruck.rest.utils;

/**
 * @author winters
 * 
 */
public class GeolocationUtil {

	/**
	 * This routine calculates the distance between two points
	 * (given the latitude/longitude of those points).
	 * 
	 * @param lat1
	 * @param lon1
	 * @param lat2
	 * @param lon2
	 * @return distance between two coordinates in mile
	 */
	public static double distance(Double lat1, Double lon1,
			Double lat2, Double lon2) {
		if(lat1 == null || lon1 == null || lat2 == null || lon2 == null) return Double.MAX_VALUE;
		double theta = lon1 - lon2;
		double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2))
				+ Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2))
				* Math.cos(deg2rad(theta));
		dist = Math.acos(dist);
		dist = rad2deg(dist);
		dist = dist * 60 * 1.1515;
		
		return dist;
	}
	
	
	/**
	 * This function converts decimal degrees to radians
	 * @param deg
	 * @return
	 */
	private static double deg2rad(double deg) {
	  return (deg * Math.PI / 180.0);
	}
	
	/**
	 * This function converts radians to decimal degrees
	 * @param rad
	 * @return
	 */
	private static double rad2deg(double rad) {
	  return (rad * 180 / Math.PI);
	}


}
