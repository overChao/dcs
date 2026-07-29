package com.crodi.base;

import com.crodi.model.Container;

import java.util.List;

/**
 * @Author: crodi.zhang
 * @Date: 2026/7/29 9:54
 * @Description: TODO
 **/
public interface ContainerApi {

    /**
     * 保存容器
     *
     * @param container 容器
     */
    void saveContainer(Container container);

    /**
     * 删除容器
     *
     * @param container 容器
     */
    void deleteContainer(Container container);

    /**
     * 更新容器
     *
     * @param container 容器
     */
    void updateContainer(Container container);

    /**
     * 获取容器
     *
     * @param nodeCode 节点编码
     * @return 容器
     */
    Container getContainer(String nodeCode);

    /**
     * 获取所有容器
     *
     * @return 容器集合
     */
    List<Container> getAllContainers(String mapCode);
}
