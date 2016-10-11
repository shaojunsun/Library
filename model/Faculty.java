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
public class Faculty extends User{
    private String facultyID;
    
   public Faculty(String facultyID){
      
    }
    
    public String getFacultyID(){
      return facultyID;
    }
    public void setFacultyID(String facultyID){
      this.facultyID = facultyID;
    }         
}
