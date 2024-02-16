package org.ohgiraffers.luluproject.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.ohgiraffers.luluproject.domain.Post;
import org.ohgiraffers.luluproject.dto.PostDTO;
import org.ohgiraffers.luluproject.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Log4j2
@RequiredArgsConstructor
@Transactional
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public Long register(PostDTO postDTO) {
        Post post = new Post();
        post.setTitle(postDTO.getPost_title());
        post.setContent(postDTO.getContent());

        Post savedPost = postRepository.save(post);

        return savedPost.getPost_id();
    }
}
