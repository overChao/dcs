package com.crodi.sevice;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.crodi.base.ProjectApi;
import com.crodi.mapper.ProjectMapper;
import com.crodi.model.Project;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: crodi.zhang
 * @Date: 2026/9/1 14:07
 * @Description: TODO
 **/
@Service
@RequiredArgsConstructor
public class ProjectService implements ProjectApi {

    private final ProjectMapper projectMapper;

    @Override
    public List<Project> getProjects() {
        Wrapper<Project> wrapper = new LambdaQueryWrapper<Project>()
                .eq(Project::isDeleted, Boolean.FALSE);
        return projectMapper.selectList(wrapper);
    }

    @Override
    public Project getProject(String projectId) {
        Wrapper<Project> wrapper = new LambdaQueryWrapper<Project>()
                .eq(Project::getProjectId, projectId)
                .eq(Project::isDeleted, Boolean.FALSE);
        return projectMapper.selectOne(wrapper);
    }

    @Override
    public void createProject(Project project) {
        projectMapper.insert(project);
    }

    @Override
    public void deleteProject(String projectId) {

        Project project = new Project();
//        project.setProjectId(projectId);
        project.setDeleted(Boolean.TRUE);

        Wrapper<Project> wrapper = new LambdaQueryWrapper<Project>()
                .eq(Project::getProjectId, projectId)
                .eq(Project::isDeleted, Boolean.FALSE);

        projectMapper.update(project, wrapper);
    }

    @Override
    public void updateProject(Project project) {

        Wrapper<Project> wrapper = new LambdaUpdateWrapper<Project>()
                .eq(Project::getProjectId, project.getProjectId())
                .eq(Project::isDeleted, Boolean.FALSE);

        projectMapper.update(project, wrapper);
    }
}
