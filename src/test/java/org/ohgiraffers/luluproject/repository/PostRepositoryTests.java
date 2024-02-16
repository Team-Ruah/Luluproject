package org.ohgiraffers.luluproject.repository;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.ohgiraffers.luluproject.domain.Post;
import org.ohgiraffers.luluproject.dto.PostDTO;
import org.ohgiraffers.luluproject.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.stream.IntStream;

@Log4j2
@SpringBootTest
public class PostRepositoryTests {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostService postService;

    @Test
    public void testInsert() {
        IntStream.rangeClosed(1,100).forEach(i -> {
            Post post = Post.builder()
                    .title("title..." + i)
                    .content("content..." + i)
                    .build();
// postRepository.save(post); // 해당 코드를 사용하지 않을 경우, result 변수 불필요
            postRepository.save(post); // 사용하지 않을 경우 주석 처리하거나 삭제 가능
        });
    }

    @Test
    public void testRegister() {

        log.info(postService.getClass().getName());

        PostDTO postDTO = PostDTO.builder()
                .post_title("Sample Title...")
                .content("Sample Content...")
                .build();

        Long post_id = postService.register(postDTO);
        log.info("post_id:  " + post_id);

    }
}


