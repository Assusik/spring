package com.example.demo.service;

import com.example.demo.model.Post;
import com.example.demo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;
    private List<Post> posts = new ArrayList<>();
    public PostService(){
        posts.add(new Post(0,"1 пост", 2, new Date()));
        posts.add(new Post(1,"2 пост", 5, new Date()));
        posts.add(new Post(2,"3 пост", 14, new Date()));
    }
    public List<Post> listAllPosts() {
        return StreamSupport.stream(postRepository.findAll().spliterator(), false).toList();
    }
    public void create(final String text) {
        Post post = new Post(text, new Date());
        postRepository.save(post);
    }
}
