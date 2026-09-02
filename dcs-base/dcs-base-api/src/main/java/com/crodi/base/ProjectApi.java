package com.crodi.base;

import com.crodi.model.Project;

import java.util.List;

/**
 * @Author: crodi.zhang
 * @Date: 2026/9/1 14:03
 * @Description: TODO
 **/
public interface ProjectApi {

    /**
     * 获取项目列表
     *
     * @return 项目列表
     */
    List<Project> getProjects();

    /**
     * 通过项目id 获取项目详情
     *
     * @param projectId
     * @return
     */
    Project getProject(String projectId);

    /**
     * 获取项目详情
     *
     * @param req 项目实体
     * @return 项目详情
     */
    Project getProject(Project req);

    /**
     * 创建项目
     *
     * @param project 项目实体
     */
    void createProject(Project project);

    /**
     * 删除项目
     *
     * @param projectId 项目编码
     */
    void deleteProject(String projectId);

    /**
     * 更新项目
     *
     * @param project 项目实体
     */
    void updateProject(Project project);
}
