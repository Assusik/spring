package com.example.demo.model;

import java.util.Calendar;
import java.util.Date;

public class Post {
    private String text = " ";
    private Integer likes = 0;
    private Date creationDate;

    public Post(String text, Integer likes, Date creationDate) {
        this.text = text;
        this.likes = likes;
        this.creationDate = creationDate;
    }
    public Post(String text) {
        this.text = text;

    }
    public Post(String text, Date creationDate) {
        this.text = text;
        this.creationDate = creationDate;

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
