package com.example.projectManagement.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data @Getter @Setter
public class UserInfoDto {
    private String userName;
    private String email;
    private String role;
}
