package com.tool.reporting.console;

import com.tool.reporting.entity.Project;
import com.tool.reporting.service.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
public class ProjectTrackingTool {

    @Autowired
    private ProjectService projectService;

    @EventListener(ContextRefreshedEvent.class)
    public void start() {
        log.info("Console: EventListener is running...");

        /*Project project = new Project();
        project.setName("Dummy Project");
        projectService.saveProject(project);
        projectService.getAllProjects();*/

        projectService.deleteProjectById(100L);

        Optional<Project> optional = projectService.getProjectById(100L);
        if(optional.isPresent()) {
            log.info("is_delete property: {}", optional.get().isDeleted());
        }
        else {
            log.info("No Project found");
        }
    }
}
