package com.crodi.base;

import com.crodi.model.graph.Node;

import java.util.List;

/**
 * @Author: crodi.zhang
 * @Date: 2026/9/3 17:03
 * @Description: TODO
 **/
public interface NodeApi {

    /**
     * 创建节点
     *
     * @param node 节点
     */
    void createNode(Node node);

    /**
     * 更新节点
     *
     * @param node 节点
     */
    void updateNode(Node node);

    /**
     * 删除节点
     *
     * @param nodeCode 节点编码
     */
    void deleteNode(String nodeCode);

    /**
     * 根据节点编码查询节点
     *
     * @param nodeCode 节点编码
     * @return 节点
     */
    Node getNode(String nodeCode);

    /**
     * 根据地图编码查询节点列表
     *
     * @param mapCode 地图编码
     * @return 节点列表
     */
    List<Node> getNodes(String mapCode);


}
