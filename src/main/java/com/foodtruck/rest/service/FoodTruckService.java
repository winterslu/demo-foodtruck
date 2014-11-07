/**
 * 
 */
package com.foodtruck.rest.service;

import java.util.List;
import java.util.Queue;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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
	
	
	@GET
	List<FoodTruck> get();
	
	
	@GET
	@Path("/random")
	List<FoodTruck> getRandom();
	
	
	@GET
	@Path("/indistance")
	List<FoodTruck> indistance(
			@DefaultValue("37.7491426")		@QueryParam("lat") double latitude,
			@DefaultValue("-122.4361673")	@QueryParam("lng") double longitude,
			@DefaultValue("5")			@QueryParam("dist") double distance);
	
	@GET
	@Path("/closest")
	Queue<FoodTruck> cloest(
			@DefaultValue("37.7491426")		@QueryParam("lat") double latitude,
			@DefaultValue("-122.4361673")	@QueryParam("lng") double longitude,
			@DefaultValue("20")				@QueryParam("count") int count);
	
	
	@Path("/{foodtruckId}")
	@GET
	FoodTruck get(@PathParam("foodtruckId") Long foodtruckId);
	
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	void update(FoodTruck foodTruck);
	
}
