package com.crodi.base;

import com.crodi.model.Project;
import com.crodi.sevice.ProjectService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: crodi.zhang
 * @Date: 2026/9/1 14:23
 * @Description: TODO
 **/

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProjectServiceTest {


    @Autowired
    private ProjectService projectService;


    @Test
    public void testCreateProject() {

        Project project = new Project();
        project.setProjectId("HL5174");
        project.setProjectName("华联瓷业");

        projectService.createProject(project);
    }


    @Test
    public void testGetProject() {
        Project project = projectService.getProject("HL5174");
        System.out.println(project);
    }


    @Test
    public void testUpdateProject() {
        Project project = new Project();
        project.setProjectId("HL5174");
        project.setProjectDesc("华联瓷业 314新质生产基地");
        projectService.updateProject(project);
        System.out.println(project);
    }


    @Test
    public void testDeleteProject() {
        projectService.deleteProject("HL5174");
    }
}
