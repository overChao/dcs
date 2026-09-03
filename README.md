# device control system 

## Overview
The device control system is a software application designed to manage and control various devices within a network.






## Modules
- dcs-base : the base module that contains common classes and interfaces for the system.

- dcs-core
- dcs-starter
- dcs-simulator
- dcs-map-service
- dcs-web





## issues
- [ ] 基础信息管理接口
  - [ ] 仓库管理接口
    - [ ] 仓库初始化
- [ ] 设备管理接口
- [ ] 地图服务接口
- [ ] 网络管理接口
- [ ] 系统配置接口
- [ ] 用户管理接口



## design

### 基础信息维护及管理
- 项目管理
1. 项目编码全局唯一,项目描述可选。
2. 项目下可以有多个仓库
3. 系统启动，默认加载所有项目信息, 若无项目，默认跳转创建项目页面

- 仓库管理
1. 仓库编码全局唯一,仓库描述可选。
2. 一个项目允许多仓库
3. 初始化仓库时必须先指定激活的项目编码

- 地图管理
1. 地图编码全局唯一
2. 一个仓库可以有多个地图
3. 初始化地图时必须先指定激活的仓库编码



- 接口设计
1. /base/** 基础信息管理接口
2. /task/** 任务相关
3. /map/** 地图服务接口

---



