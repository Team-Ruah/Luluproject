package org.ohgiraffers.luluproject.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.ohgiraffers.luluproject.domain.Post;
import org.ohgiraffers.luluproject.dto.PostDTO;
import org.ohgiraffers.luluproject.repository.PostRepository;
import org.springframework.stereotype.Service;

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

        Long post_id = postRepository.save(post).getPost_id();

        return post_id;
    }
}
