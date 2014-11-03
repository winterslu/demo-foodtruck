package com.foodtruck.rest.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;



@Path("/helloworld")
public interface HelloWorld {

	@GET
	public Response responseMsg();
}
