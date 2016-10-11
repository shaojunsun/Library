/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author shsun
 */
public class Student extends User {
    
    private String studentID;

    private List<Book2> borrowedBooks = new ArrayList<>();
    
    public Student(String userName, String email, String passWord, String studentID){
        super(userName, email, passWord);
        this.studentID = studentID;
    }
    
    public String getStudentID(){
      return studentID;
    }
    public void setStudentID(String studentID){
      this.studentID = studentID;
    }

    public void borrowBook(Book2 book) {
        borrowedBooks.add(book);
    }

    public List<Book2> getBorrowedBooks() {
        return borrowedBooks;
    }
}
