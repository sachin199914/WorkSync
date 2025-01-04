package com.example.projectManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projectManagement.entity.FileAttachments;

public interface FileAttachmentsRepo extends JpaRepository<FileAttachments, Long> {
    
}
