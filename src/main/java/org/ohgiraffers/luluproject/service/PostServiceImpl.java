package org.ohgiraffers.luluproject.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.ohgiraffers.luluproject.domain.Post;
import org.ohgiraffers.luluproject.dto.PostDTO;
import org.ohgiraffers.luluproject.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;

    @Override
    public Long register(PostDTO postDTO) {
        Post post = new Post();

        post.setTitle(postDTO.getTitle());
        post.setContent(postDTO.getContent());

        //Post post = Post.builder()
        //                    .title(postDTO.getTitle())
        //                    .content(postDTO.getContent())
        //                    .build();
        // Post 클래스에 setter 사용 안할시

        Long post_id = postRepository.save(post).getPost_id();

        return post_id;
    }

    @Override
    public PostDTO readOne(Long post_id) {

        Optional<Post> result = postRepository.findById(post_id);

        Post post = result.orElseThrow();

        PostDTO postDTO = new PostDTO();
        postDTO.setTitle(post.getTitle());
        postDTO.setContent(post.getContent());

        return postDTO;
    }

    @Override
    public void modify(PostDTO postDTO) {
        Optional<Post> result = postRepository.findById(postDTO.getPost_id());

        Post post = result.orElseThrow();

        post.change(postDTO.getTitle(), postDTO.getContent());

        postRepository.save(post);
    }

    @Override
    public void remove(Long post_id) {

        postRepository.deleteById(post_id);
    }
}
