package com.example.demo.model;

import java.util.Date;

public class Post {
    private String text = " ";
    private Integer likes = 0;
    private Date creationDate;
    private long id;


    public Post( long id,String text, Integer likes, Date creationDate ) {
        this.id = id;
        this.text = text;
        this.likes = likes;
        this.creationDate = creationDate;
    }
    public long getId() {
        return id;
    }
    public Post(long id,String text) {
        this.text = text;
        this.id = id;

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
