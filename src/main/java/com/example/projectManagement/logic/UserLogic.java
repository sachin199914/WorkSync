package com.example.projectManagement.logic;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.projectManagement.dto.UserInfoDto;
import com.example.projectManagement.entity.UserRoles;
import com.example.projectManagement.entity.Users;
import com.example.projectManagement.repository.UserRepo;
import com.example.projectManagement.repository.UserRolesRepo;

@Component
public class UserLogic {

    @Autowired
    UserRepo userRepo;

    @Autowired
    UserRolesRepo userRolesRepo;

    @SuppressWarnings("deprecation")
    public UserInfoDto getUserAndRoleInfoByUserId(Long userId){
        UserInfoDto userInfoDto = new UserInfoDto();
        Users userInfo = userRepo.getById(userId);
        UserRoles userRoles = userRolesRepo.getUserRolesByUser(userInfo);
        userInfoDto.setUserName(userInfo.getUserName());
        userInfoDto.setEmail(userInfo.getEmail());
        userInfoDto.setRole(userRoles.getRole().getName());
        return userInfoDto;
    }


    public UserInfoDto getUserAndRoleInfoByUserEmail(String userEmail){
        UserInfoDto userInfoDto = new UserInfoDto();
        Users userInfo = userRepo.getByEmail(userEmail);
        UserRoles userRoles = userRolesRepo.getUserRolesByUser(userInfo);
        userInfoDto.setUserName(userInfo.getUserName());
        userInfoDto.setEmail(userInfo.getEmail());
        userInfoDto.setRole(userRoles.getRole().getName());
        return userInfoDto;
    }
}
