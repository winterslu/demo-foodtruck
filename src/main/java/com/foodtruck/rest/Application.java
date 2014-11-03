package com.foodtruck.rest;

import org.glassfish.jersey.server.ResourceConfig;

import com.foodtruck.rest.service.FoodTruckServiceImpl;
import com.foodtruck.rest.service.HelloWorldREST;

public class Application extends ResourceConfig {
	public Application() {
		register(HelloWorldREST.class);
		register(FoodTruckServiceImpl.class);
	}
}
