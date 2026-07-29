package com.crodi.model.task;

import com.crodi.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.Map;

/**
 * @Author: crodi.zhang
 * @Date: 2026/7/22 9:53
 * @Description: TODO
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class BusinessTicket extends BaseEntity {

    // 业务id
    private String businessId;

    // 起点
    private String start;

    // 目标点
    private String target;

    // 容器id
    private String containerId;

    // 业务优先级
    private String priority;

    // 业务来源
    /**
     * @see com.crodi.enums.BusinessSourceEnum
     */
    private String source;

    // 属性
    private Map<String, String> properties;

    // 请求时间
    private LocalDate requestDate;

}
