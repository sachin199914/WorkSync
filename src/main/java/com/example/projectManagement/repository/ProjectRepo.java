package com.example.projectManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projectManagement.entity.Project;

public interface ProjectRepo extends JpaRepository<Project, Long>{
    
}
