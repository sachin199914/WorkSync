package com.example.projectManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projectManagement.entity.Tasks;

public interface TasksRepo extends JpaRepository<Tasks, Long>{
    
}
