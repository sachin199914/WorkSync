package com.example.projectManagement.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectManagement.dto.UserDto;
import com.example.projectManagement.dto.UserInfoDto;
import com.example.projectManagement.entity.Users;
import com.example.projectManagement.logic.UserLogic;
import com.example.projectManagement.repository.UserRepo;

@Service
public class UserService {
   
    @Autowired
    UserLogic userLogic;

    @Autowired
    UserRepo userRepo;
    
    public UserInfoDto getUserAndRoleInfoByUserId(Long id) {
        return userLogic.getUserAndRoleInfoByUserId(id);
    }

    public Users createUser(UserDto userDto) {
        Users user =  new Users();
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setUserName(userDto.getUserName());
        return userRepo.save(user);
    }

    public UserInfoDto getUserAndRoleInfoByUserEmail(String userEmail) {
        return userLogic.getUserAndRoleInfoByUserEmail(userEmail);
    }



}
