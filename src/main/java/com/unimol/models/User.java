package com.unimol.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    		private int id;
    		private String name;
    		private String username;
    		private String surname;
    		private String password;
    		
    		
    		public User( @JsonProperty("id")int id,
    			@JsonProperty("name")String name,
    			@JsonProperty("username") String username,
    			@JsonProperty("surname")String surname, 
    			@JsonProperty("password")String password) {
    		    this.setId(id);
    		    this.setName(name);
    		    this.setPassword(password);
    		    this.setSurname(surname);
    		    this.setUsername(username);
    		    
    		}
    		
    		public  int getId() {
    		    return this.id;
    		}
    		

    		public  String getName() {
    		    return this.name;
    		}
    		
    		public  String getUsername() {
    		    return this.username;
    		}
    		
    		public  String getSurname() {
    		    return this.surname;
    		}
    		
    		public  String getPassword() {
    		    return this.password;
    		}
    		
    		public void setId(int id) {
    		    this.id=id;
    		}
    		
    		public void setName(String name) {
    		    this.name=name;
    		}
    		
    		public void setUsername(String username) {
    		    this.username=username;
    		}
    		
    		public void setSurname(String surname) {
    		    this.surname=surname;
    		}
    		public void setPassword(String password) {
    		    this.password=password;
    		}
}
