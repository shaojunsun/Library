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
public class Student extends User{
    
    private String studentID;
    
    public Student(String studentID){
      
    }
    
    public String getStudentID(){
      return studentID;
    }
    public void setStudentID(String studentID){
      this.studentID = studentID;
    }  
    
}
