package org.ohgiraffers.luluproject.service;

import org.ohgiraffers.luluproject.dto.PageRequestDTO;
import org.ohgiraffers.luluproject.dto.PageResponseDTO;
import org.ohgiraffers.luluproject.dto.PostDTO;

import java.util.List;

public interface PostService {

    Long register(PostDTO postDTO);

    PostDTO readOne(Long postId);

    void modify(PostDTO postDTO);

    void remove(Long postId);

    PageResponseDTO<PostDTO> list(PageRequestDTO pageRequestDTO);

    List<PostDTO> getAllList();

}
