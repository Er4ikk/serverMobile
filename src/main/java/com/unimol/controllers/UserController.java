package com.unimol.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.unimol.models.User;
import com.unimol.queries.UserQueries;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/users")
public class UserController {
    ArrayList<User> UserList = new ArrayList<User>();
    UserQueries userQueries = new UserQueries();
    
    
    @Path("/all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<User> getUsers() {

	parseUser(this.userQueries.getAllUsers());
	
	
	return this.UserList;
	
    }
    
    @Path("/create")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(User user) {

        Object mapper =new ObjectMapper();
	ObjectNode json = ((ObjectMapper) mapper).createObjectNode();
	
	
	this.userQueries.insertUser(user);
        json.put("status", "ok");
        this.userQueries.stopConnection();
        return Response.status(Response.Status.CREATED).entity(json).build();

    }
    
    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<User> getUsersById(@PathParam("id")int id) {
	
	parseUser(this.userQueries.getUserById(id));
	
	
	return this.UserList;
	
    }
    
    @Path("/delete/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<User> deleteUserById(@PathParam("id")int id) {

	this.userQueries.deleteUserById(id);
	
	this.userQueries.stopConnection();
	return this.UserList;
	
    }
    
    
    
    public void parseUser(ResultSet results) {
	
	 try {
	    while(results.next()) {
		int id= Integer.parseInt(results.getString(1));
		this.UserList.add(new User(
			id,
			results.getString(2),
			results.getString(3),
			results.getString(4),
			results.getString(5)
			
			));
		
		
	         
	       }
	    
	    this.userQueries.stopConnection();
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	    
    }

}
