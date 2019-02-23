package com.tool.reporting.repository;

import com.tool.reporting.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    public Project findByName(String name);
}
