package com.example.projectManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectManagement.dto.UserRolesReqDto;
import com.example.projectManagement.entity.UserRoles;
import com.example.projectManagement.logic.UsersRoleLogic;

@Service
public class UserRoleService {

    @Autowired
    UsersRoleLogic usersRoleLogic;

    
     public UserRoles assignUserRole(UserRolesReqDto userRolesReqDto) {
        return usersRoleLogic.assignUserRole(userRolesReqDto);
     }
}
