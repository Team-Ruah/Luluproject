package org.ohgiraffers.luluproject.service;

import lombok.RequiredArgsConstructor;
import org.ohgiraffers.luluproject.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public void remove(Long post_id) {

        postRepository.deleteById(post_id);
    }
}
