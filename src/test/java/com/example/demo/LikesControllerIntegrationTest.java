package com.example.demo.controller;

import com.example.demo.model.Post;
import com.example.demo.repository.PostRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class LikesControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PostRepository postRepository;

    private Long testPostId;

    @BeforeEach
    public void setUp() {

        Post post = new Post("Test post for likes", new Date());
        post = postRepository.save(post);
        testPostId = post.getId();
    }

    @Test
    public void testLike_ShouldIncreaseLikes() throws Exception {

        Post post = postRepository.findById(testPostId).get();
        int initialLikes = post.getLikes();


        mockMvc.perform(post("/post/" + testPostId + "/like"))
                .andExpect(status().isOk())
                .andExpect(content().string(String.valueOf(initialLikes + 1)));


        Post updatedPost = postRepository.findById(testPostId).get();
        assert updatedPost.getLikes() == initialLikes + 1;
    }
}
