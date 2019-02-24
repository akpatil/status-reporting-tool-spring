package com.tool.reporting;

import com.tool.reporting.entity.Project;
import com.tool.reporting.service.ProjectService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringCoreApplication.class)
public class ProjectServiceTest {

    private static final Logger log = LoggerFactory.getLogger(ProjectServiceTest.class);

    @Autowired
    private ProjectService projectService;

    @Test
    public void saveProjectTest() {
        Project project = new Project();
        project.setName("Doomsday");
        project.setDescription("A top secret project led by William Birkins");
        project.setSummary("Classified");
        project.setBudgetCost(1000D);
        project.setActualCost(1011D);
        project.setForecastedCost(1500D);
        project.setImplementationDate(LocalDateTime.now());
        project.setMilestoneDate(LocalDateTime.now());
        //project.setMilestoneStatus(1);

        projectService.saveProject(project);
        Project projectRetrieved = projectService.getProjectByName("Doomsday");
        log.info("Retrieved Project {}", project.toString());
        Assert.assertEquals(projectRetrieved, project);
    }

    @Test
    @DirtiesContext
    public void updateProject() {
        log.info("ProjectServiceTest: updateProject() method called");
        Optional<Project> optional = projectService.getProjectById(100L);
        if(optional.isPresent()) {
            log.info("ProjectServiceTest: updateProject(): Found project with id {}", 100L);
            Project p1 = optional.get();
            p1.setName("Updated project name");
            projectService.saveProject(p1);

            optional = projectService.getProjectById(100L);
            log.info("ProjectServiceTest: updateProject(): Found Project {}", optional.get());
            Assert.assertEquals(optional.get().getName(), "Updated project name");
        }
        else {
            log.info("ProjectServiceTest: updateProject(): No project found with id {}", 100L);
        }
    }

    @Test
    @DirtiesContext
    public void deleteProject() {
        log.info("ProjectServiceTest: deleteProject(): method called");
        projectService.deleteProjectById(100L);

        Optional<Project> optional = projectService.getProjectById(100L);
        if(optional.isPresent()) {
            log.info("ProjectServiceTest: deleteProject(): is_delete property: {}", optional.get().isDeleted());
            Assert.assertEquals(true, optional.get().isDeleted());
        }
        else {
            log.info("ProjectServiceTest: deleteProject(): No Project found");
        }
    }
}
