package com.example.projectManagement.entity;

import java.time.LocalDateTime;



import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @Data
@Table(name = "comments")
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commentId")
    private Long commentId;

    @ManyToOne
    @JoinColumn(name = "task_id", referencedColumnName = "taskId", nullable = false, foreignKey = @ForeignKey(name = "fk_comment_task"))
    private Tasks task;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userId", foreignKey = @ForeignKey(name = "fk_comment_user"))
    private Users user;

    @Column(name = "comment_text", nullable = false)
    private String commentText;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT NOW()")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT NOW()")
    private LocalDateTime updatedAt = LocalDateTime.now();
}
