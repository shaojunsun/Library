/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author shsun
 */
public class Library {

   private String name;
   private String address;
   private String telphone;
   
   public String getName(){
      return name;
   }
   public void setName(){
      this.name = name;
   } 
   public String getAddress(){
      return address;
   }
   public void setAddress(){
      this.address = address;
   }  
   
   public String getTelphone(){
      return telphone;
   }
   public void setTelphone(){
      this.telphone = telphone;
   }    
}
