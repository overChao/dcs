package com.crodi.sevice;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.crodi.base.ProjectApi;
import com.crodi.exception.DcsSystemException;
import com.crodi.exception.ExceptionConst;
import com.crodi.mapper.ProjectMapper;
import com.crodi.model.Project;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

/**
 * @Author: crodi.zhang
 * @Date: 2026/9/1 14:07
 * @Description: TODO
 **/

@Slf4j
@Service
@RequiredArgsConstructor
public class ProjectService implements ProjectApi {

    private final ProjectMapper projectMapper;

    @Override
    public List<Project> getProjects() {
        Wrapper<Project> wrapper = new LambdaQueryWrapper<Project>()
                .eq(Project::getDeleted, Boolean.FALSE);
        List<Project> projects = projectMapper.selectList(wrapper);

        if (CollectionUtils.isEmpty(projects)) {
            throw new DcsSystemException(ExceptionConst.PROJECT_LIST_EMPTY);
        }

        return projects;
    }

    @Override
    public Project getProject(String projectId) {
        Project project = new Project();
        project.setProjectId(projectId);
        return getProject(project);
    }

    @Override
    public Project getProject(Project req) {

        LambdaQueryWrapper<Project> wrapper = new LambdaQueryWrapper<Project>()
                .eq(Project::getDeleted, Boolean.FALSE);



        if (Objects.nonNull(req.getProjectId())) {
            wrapper.eq(Project::getProjectId, req.getProjectId());
        }

        if (Objects.nonNull(req.getProjectName())) {
            wrapper.like(Project::getProjectName, req.getProjectName());
        }

        wrapper.eq(Project::getDeleted, Boolean.FALSE);

        Project project = projectMapper.selectOne(wrapper);

        if (project == null) {
            throw new DcsSystemException(ExceptionConst.PROJECT_NOT_EXIST);
        }
        return project;
    }

    @Override
    public void createProject(Project project) {
        try {
            projectMapper.insert(project);
        } catch (Exception e) {
            log.error(ExceptionConst.PROJECT_CREATE_FAILED, e);
            throw new DcsSystemException(ExceptionConst.PROJECT_CREATE_FAILED);
        }
    }

    @Override
    public void deleteProject(String projectId) {

        Project project = new Project();
        project.setDeleted(Boolean.TRUE);

        Wrapper<Project> wrapper = new LambdaQueryWrapper<Project>()
                .eq(Project::getProjectId, projectId)
                .eq(Project::getDeleted, Boolean.FALSE);
        try {
            projectMapper.update(project, wrapper);
        } catch (Exception e) {
            log.error(ExceptionConst.PROJECT_DELETE_FAILED, e);
            throw new DcsSystemException(ExceptionConst.PROJECT_DELETE_FAILED);
        }

    }

    @Override
    public void updateProject(Project project) {

        if (Objects.isNull(project)) {
            throw new DcsSystemException(ExceptionConst.REQUEST_PARAM_NOT_NULL);
        }

        if (Objects.isNull(project.getProjectId())) {
            throw new DcsSystemException(ExceptionConst.PROJECT_ID_NOT_NULL);
        }

        Wrapper<Project> wrapper = new LambdaUpdateWrapper<Project>()
                .eq(Project::getProjectId, project.getProjectId())
                .eq(Project::getDeleted, Boolean.FALSE);

        try {
            projectMapper.update(project, wrapper);
        } catch (Exception e) {
            log.error(ExceptionConst.PROJECT_UPDATE_FAILED, e);
            throw new DcsSystemException(ExceptionConst.PROJECT_UPDATE_FAILED);
        }
    }
}
