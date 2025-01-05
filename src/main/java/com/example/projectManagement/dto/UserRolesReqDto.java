package com.example.projectManagement.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data @Getter @Setter
public class UserRolesReqDto {
    private Long userId;  
    private String roleName;
}
