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
public  class User {
    
    private String userName;
    private String email;
    private String address;
    private String passWord;
    private int max_num,days_num;
    private int isFaculty;
    private int isStudent;
    private int isLibrarian;
    
    public User(){
    }

    public User(String userName, String Email, String passWord) {

       this.setUserName(userName);
       this.setPassWord(passWord);
       this.setEmail(email);
    }
    
    // email
    public String getEmail() {
       return email;
    }
    public void setEmail(String email) {
       this.email = email;
    }
    // address
    public String getAddress() {
       return address;
    }
    public void setAddress(String address) {
       this.address = address;
    }  
    //  password
    public String getPassWord() {
       return passWord;
    }
    public void setPassWord(String passWord) {
       this.passWord = passWord;
    }
       
    // user name
    public String getUserName() {
       return userName;
    }
    public void setUserName(String userName) {
       this.userName = userName;
    }
    
    public int getMaxNum(){
      return max_num;
    }
    public void setMaxNum(int max_num){
      this.max_num = max_num;
    }   
    
    public int getDaysNum(){
      return days_num;
    }
    public void setDaysNum(int days_num){
      this.days_num = days_num;
    }

    public int getIsStudent(){
      return isStudent;
    }
    public void setIsStudent(int isStudent){
      this.isStudent = isStudent;
    }    

    public int getIsFaculty(){
      return isFaculty;
    }
    public void setIsFaculty(int isFaculty){
      this.isFaculty = isFaculty;
    }
    
    public int getIsLibrarian(){
      return isLibrarian;
    }
    public void setIsLibrarian(int isLibrarian){
      this.isLibrarian = isLibrarian;
    }
    
}