package com.crodi.initiator;

import com.crodi.base.ProjectApi;
import com.crodi.model.Project;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @Author: crodi.zhang
 * @Date: 2026/8/12 20:23
 * @Description: TODO
 **/

@Component
@RequiredArgsConstructor
public class DcsInitializer {


    private String projectId;


    private final ProjectApi  projectApi;


    // 初始化项目
    //  1. 加载仓库地图
    //  2. 加载设备
    //  3. 启动调度器


    public void initProject() {
        Project project = projectApi.getProject(projectId);
        if (Objects.isNull(project)) {
            return;
        }

        setProjectId(projectId);


    }


    private void setProjectId(String projectId) {
        this.projectId = projectId;
    }


}
