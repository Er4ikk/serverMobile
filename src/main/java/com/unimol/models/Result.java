package com.unimol.models;

import java.sql.Blob;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mysql.cj.util.DnsSrv.SrvRecord;




public class Result {
    
    private int idResult;
    private int idUser;
    private Blob photo;
    private String labels;
    private String date;
    public byte[ ] bytes;


    public Result(@JsonProperty("id_result")int idResult,
	    			@JsonProperty("id_user")int idUser,
	    			@JsonProperty("photo")Blob photo,
	    			@JsonProperty("labels")String labels,
	    			@JsonProperty("date")String date)
    {
	setIdResult(idResult);
	setIdUser(idUser);
	setDate(date);
	setLabel(labels);
	setPhooto(photo);
    }
    
    public Result(int idResult,int id, byte[] bytes, String date, String labels) {
	setIdResult(idResult);
	setIdUser(id);
	setDate(date);
	setLabel(labels);
	setBytes(bytes);
    }
    
    public byte [] getBytes() {
	return this.bytes;
    }

    public int getIdUser() {
	return this.idUser;
    }
    
    public int getIdResult() {
   	return this.idResult;
       }
    
    public Blob getPhooto() {
	return this.photo;
    }
    
    public String getLabel() {
	return this.labels;
    }
    
   public String getDate() {
       return this.date;
   }
   
   public void setBytes(byte[] stream) {
	this.bytes=stream;
    }

   
   public void setIdUser(int id) {
	
       this.idUser=id;
   }
   
   public void setIdResult(int id) {
	
       this.idResult=id;
   }
   
   public void setPhooto(Blob photo) {
	this.photo=photo;
   }
   
   public void setLabel(String label) {
       this.labels=label;
   }
   
  public void setDate(String date) {
      this.date=date;
  }
}
