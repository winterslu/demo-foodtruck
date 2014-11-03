package com.foodtruck.rest.service;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

@Component
public class HelloWorldREST implements HelloWorld{

	@Override
	public Response responseMsg() {
		return Response.status(200).entity("This is Hello World endpoint").build();
	}
	
}
