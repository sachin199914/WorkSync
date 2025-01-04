package com.example.projectManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projectManagement.entity.UserRoles;
import com.example.projectManagement.entity.Users;

public interface UserRolesRepo extends JpaRepository<UserRoles, Long> {

    UserRoles getUserRolesByUser(Users user);

}
