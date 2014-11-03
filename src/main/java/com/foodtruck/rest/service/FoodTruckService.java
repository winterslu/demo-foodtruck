/**
 * 
 */
package com.foodtruck.rest.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.foodtruck.rest.model.FoodTruck;


/**
 * @author winters
 *
 */
@Path("/foodtrucks")
@Produces(MediaType.APPLICATION_JSON)
public interface FoodTruckService {
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	void create(FoodTruck foodTruck);
	
	@Path("/{foodtruckId}")
	@GET
	FoodTruck get(@PathParam("foodtruckId") Long foodtruckId);
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	void update (FoodTruck foodTruck);
	
}
