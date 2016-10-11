/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author shsun
 */
public class Book {

    private String id;
    private String name;
    private String news;
    private double price;
    private String author;
    private String classify;    
    private Date publishdate;
    
    public String getClassify() {
        return classify;
    }
    public void setClassify(String classify) {
		this.classify = classify;
    }
    
    public String getId() {
	return id;
    }
    public void setId(String id) {
	this.id = id;
    }
    
    public String getName() {
	return name;
    }
    public void setName(String name) {
	this.name = name;
    }    

    public String getNews() {
	return news;
    }
    public void setNews(String news) {
	this.news = news;
    }
    
    
    public double getPrice() {
	return price;
    }
    public void setPrice(double price) {
	this.price = price;
    }
    
    public Date getPublishdate() {
	return publishdate;
    }    
    public void setPublishdate(Date publishdate) {
	this.publishdate = publishdate;
    }

    public String getAuthor() {
	return author;
    }   

    public void setAuthor(String author) {
	this.author = author;
    }
}
