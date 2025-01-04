package com.example.projectManagement.entity;
import java.time.LocalDate;
import java.time.LocalDateTime;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @Data
@Table(name = "tasks")
public class Tasks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "taskId")
    private Long taskId;

    @ManyToOne
    @JoinColumn(name = "project_id", referencedColumnName = "projectId", nullable = false, foreignKey = @ForeignKey(name = "fk_task_project"))
    private Project project;

    @ManyToOne
    @JoinColumn(name = "assigned_to", referencedColumnName = "userId", foreignKey = @ForeignKey(name = "fk_task_user"))
    private Users assignedTo;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "priority", length = 20)
    private String priority; 

    @Column(name = "status", length = 20, columnDefinition = "VARCHAR(20) DEFAULT 'To Do'")
    private String status = "To Do"; 

    @Column(name = "storyPoint")
    private Integer storyPoint;

    @Column(name = "due_date")
    private LocalDate dueDate;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT NOW()")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT NOW()")
    private LocalDateTime updatedAt = LocalDateTime.now();

    
}
