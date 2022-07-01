package com.unimol.databaseConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfiguration {
   
    private String host="localhost";
    private String port="3306";
    private String dbName="plant_checker";
    
   private  String databaseUrl="jdbc:mysql://" + this.host + ":" + this.port + "/"+this.dbName ;
   
   
   private String user="root";
   private String password="";
   
   
   private Connection connection;
   
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
   
   public Connection getConnection() {
       return this.connection;
   }
   
   public void createConnection() {
       try {
	Class.forName("com.mysql.jdbc.Driver");
	 this.connection = DriverManager.getConnection(this.databaseUrl,this.user,this.password);
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
   
   public void stopConnection() {
       try {
	this.connection.close();
	System.out.println("connection to db closed dbconfig");
    } catch (SQLException e) {
	// TODO Auto-generated catch block
	System.out.println("cannot close dbconfig");
	e.printStackTrace();
	
    }
   }

}
