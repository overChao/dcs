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
1. 项目编码唯一，项目名称唯一,项目描述可选。
2. 项目下可以有多个仓库
3. 


- 仓库管理
1. 系统启动加载默认仓库信息，仓库信息为空，初始化默认仓库信息并激活。
2. 允许多仓库, 通过激活字段控制是否生效，默认仓库默认激活。
3. 仓库初始化, 





- 接口设计
1. /base/** 基础信息管理接口
2. /task/** 任务相关
3. 



