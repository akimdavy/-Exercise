package com.example.demo.repository;

import com.example.demo.model.Post;
import org.springframework.data.repository.CrudRepository;


public interface PostRepository extends CrudRepository<Post, Long> {
   /* ArrayList<Post> findByUserId(Long userId);*/
}
