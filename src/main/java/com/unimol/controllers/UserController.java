package com.unimol.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.unimol.models.User;
import com.unimol.queries.UserQueries;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/users")
public class UserController {
    ArrayList<User> UserList = new ArrayList<User>();
    UserQueries userQueries = new UserQueries();
    
    
    @Path("/all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<User> getUsers() {
	UserQueries userQueries = new UserQueries();
	parseUser(userQueries.getAllUsers());
	
	
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
