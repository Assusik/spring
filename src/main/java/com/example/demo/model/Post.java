package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Date;
@Entity
public class Post {


    private String text = " ";
    private Integer likes = 0;
    private Date creationDate;
    @Id
    @GeneratedValue
    private Long id;


    public Post() {


    }
    public Post( long id,String text, Integer likes, Date creationDate ) {
        this.id = id;
        this.text = text;
        this.likes = likes;
        this.creationDate = creationDate;
    }
    public long getId() {
        return id;
    }

    public Post(String text, Date creationDate) {  // Конструктор без id
        this.text = text;
        this.creationDate = creationDate;
        this.likes = 0;
    }
    public Post(long id,String text, Date creationDate) {
        this.text = text;
        this.creationDate = creationDate;
        this.id = id;

    }
    public Date getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public Integer getLikes() {
        return likes;
    }
    public void setLikes(Integer likes) {
        this.likes = likes;
    }


}
