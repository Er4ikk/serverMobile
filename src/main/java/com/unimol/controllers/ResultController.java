package com.unimol.controllers;




import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.LinkedHashMap;



import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.mysql.cj.jdbc.Blob;

import com.unimol.models.Result;

import com.unimol.queries.ResultQueries;


import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/results")
public class ResultController {
    ArrayList<Result> resultList = new ArrayList<Result>();
   ResultQueries resultQueries =new ResultQueries();
    
    
    @Path("/all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Result> getResults() {

	parseUser(this.resultQueries.getAllResults());
	
	
	return this.resultList;
	
    }
    
    @Path("/create")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createResult(LinkedHashMap result) {
	

	
	Result parsedResponse= new Result
		(0,
		(int)result.get("id_user"), 
		(Blob)null,
		result.get("labels").toString(),
		result.get("date").toString());

        Object mapper =new ObjectMapper();
	ObjectNode json = ((ObjectMapper) mapper).createObjectNode();

	
	this.resultQueries.insertResult(parsedResponse, (String) result.get("photo"));
        json.put("status", "ok");

	this.resultQueries.stopConnection();
        return Response.status(Response.Status.CREATED).entity(json).build();

    }
    
    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Result> getResultById(@PathParam("id")int id) {
	
	parseUser(this.resultQueries.getResultByUserId(id));
	
	
	return this.resultList;
	
    }
 
    
    
    @Path("/delete/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Result> deleteResultById(@PathParam("id")int id) {

	this.resultQueries.deleteResultById(id);
	this.resultQueries.stopConnection();
	return this.resultList;
	
    }
    
    
  
    public void parseUser(ResultSet results) {
	
	 try {

		 this.resultList.clear();
	     
	    while(results.next()) {
		int id= Integer.parseInt(results.getString(2));
		
		byte[] array;
		Blob photo;
		if(results.getString(3)==null) {
		    photo=null;
		    array=null;
		}else {
		    System.out.println(results.getBlob("photo"));
		    photo=(Blob) results.getBlob(3);
		    System.out.println(photo.getBytes(1, (int) photo.length()));
		   array=photo.getBytes(1, (int) photo.length());
		}
	
		this.resultList.add(new Result(
			results.getInt("id"),
			id,
			array,
			results.getString("date"),
			results.getString("labels")
			
			));
		
		
	         
	       }
	    
	   this.resultQueries.stopConnection();
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    	
        }
     

    
    
}
