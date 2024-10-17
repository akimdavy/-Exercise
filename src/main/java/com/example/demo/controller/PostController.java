package com.example.demo.controller;

import com.example.demo.model.Post;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.service.PostService;

@Controller
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;
    
    
    @GetMapping("/create")
    public String showCreatePostForm(Model model) {
        model.addAttribute("post", new Post());
        return "createpost"; 
    }
    
    @GetMapping
    public String getAllPosts(Model model) {
        ArrayList<Post> posts = postService.getAllPosts();
        model.addAttribute("posts", posts);
        return "postList"; 
    }

    

    @PostMapping("/create")
    public String createPost(@ModelAttribute Post post) {
        postService.createPost(post); 
        return "redirect:/posts"; 
    }

    @GetMapping("/edit/{id}")
    public String showEditPostForm(@PathVariable Long id, Model model) {
        Post post = postService.getPostById(id);
        if (post != null) {
            model.addAttribute("post", post);
            return "editPost"; 
        }
        return "redirect:/posts"; 
    }

    @PostMapping("/edit/{id}")
    public String updatePost(@PathVariable Long id, @ModelAttribute Post post) {
        postService.updatePost(id, post);
        return "redirect:/posts"; 
    }

    @PostMapping("/delete/{id}")
    public String deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return "redirect:/posts";
    }
    @GetMapping("/{id}")
    public String getPostById(@PathVariable Long id, Model model) {
        Post post = postService.getPostById(id);
        if (post != null) {
            model.addAttribute("post", post);
            return "postDetail";
        }
        return "redirect:/posts"; 
    }

}
