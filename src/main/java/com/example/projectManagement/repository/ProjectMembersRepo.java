package com.example.projectManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projectManagement.entity.ProjectMembers;

public interface ProjectMembersRepo extends JpaRepository<ProjectMembers, Long>{
    
}
