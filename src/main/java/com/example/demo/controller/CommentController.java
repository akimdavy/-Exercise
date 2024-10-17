package com.example.demo.controller;

import com.example.demo.model.Comment;
import com.example.demo.model.Post;
import com.example.demo.service.CommentService;
import com.example.demo.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private PostService postService;

    @GetMapping
    public String getAllComments(Model model) {
        ArrayList<Comment> comments = commentService.getAllComments();
        model.addAttribute("comments", comments);
        return "commentList"; 
    }

    @GetMapping("/create/{postId}")
    public String showCreateCommentForm(@PathVariable Long postId, Model model) {
        Post post = postService.getPostById(postId);
        if (post != null) {
            model.addAttribute("post", post);
            model.addAttribute("comment", new Comment());
            return "createComment"; 
        }
        return "redirect:/posts"; 
    }

    @PostMapping("/create/{postId}")
    public String createComment(@ModelAttribute Comment comment, @PathVariable Long postId) {
        Post post = postService.getPostById(postId);
        if (post != null) {
            comment.setPost(post); 
            commentService.addComment(comment); 
        }
        return "redirect:/comments"; 
    }


    
}
