package com.example.demo.service;

import com.example.demo.model.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PostService {

    private List<Post> posts = new ArrayList<>();
    public PostService(){
        posts.add(new Post(0,"1 пост", 2, new Date()));
        posts.add(new Post(1,"2 пост", 5, new Date()));
        posts.add(new Post(2,"3 пост", 14, new Date()));
    }
    public List<Post> listAllPosts(){

        return posts;
    }
    public void create(String text) {
        var id = posts.size();
        posts.add(new Post(id,text, new Date()));
    }
}
