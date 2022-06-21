package com.unimol.databaseConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfiguration {
   
    private String host="localhost";
    private String port="3308";
    private String dbName="plant_checker";
    
   private  String databaseUrl="jdbc:mysql://" + this.host + ":" + this.port + "/"+this.dbName ;
   
   
   private String user="root";
   private String password="";
   
   
   public DatabaseConfiguration() {
       createConnection();
   }
   
   public String getDatabaseUrl() {
       return this.databaseUrl;
   }
   
   public String getDatabaseUser() {
       return this.user;
   }
   
   public String getDatabasePassword() {
       return this.password;
   }
   
   public void createConnection() {
       try {
	Class.forName("com.mysql.jdbc.Driver");
	Connection connection = DriverManager.getConnection(this.databaseUrl,this.user,this.password);
	System.out.println("Connection succesfull with database");
	System.out.println(connection.toString());
	
	
    } catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
		System.out.println("Class not Found com.mysql.jdbc.Driver "  + e);
    } catch (SQLException e) {
	// TODO Auto-generated catch block
	System.out.println("Connection with database failed  "+ e);
    }
   }

}
