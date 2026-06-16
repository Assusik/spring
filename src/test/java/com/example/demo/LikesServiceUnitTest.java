package com.example.demo;

import com.example.demo.model.Post;
import com.example.demo.repository.PostRepository;
import com.example.demo.service.LikesService;
import com.example.demo.service.PostService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LikesServiceUnitTest {

    @Mock
    private PostRepository postRepository;

    @Mock
    private PostService postService;

    @InjectMocks
    private LikesService likesService;

    @Test
    public void testLike_ShouldIncreaseLikesByOne() {

        Long postId = 1L;
        Post post = new Post(postId, "Test post", 5, new Date());
        when(postRepository.findById(postId)).thenReturn(Optional.of(post));


        Integer result = likesService.like(postId);


        assertEquals(6, result); // было 5, стало 6
        assertEquals(6, post.getLikes()); // пост обновился
        verify(postRepository, times(1)).save(post);
    }

    @Test
    public void testLike_WhenPostNotFound_ShouldThrowException() {

        Long postId = 999L;
        when(postRepository.findById(postId)).thenReturn(Optional.empty());


        org.junit.jupiter.api.Assertions.assertThrows(
                java.util.NoSuchElementException.class,
                () -> likesService.like(postId)
        );

        verify(postRepository, never()).save(any());
    }
}