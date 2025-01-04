package com.example.projectManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projectManagement.entity.Comments;

public interface CommentsRepo extends JpaRepository<Comments, Long>{
    
}
