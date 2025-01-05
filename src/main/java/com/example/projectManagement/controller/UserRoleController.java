package com.example.projectManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.projectManagement.dto.UserRolesReqDto;
import com.example.projectManagement.entity.UserRoles;
import com.example.projectManagement.service.UserRoleService;

@RestController
@RequestMapping("/api/userRoles")
public class UserRoleController {

    @Autowired
    UserRoleService userRoleService;
    
    @PostMapping("/assign")
    public ResponseEntity<String> assignUserRole(@RequestBody UserRolesReqDto userRoleDto) { 
        UserRoles userRoles = userRoleService.assignUserRole(userRoleDto);
        if(userRoles != null)
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("User Role Assigned");
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User or Role not found");
        
    }
}
