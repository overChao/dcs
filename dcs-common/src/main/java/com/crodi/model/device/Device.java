package com.crodi.model.device;

import lombok.Data;

/**
 * @Author: crodi.zhang
 * @Date: 2026/7/22 15:00
 * @Description: TODO
 **/
@Data
public class Device {

    private String deviceId;

    private String deviceName;

    private String deviceType;

    private String ip;

    private String port;

}
