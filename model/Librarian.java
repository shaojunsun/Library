/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.model;

/**
 *
 * @author shsun
 */
public class Librarian extends User{

 private String librarianID;
    
   public Librarian(String librarianID){
      
    }
    
    public String getLibrarianID(){
      return librarianID;
    }
    public void setLibrarianID(String librarianID){
      this.librarianID = librarianID;
    }      
    
}
