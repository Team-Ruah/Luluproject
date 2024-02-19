package org.ohgiraffers.luluproject.controller;

import lombok.RequiredArgsConstructor;
import org.ohgiraffers.luluproject.dto.PageRequestDTO;
import org.ohgiraffers.luluproject.dto.PageResponseDTO;
import org.ohgiraffers.luluproject.dto.PostDTO;
import org.ohgiraffers.luluproject.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

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
    @GetMapping("/paging")
    public ResponseEntity<PageResponseDTO<PostDTO>> getPaging(PageRequestDTO pageRequestDTO){
        PageResponseDTO<PostDTO> result = postService.list(pageRequestDTO);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/register")
    public void registerGET() {

    }
    @PostMapping("/register")
    public String registerPost(PostDTO postDTO, RedirectAttributes redirectAttributes){

        Long postId = postService.register(postDTO);

        redirectAttributes.addFlashAttribute("result", postId);

        return  "redirect:/lulu/list";
    }

    @GetMapping({"/read", "/modify"})
    public void read(Long postId, PageRequestDTO pageRequestDTO, Model model){

        PostDTO postDTO = postService.readOne(postId);

        model.addAttribute("postId", postDTO);
    }

    @GetMapping("/readone")
    public ResponseEntity<PostDTO> getOnePost(Long postId) {
        PostDTO postDTO = postService.readOne(postId);
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

            redirectAttributes.addAttribute("postId", postDTO.getPostId());

            return "redirect:/lulu/modify?"+link;
        }
        postService.modify(postDTO);

        redirectAttributes.addFlashAttribute("result", "modified");

        redirectAttributes.addAttribute("postId", postDTO.getPostId());

        return "redirect:/lulu/read";
    }

    @PostMapping("/remove")
    public String remove(Long postId, RedirectAttributes redirectAttributes){

        postService.remove(postId);

        redirectAttributes.addFlashAttribute("result", "removed");

        return "redirect:/lulu/list";
    }
}
