package org.ohgiraffers.luluproject.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.ohgiraffers.luluproject.domain.Post;
import org.ohgiraffers.luluproject.dto.PageRequestDTO;
import org.ohgiraffers.luluproject.dto.PageResponseDTO;
import org.ohgiraffers.luluproject.dto.PostDTO;
import org.ohgiraffers.luluproject.repository.PostRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class PostServiceImpl implements PostService {

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
        //

        Long post_id = postRepository.save(post).getPost_id();

        return post_id;
    }

    @Override
    public PostDTO readOne(Long post_id) {

        Optional<Post> result = postRepository.findById(post_id);

        Post post = result.orElseThrow();

        PostDTO postDTO = new PostDTO();
        postDTO.setPost_id(post.getPost_id());
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

    @Override
    public List<PostDTO> getAllList() {
        List<Post> ListAll = postRepository.findAll();
        List<PostDTO> dtos = ListAll.stream()
                .map(Post -> convertToDto(Post))
                .collect(Collectors.toList());

        return dtos;
    }
    private PostDTO convertToDto(Post post) {
        PostDTO dto = new PostDTO();
        dto.setPost_id(post.getPost_id());
        dto.setTitle(post.getTitle());
        dto.setContent(post.getContent());
        return dto;
    }
}
