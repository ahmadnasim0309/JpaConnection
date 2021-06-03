package com.practice.WebService.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.WebService.post.Post;

@Repository
public interface postRepo extends JpaRepository<Post, Integer> {

}
