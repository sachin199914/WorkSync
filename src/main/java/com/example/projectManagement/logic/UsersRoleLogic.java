package com.example.projectManagement.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.projectManagement.dto.UserRolesReqDto;
import com.example.projectManagement.entity.Roles;
import com.example.projectManagement.entity.UserRoles;
import com.example.projectManagement.entity.Users;
import com.example.projectManagement.repository.RolesRepo;
import com.example.projectManagement.repository.UserRepo;
import com.example.projectManagement.repository.UserRolesRepo;

@Component
public class UsersRoleLogic {

    @Autowired
    UserRolesRepo userRolesRepo;

    @Autowired
    RolesRepo rolesRepo;

    @Autowired
    UserRepo userRepo;

    @SuppressWarnings("deprecation")
    public UserRoles assignUserRole(UserRolesReqDto userRolesReqDto) {
        UserRoles userRoles = new UserRoles();
        Roles roles = rolesRepo.getByName(userRolesReqDto.getRoleName());
        Users user = userRepo.getById(userRolesReqDto.getUserId());
        userRoles.setRole(roles);
        userRoles.setUser(user);
        return userRolesRepo.save(userRoles);
    }

    
}
