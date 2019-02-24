package com.tool.reporting.controller;

import com.tool.reporting.entity.Project;
import com.tool.reporting.service.ProjectService;
import com.tool.reporting.util.ProjectMapping;
import com.tool.reporting.util.ViewName;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
public class ProjectController {
    private ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping(ProjectMapping.HOME_PAGE)
    public String home() {
        return ViewName.HOME;
    }

    @GetMapping(ProjectMapping.VIEW_PROJECTS)
    public String viewProjects(Model model) {
        log.info("ProjectController: viewProjects(): method called");

        List<Project> projects = projectService.getAllProjects();
        model.addAttribute("projects", projects);

        return ViewName.VIEW_PROJECTS;
    }

    @GetMapping(ProjectMapping.ADD_OPEN_PROJECT)
    public String editProject(Model model, @RequestParam(value = "id", required = false) int id) {
        if(id != 0) {
            Optional<Project> optional = projectService.getProjectById(new Long(id));
            model.addAttribute("project", optional.get());
        }
        else {
            model.addAttribute("project", new Project());
        }
        return ViewName.ADD_PROJECT;
    }
}
