package com.example.demo.service;

import com.example.demo.model.Post;
import com.example.demo.repository.PostRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PostServiceUnitTest {

    @Mock
    private PostRepository postRepository;

    @InjectMocks
    private PostService postService;

    @Test
    public void testListAllPosts_ShouldReturnAllPosts() {

        Post post1 = new Post(1L, "Post 1", 10, new Date());
        Post post2 = new Post(2L, "Post 2", 20, new Date());
        when(postRepository.findAll()).thenReturn(Arrays.asList(post1, post2));


        List<Post> result = postService.listAllPosts();


        assertEquals(2, result.size());
        assertEquals("Post 1", result.get(0).getText());
        verify(postRepository, times(1)).findAll();
    }

    @Test
    public void testCreate_ShouldSavePost() {

        String text = "New test post";


        postService.create(text);


        verify(postRepository, times(1)).save(any(Post.class));
    }
}