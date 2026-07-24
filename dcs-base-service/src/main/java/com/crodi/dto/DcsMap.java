package com.crodi.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import com.crodi.model.graph.Map;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: crodi.zhang
 * @Date: 2026/7/24 13:40
 * @Description: TODO
 **/

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("dcs_map")
public class DcsMap extends Map {


}
