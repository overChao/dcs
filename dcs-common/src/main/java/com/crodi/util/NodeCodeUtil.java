package com.crodi.util;

import com.crodi.model.graph.Node;

/**
 * @Author: crodi.zhang
 * @Date: 2026/9/11
 * @Description: NodeCode 工具类，格式为 mapCode-cowNocolNolevelNo，数字部分1位前补0
 **/
public final class NodeCodeUtil {

    private NodeCodeUtil() {
    }

    /**
     * 生成 nodeCode
     *
     * @param mapCode  地图编码
     * @param cowNo    行号
     * @param colNo    列号
     * @param levelNo  层号
     * @return nodeCode，格式：mapCode-cowNocolNolevelNo（数字不足2位前补0）
     */
    public static String generate(String mapCode, int cowNo, int colNo, int levelNo) {
        return String.format("%s-%02d%02d%02d", mapCode, cowNo, colNo, levelNo);
    }

    /**
     * 根据 Node 对象生成 nodeCode
     *
     * @param node Node 对象
     * @return nodeCode
     */
    public static String generate(Node node) {
        if (node == null) {
            throw new IllegalArgumentException("node must not be null");
        }
        return generate(node.getMapCode(), node.getCowNo(), node.getColNo(), node.getLevelNo());
    }

    /**
     * 解析 nodeCode 中的 mapCode（第一段）
     */
    public static String getMapCode(String nodeCode) {
        return split(nodeCode)[0];
    }

    /**
     * 解析 nodeCode 中的 cowNo（第二段）
     */
    public static int getCowNo(String nodeCode) {
        return Integer.parseInt(split(nodeCode)[1]);
    }

    /**
     * 解析 nodeCode 中的 colNo（第三段）
     */
    public static int getColNo(String nodeCode) {
        return Integer.parseInt(split(nodeCode)[2]);
    }

    /**
     * 解析 nodeCode 中的 levelNo（第四段）
     */
    public static int getLevelNo(String nodeCode) {
        return Integer.parseInt(split(nodeCode)[3]);
    }

    private static String[] split(String nodeCode) {
        if (nodeCode == null || nodeCode.isBlank()) {
            throw new IllegalArgumentException("nodeCode must not be null or blank");
        }
        String[] parts = nodeCode.split("-");
        if (parts.length != 4) {
            throw new IllegalArgumentException("invalid nodeCode format: " + nodeCode);
        }
        return parts;
    }
}
