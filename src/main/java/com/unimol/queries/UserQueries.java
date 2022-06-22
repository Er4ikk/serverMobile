package com.unimol.queries;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import com.unimol.databaseConfig.DatabaseConfiguration;

public class UserQueries {
    
    DatabaseConfiguration databaseConfiguration;
    Statement statement;
    Connection connection;
    
    public UserQueries() {
	databaseConfiguration=new DatabaseConfiguration();
	connection=databaseConfiguration.getConnection();
	
    }
    
    public ResultSet getAllUsers() {
	String query="SELECT * FROM `USER`";
	
	try {
	    this.statement=(Statement) this.connection.createStatement();
	    ResultSet results = this.statement.executeQuery(query);
	    
	  
	  
	  
	   return results;
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    	System.out.println("cannot create statement "+e);
	}
	
	return null;
    }
    
    public void  stopConnection() {
	 try {
	    this.connection.close();
	    this.databaseConfiguration.stopConnection();
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	
    }

}
