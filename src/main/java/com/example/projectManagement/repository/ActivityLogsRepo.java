package com.example.projectManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projectManagement.entity.ActivityLogs;


public interface ActivityLogsRepo extends JpaRepository<ActivityLogs, Long>{
    
}
