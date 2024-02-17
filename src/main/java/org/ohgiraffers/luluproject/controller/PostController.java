package org.ohgiraffers.luluproject.controller;

import lombok.RequiredArgsConstructor;
import org.ohgiraffers.luluproject.domain.Post;
import org.ohgiraffers.luluproject.dto.PageRequestDTO;
import org.ohgiraffers.luluproject.dto.PageResponseDTO;
import org.ohgiraffers.luluproject.dto.PostDTO;
import org.ohgiraffers.luluproject.repository.PostRepository;
import org.ohgiraffers.luluproject.service.PostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/lulu")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

@GetMapping("/list")
public ResponseEntity<List<PostDTO>> getAllList() {
    List<PostDTO> dtos = postService.getAllList();
    return new ResponseEntity<>(dtos, HttpStatus.OK);
}

    @GetMapping("/register")
    public void registerGET() {

    }
    @PostMapping("/register")
    public String registerPost(PostDTO postDTO, RedirectAttributes redirectAttributes){

        Long post_id = postService.register(postDTO);

        redirectAttributes.addFlashAttribute("result", post_id);

        return  "redirect:/lulu/list";
    }

    @GetMapping({"/read", "/modify"})
    public void read(Long post_id, PageRequestDTO pageRequestDTO, Model model){

        PostDTO postDTO = postService.readOne(post_id);

        model.addAttribute("post_id", postDTO);
    }

    @GetMapping("/readone")
    public ResponseEntity<PostDTO> getOnePost(Long post_id) {
        PostDTO postDTO = postService.readOne(post_id);
        return new ResponseEntity<>(postDTO, HttpStatus.OK);
    }

    @PostMapping("/modify")
    public String modify( PageRequestDTO pageRequestDTO,
                          PostDTO postDTO,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()) {
            String link = pageRequestDTO.getLink();

            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());

            redirectAttributes.addAttribute("post_id", postDTO.getPost_id());

            return "redirect:/lulu/modify?"+link;
        }
        postService.modify(postDTO);

        redirectAttributes.addFlashAttribute("result", "modified");

        redirectAttributes.addAttribute("post_id", postDTO.getPost_id());

        return "redirect:/lulu/read";
    }

    @PostMapping("/remove")
    public String remove(Long post_id, RedirectAttributes redirectAttributes){

        postService.remove(post_id);

        redirectAttributes.addFlashAttribute("result", "removed");

        return "redirect:/lulu/list";
    }
}
