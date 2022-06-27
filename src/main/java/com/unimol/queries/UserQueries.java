package com.unimol.queries;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import com.unimol.databaseConfig.DatabaseConfiguration;
import com.unimol.models.User;

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
    
    
    public ResultSet getUserById(int id) {
	String query="SELECT * FROM `USER` WHERE id="+id;
	
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
    
    public ResultSet getUserByMail(String mail) {
   	String query="SELECT * FROM `USER` WHERE mail= '"+mail+"' ";
   
   	
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
       
    
    public ResultSet getUserByMailAndPassword(String mail,String password) {
	String query="SELECT * FROM `USER` WHERE USER.mail='"+mail  +"'  AND  USER.password='"+password+"' ";
	System.out.println(query);
	
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
    
    public void insertUser(User user) {
	
String query="INSERT INTO `USER` (`id`, `name`, `surname`, `password`, `mail`) VALUES "
				+ "(NULL,  '"+user.getName()+"' ,'"+user.getSurname().toString()+
				"' , '"+user.getPassword()+"' , '"+user.getMail()+"' ); ";
	
	

	
	try {
	    this.statement=(Statement) this.connection.createStatement();
	   this.statement.executeUpdate(query);
	   System.out.println("User insert correctly");
	  
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    	System.out.println("cannot create statement "+e);
	}
	
	
	
    }
    
    public void deleteUserById(int id) {
	
	String query="DELETE  FROM `USER` WHERE id="+id;
	
	try {
	    this.statement=(Statement) this.connection.createStatement();
	     this.statement.executeUpdate(query);
	  
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    	System.out.println("cannot create statement "+e);
	}
	
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
