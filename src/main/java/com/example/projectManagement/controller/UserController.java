package com.example.projectManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.projectManagement.dto.UserDto;
import com.example.projectManagement.dto.UserInfoDto;
import com.example.projectManagement.entity.Users;
import com.example.projectManagement.service.UserService;


@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/helloWorld")
    public ResponseEntity<String> helloWorld() {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Hi it's working");
    }

    @GetMapping("/{id}")
    public UserInfoDto getUserByUserId(@PathVariable Long id) {
        return userService.getUserAndRoleInfoByUserId(id);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody UserDto user) { 
        Users users = userService.createUser(user);
        System.out.println(user.getEmail());
        if(users != null){
            return ResponseEntity.status(HttpStatus.CREATED).body("User Created");
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User not Created");
        }
    }


}
