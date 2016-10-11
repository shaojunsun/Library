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
public class User {
    
    private String userName;
    private String email;
    private String passWord;

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
}