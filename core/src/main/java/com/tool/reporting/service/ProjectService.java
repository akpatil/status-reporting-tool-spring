package com.tool.reporting.service;

import com.tool.reporting.entity.Project;
import com.tool.reporting.repository.ProjectRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public void saveProject(Project project) {
        log.info("ProjectService: saveProject() method called");
        log.info("Project: {}", project);
        projectRepository.save(project);
    }

    public void getAllProjects() {
        log.info("ProjectService: findAllProjects() method called");
        List<Project> projects = projectRepository.findAll();
        log.info("Projects List: {}", projects.toString());
    }

    public Optional<Project> getProjectById(Long id) {
        log.info("ProjectService: findById() method called");
        Optional<Project> project = projectRepository.findById(id);
        return project;
    }

    public Project getProjectByName(String name) {
        log.info("ProjectService: getProjectByName() method called");
        Project project = projectRepository.findByName(name);
        log.info("Project fetched: {}", project);
        return project;
    }

    public void deleteProjectById(Long id) {
        log.info("ProjectService: deleteById(): method called");
        projectRepository.deleteById(id);
    }
}
