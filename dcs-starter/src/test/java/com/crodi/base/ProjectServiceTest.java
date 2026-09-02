package com.crodi.base;

import com.crodi.model.Project;
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
    private ProjectApi projectApi;


    @Test
    public void testCreateProject() {

        Project project = new Project();
        project.setProjectId("HL5174");
        project.setProjectName("华联瓷业");

        projectApi.createProject(project);
    }


    @Test
    public void testGetProject() {
        Project project = projectApi.getProject("HL5174");
        System.out.println(project);
    }


    @Test
    public void testUpdateProject() {
        Project project = new Project();
        project.setProjectId("HL5174");
        project.setProjectDesc("华联瓷业 314新质生产基地");
        projectApi.updateProject(project);
        System.out.println(project);
    }


    @Test
    public void testDeleteProject() {
        projectApi.deleteProject("HL5174");
    }
}
