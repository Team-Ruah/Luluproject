package org.ohgiraffers.luluproject.service;

import org.ohgiraffers.luluproject.domain.Post;
import org.ohgiraffers.luluproject.dto.PageRequestDTO;
import org.ohgiraffers.luluproject.dto.PageResponseDTO;
import org.ohgiraffers.luluproject.dto.PostDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

public interface PostService {

    Long register(PostDTO postDTO);

    PostDTO readOne(Long postid);

    void modify(PostDTO postDTO);

    void remove(Long postid);

   PageResponseDTO<PostDTO> list(PageRequestDTO pageRequestDTO);

    List<PostDTO> getAllList();

}
