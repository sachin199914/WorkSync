package com.example.projectManagement.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projectManagement.entity.Users;

public interface UserRepo extends JpaRepository<Users, Long>{
    
}
