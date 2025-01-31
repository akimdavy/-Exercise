package com.example.demo.repository;

import com.example.demo.model.Comment;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface CommentRepository extends CrudRepository<Comment, Long> {
    ArrayList<Comment> findByPostId(Long postId);
}
