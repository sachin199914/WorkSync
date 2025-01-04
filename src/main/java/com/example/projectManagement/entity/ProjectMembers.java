package com.example.projectManagement.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @Data
@Table(name = "project_members")
public class ProjectMembers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "project_id", referencedColumnName = "projectId", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "fk_project"))
    private Project project;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userId", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "fk_user"))
    private Users user;
    
}
