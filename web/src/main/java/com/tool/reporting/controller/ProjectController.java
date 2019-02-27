package com.tool.reporting.controller;

import com.tool.reporting.entity.Project;
import com.tool.reporting.service.*;
import com.tool.reporting.util.ProjectMapping;
import com.tool.reporting.util.ViewName;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
public class ProjectController {
    private ProjectService projectService;
    private GroupsService groupService;
    private EmployeeService employeeService;
    private HealthService healthService;
    private StatusService statusService;
    private StrategyService strategyService;


    public ProjectController(ProjectService projectService,
                             GroupsService groupService,
                             EmployeeService employeeService,
                             HealthService healthService,
                             StatusService statusService,
                             StrategyService strategyService) {
        this.projectService = projectService;
        this.groupService = groupService;
        this.employeeService = employeeService;
        this.healthService = healthService;
        this.statusService = statusService;
        this.strategyService = strategyService;
    }

    @ModelAttribute
    public void invokeDefaultParameters(Model model) {
        log.info("ProjectController: invokeDefaultParameters(): method called");
        model.addAttribute("groups", groupService.getAllGroups());
        model.addAttribute("approvers", employeeService.getAllEmployees());
        model.addAttribute("status", statusService.getAllStatus());
        model.addAttribute("healths", healthService.getAllHealths());
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
    public String editProject(Model model, @RequestParam(value = "id", required = false) Integer id) {
        if(id != null) {
            Optional<Project> optional = projectService.getProjectById(new Long(id));
            model.addAttribute("project", optional.get());
        }
        else {
            model.addAttribute("project", new Project());
        }
        return ViewName.ADD_PROJECT;
    }
}
