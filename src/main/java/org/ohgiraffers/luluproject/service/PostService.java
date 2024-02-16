package org.ohgiraffers.luluproject.service;

import org.ohgiraffers.luluproject.dto.PostDTO;

public interface PostService {

    Long register(PostDTO postDTO);

    void remove(Long post_id);
}
