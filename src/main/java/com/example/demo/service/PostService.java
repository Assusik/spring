package com.example.demo.service;

import com.example.demo.model.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PostService {
    public List<Post> listAllPosts(){
        var list =  List.of(new Post("1 пост",2,new Date()),new Post("2 пост",5,new Date()),new Post("3 пост",14,new Date()));
        return list;
    }
}
