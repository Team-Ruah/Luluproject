package org.ohgiraffers.luluproject.repository;

import org.junit.jupiter.api.Test;
import org.ohgiraffers.luluproject.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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

            Post result = postRepository.save(post);
        });
    }
}


