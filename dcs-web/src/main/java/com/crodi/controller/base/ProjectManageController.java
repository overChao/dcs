package com.crodi.controller.base;

import com.crodi.base.ProjectApi;
import com.crodi.exception.DcsSystemException;
import com.crodi.model.Project;
import com.crodi.sys.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: crodi.zhang
 * @Date: 2026/9/2 13:08
 * @Description: 项目管理接口
 **/
@RestController
@RequestMapping("/base/project")
@RequiredArgsConstructor
public class ProjectManageController {

    private final ProjectApi projectApi;

    @GetMapping("/getProjects")
    public Result<?> getProjects() {
        try {
            List<Project> projects = projectApi.getProjects();
            return Result.success(projects);
        } catch (DcsSystemException e) {
            return Result.error(e.getMessage());
        }
    }

    @GetMapping("/getProject")
    public Result<?> getProject(@RequestParam("projectId") String projectId) {
        try {
            Project project = projectApi.getProject(projectId);
            return Result.success(project);
        } catch (DcsSystemException e) {
            return Result.error(e.getMessage());
        }
    }


    @PostMapping("/createProject")
    public Result<?> createProject(@RequestBody Project project) {
        try {
            projectApi.createProject(project);
            return Result.ok();
        } catch (DcsSystemException e) {
            return Result.error(e.getMessage());
        }
    }

    @GetMapping("/deleteProject")
    public  Result<?> deleteProject(@RequestParam("projectId") String projectId) {
        try {
            projectApi.deleteProject(projectId);
            return  Result.ok();
        }catch (DcsSystemException e){
            return Result.error(e.getMessage());
        }
    }


    @PostMapping("/updateProject")
    public Result<?> updateProject(@RequestBody Project project) {
        try {
            projectApi.updateProject(project);
            return Result.ok();
        } catch (DcsSystemException e) {
            return Result.error(e.getMessage());
        }
    }

}
