package com.example.projectManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projectManagement.entity.Roles;

public interface RolesRepo extends JpaRepository<Roles, Long>{
    
}
