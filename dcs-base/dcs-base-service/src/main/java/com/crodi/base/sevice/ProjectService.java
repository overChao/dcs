package com.crodi.base.sevice;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.crodi.base.ProjectApi;
import com.crodi.exception.DcsSystemException;
import com.crodi.exception.ExceptionConst;
import com.crodi.mapper.ProjectMapper;
import com.crodi.model.Project;
import com.crodi.model.entity.ProjectPO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
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
        Wrapper<ProjectPO> wrapper = new LambdaQueryWrapper<ProjectPO>()
                .eq(ProjectPO::getDeleted, Boolean.FALSE);
        List<ProjectPO> projects = projectMapper.selectList(wrapper);

        if (CollectionUtils.isEmpty(projects)) {
            throw new DcsSystemException(ExceptionConst.PROJECT_LIST_EMPTY);
        }

        return new ArrayList<>(projects);
    }

    @Override
    public Project getProject(String projectId) {
        ProjectPO project = new ProjectPO();
        project.setProjectId(projectId);
        return getProject(project);
    }

    @Override
    public Project getProject(Project req) {

        LambdaQueryWrapper<ProjectPO> wrapper = new LambdaQueryWrapper<ProjectPO>()
                .eq(ProjectPO::getDeleted, Boolean.FALSE);

        if (Objects.nonNull(req.getProjectId())) {
            wrapper.eq(Project::getProjectId, req.getProjectId());
        }

        if (Objects.nonNull(req.getProjectName())) {
            wrapper.like(Project::getProjectName, req.getProjectName());
        }

        wrapper.eq(ProjectPO::getDeleted, Boolean.FALSE);

        ProjectPO project = projectMapper.selectOne(wrapper);

        if (project == null) {
            throw new DcsSystemException(ExceptionConst.PROJECT_NOT_EXIST);
        }
        return project;
    }

    @Override
    public void createProject(Project project) {
        try {
            projectMapper.insert((ProjectPO) project);
        } catch (Exception e) {
            log.error(ExceptionConst.PROJECT_CREATE_FAILED, e);
            throw new DcsSystemException(ExceptionConst.PROJECT_CREATE_FAILED);
        }
    }

    @Override
    public void deleteProject(String projectId) {

        ProjectPO project = new ProjectPO();
        project.setDeleted(Boolean.TRUE);

        Wrapper<ProjectPO> wrapper = new LambdaQueryWrapper<ProjectPO>()
                .eq(ProjectPO::getProjectId, projectId)
                .eq(ProjectPO::getDeleted, Boolean.FALSE);
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

        Wrapper<ProjectPO> wrapper = new LambdaUpdateWrapper<ProjectPO>()
                .eq(ProjectPO::getProjectId, project.getProjectId())
                .eq(ProjectPO::getDeleted, Boolean.FALSE);

        try {
            projectMapper.update((ProjectPO) project, wrapper);
        } catch (Exception e) {
            log.error(ExceptionConst.PROJECT_UPDATE_FAILED, e);
            throw new DcsSystemException(ExceptionConst.PROJECT_UPDATE_FAILED);
        }
    }
}
