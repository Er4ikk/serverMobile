package com.unimol.controllers;

import com.unimol.models.User;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/users")
public class UserController {
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser() {
	
	User u = new User();
	u.setId(0);
	u.setName("pippo");
	
	return u;
	
    }

}
