package com.unimol.queries;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import com.mysql.cj.jdbc.Blob;
import com.mysql.cj.protocol.x.ReusableOutputStream;
import com.unimol.databaseConfig.DatabaseConfiguration;
import com.unimol.models.Result;


public class ResultQueries {

    
    DatabaseConfiguration databaseConfiguration;
    Statement statement;
    Connection connection;
    
    public  ResultQueries() {
	databaseConfiguration=new DatabaseConfiguration();
	connection=databaseConfiguration.getConnection();
    }
    
    public ResultSet getAllResults() {
	String query="SELECT * FROM `RESULT`";
	
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
    
    
    public ResultSet getResultByUserId(int id) {
	String query="SELECT * FROM `RESULT` WHERE id_user="+id;
	
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
    
    
    public void insertResult(Result result,String photo) {
	
	
	try {
	    
	    
	  if(photo==null) {
	      photo=null;
	  }

		
	    	String query="INSERT INTO `RESULT` (`id`, `id_user`, `photo`, `labels`, `date`) VALUES "
				+ "(NULL,  ' "+result.getIdUser()+" ' , "+photo+
				" , ' "+result.getLabel()+" ' , ' "+result.getDate()+" ' ); ";
	    		System.out.println(query);

		this.statement=(Statement) this.connection.createStatement();
	   this.statement.executeUpdate(query);
	   System.out.println("User insert correctly");
	} catch (SerialException e1) {
	    // TODO Auto-generated catch block
		System.out.println("cannot serialize "+e1);
	    e1.printStackTrace();
	} catch (SQLException e1) {
	    // TODO Auto-generated catch block
	   	System.out.println("cannot create statement "+e1);
	    e1.printStackTrace();
	}
	
	
	
	
	
	
    }
    
    public void deleteResultById(int id) {
	
	String query="DELETE  FROM `RESULT` WHERE id="+id;
	
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
