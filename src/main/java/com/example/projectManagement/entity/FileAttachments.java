package com.example.projectManagement.entity;

import java.time.LocalDateTime;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @Data
@Table(name = "file_attachments")
public class FileAttachments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "task_id", referencedColumnName = "taskId", nullable = false, foreignKey = @ForeignKey(name = "fk_file_attachment_task"))
    private Tasks task;

    @Column(name = "file_name", length = 255)
    private String fileName;

    @Column(name = "file_path", columnDefinition = "TEXT")
    private String filePath;

    @ManyToOne
    @JoinColumn(name = "uploaded_by", referencedColumnName = "userId", foreignKey = @ForeignKey(name = "fk_file_attachment_user"))
    private Users uploadedBy;

    @Column(name = "uploaded_at", columnDefinition = "TIMESTAMP DEFAULT NOW()")
    private LocalDateTime uploadedAt = LocalDateTime.now();
    
}
