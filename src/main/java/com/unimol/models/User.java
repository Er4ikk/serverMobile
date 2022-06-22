package com.unimol.models;

public class User {
    		private int id;
    		private String name;
    		private String username;
    		
    		public User() {
    		    
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
    		
    		public void setId(int id) {
    		    this.id=id;
    		}
    		
    		public void setName(String name) {
    		    this.name=name;
    		}
    		
    		public void setUsername(String username) {
    		    this.username=username;
    		}
}
