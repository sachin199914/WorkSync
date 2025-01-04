package com.example.projectManagement.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @Data
@Table(name = "user_roles")
public class UserRoles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userId", nullable = false, foreignKey = @ForeignKey(name = "fk_user"))
    private Users user;

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "roleId", nullable = false, foreignKey = @ForeignKey(name = "fk_role"))
    private Roles role;
}