package org.ohgiraffers.luluproject.controller;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.ohgiraffers.luluproject.service.PostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@RestController
@RequestMapping("/post")

public class PostController {

//    private final PostService postService;
//
//
//
//
//    @GetMapping("/remove")
//    public void remove(Long post_id, RedirectAttributes redirectAttributes){
//
//        postService.remove(post_id);
//
//        redirectAttributes.addFlashAttribute("result", "removed");
//
////        return "redirect:/list";
//
//    }



}
