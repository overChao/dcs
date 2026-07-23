package com.crodi.model.task;

import lombok.Data;

import java.time.LocalDate;
import java.util.Map;

/**
 * @Author: crodi.zhang
 * @Date: 2026/7/22 9:53
 * @Description: TODO
 **/
@Data
public class BusinessTicket {

    // 起点
    private String start;

    // 目标点
    private String target;

    // 容器id
    private String containerId;

    // 业务优先级
    private String priority;

    // 属性
    private Map<String, String> properties;

    // 下发时间
    private LocalDate createTime;

}
