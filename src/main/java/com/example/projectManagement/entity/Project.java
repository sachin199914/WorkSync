package com.example.projectManagement.entity;
import java.time.LocalDateTime;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @Data
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "projectId")
    private Long projectId;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "status", length = 20, nullable = false)
    private String status ;

    @ManyToOne
    @JoinColumn(name = "created_by", referencedColumnName = "userId", nullable = true)
    private Users createdBy;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
