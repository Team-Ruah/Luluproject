package org.ohgiraffers.luluproject.repository;

import org.junit.jupiter.api.Test;
import org.ohgiraffers.luluproject.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class PostRepositoryTests {
    @Autowired
    private PostRepository postRepository;

    @Test
    public void testInsert() {
        IntStream.rangeClosed(1,100).forEach(i -> {
            Post post = Post.builder()
                    .title("title..." + i)
                    .content("content..." + i)
                    .build();

           postRepository.save(post);
        });
    }

    @Test
    public void testDelete(){

        Long postId = 1L;
        postRepository.deleteById(postId);
    }

    @Test
    public void testUpdate() {
        Long postId = 100L;

        Optional<Post> result = postRepository.findById(postId);

        Post post = result.orElseThrow();

        post.change("update..title 100", "update content 100");

        postRepository.save(post);
    }
}


