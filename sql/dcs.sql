create database if not exists dcs;

create table dcs_project
(
    id           int auto_increment comment '主键标识'
        primary key,
    project_id   varchar(32) not null comment '项目id',
    project_name varchar(32) null comment '项目名称',
    project_desc text        null comment '项目描述',

    is_active    char        not null default '0' comment '是否激活',
    created_by   varchar(32) not null default 'admin' comment '创建人',
    created_time datetime    not null default CURRENT_TIMESTAMP comment '创建时间',
    updated_by   varchar(32) not null default 'admin' comment '更新人',
    updated_time datetime    not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment '更新时间',
    is_deleted   char        not null default '0' comment '删除标志',
    constraint uk_project_id unique key (project_id)
) comment '项目' row_format = DYNAMIC;


-- dcs 基础数据
create table dcs_warehouse
(
    id             int auto_increment comment '主键标识'
        primary key,
    warehouse_id   varchar(32) not null comment '仓库id',
    warehouse_name varchar(32) null comment '仓库名称',
    project_id     varchar(32) not null comment '项目id',
    is_active      char        not null default '0' comment '是否激活',

    created_by     varchar(32) not null default 'admin' comment '创建人',
    created_time   datetime    not null default CURRENT_TIMESTAMP comment '创建时间',
    updated_by     varchar(32) not null default 'admin' comment '更新人',
    updated_time   datetime    not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment '更新时间',
    is_deleted     char        not null default '0' comment '删除标志',
    constraint uk_warehouse_id unique key (warehouse_id)
) comment '仓库' row_format = DYNAMIC;


create table dcs_map
(
    id           int auto_increment comment '主键标识'
        primary key,
    warehouse_id varchar(32) not null comment '仓库id',
    map_code     varchar(32) not null comment '地图编码',
    map_name     varchar(32) null comment '地图名称',
    layer_no     varchar(32) not null default '1' comment '图层',
    floor_no     varchar(32) not null default '1' comment '楼层',
    is_active    char        not null default '1' comment '是否激活',

    created_by   varchar(32) not null default 'admin' comment '创建人',
    created_time datetime    not null default CURRENT_TIMESTAMP comment '创建时间',
    updated_by   varchar(32) not null default 'admin' comment '更新人',
    updated_time datetime    not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment '更新时间',
    is_deleted   char        not null default '0' comment '删除标志',
    constraint uk_map_code unique key (map_code)
) comment '地图' row_format = DYNAMIC;

create table dcs_node
(
    id           int auto_increment comment '主键标识'
        primary key,
    warehouse_id varchar(32) not null comment '仓库id',
    map_code     varchar(32) not null comment '地图编码',
    node_code    varchar(32) not null comment '节点编码',
    node_type    varchar(32) not null default 1 comment '节点类型: 1 路由点 2 工作点',
    x            int         not null comment 'x坐标',
    y            int         not null comment 'y坐标',
    z            int         not null comment 'z坐标',
    cow_no       int         not null comment '行',
    col_no       int         not null comment '列',
    level_no     int         not null comment '层',
    device_types json        null comment '设备类型',
    is_active    char        not null default '1' comment '是否激活',

    created_by   varchar(32) not null default 'admin' comment '创建人',
    created_time datetime    not null default CURRENT_TIMESTAMP comment '创建时间',
    updated_by   varchar(32) not null default 'admin' comment '更新人',
    updated_time datetime    not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment '更新时间',
    is_deleted   char        not null default '0' comment '删除标志',
    constraint uk_node_code unique key (node_code)
) comment '节点' row_format = DYNAMIC;


create table dcs_edge
(
    id           int auto_increment comment '主键标识'
        primary key,
    map_code     varchar(32) not null comment '地图编码',
    edge_id      varchar(32) not null comment '边id',
    from_node    varchar(32) not null comment '起点',
    to_node      varchar(32) not null comment '终点',
    direction    char        not null default '0' comment '方向 0:无向边 1:from -> to 2:to -> from',
    edge_type    char        not null default '1' comment '边类型 1 直线 2 曲线(默认贝塞尔曲线, 定义控制点)',
    is_active    char        not null default '1' comment '是否激活',

    created_by   varchar(32) not null default 'admin' comment '创建人',
    created_time datetime    not null default CURRENT_TIMESTAMP comment '创建时间',
    updated_by   varchar(32) not null default 'admin' comment '更新人',
    updated_time datetime    not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment '更新时间',
    is_deleted   char        not null default '0' comment '删除标志',
    constraint uk_edge_id unique key (edge_id)
) comment '边' row_format = DYNAMIC;


create table dcs_edge_constraint
(
    id           int auto_increment comment '主键标识'
        primary key,
    edge_id      varchar(32) not null comment '边id',
    from_size    int         not null default -1 comment '起点边界;起点边界距离（单位mm）-1默认不限制',
    to_size      int         not null default -1 comment '终点边界;终点边界距离（单位mm）-1默认不限制',
    left_size    int         not null default -1 comment '左边界;to朝向左边边界距离（单位mm）-1默认不限制',
    right_size   int         not null default -1 comment '右边界;to朝向右边边界距离（单位mm）-1默认不限制',
    limit_height int         not null default -1 comment '限高;道路限高（单位mm） -1默认不限高',
    limit_weight int         not null default -1 comment '限重;道路限重（单位g）-1默认不限重',
    limit_speed  int         not null default -1 comment '限速;限速（单位mm/ms）-1默认不限速',
    is_active    char        not null default '1' comment '是否激活',

    created_by   varchar(32) not null default 'admin' comment '创建人',
    created_time datetime    not null default CURRENT_TIMESTAMP comment '创建时间',
    updated_by   varchar(32) not null default 'admin' comment '更新人',
    updated_time datetime    not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment '更新时间',
    is_deleted   char        not null default '0' comment '删除标志',
    constraint uk_edge_id unique key (edge_id)
) comment '边约束' row_format = DYNAMIC;



create table dcs_container
(
    id             int auto_increment comment '主键标识'
        primary key,
    container_code varchar(32) not null comment '容器编码',
    node_code      varchar(32) not null comment '节点编码',
    map_code       varchar(32) not null comment '地图编码',
    device_code    varchar(32) not null default -1 comment '设备编码',
    length         int         not null default -1 comment '长',
    width          int         not null default -1 comment '宽',
    height         int         not null default -1 comment '高',
    weight         int         not null default -1 comment '重量',
    is_active      char        not null default '1' comment '是否激活',

    created_by     varchar(32) not null default 'admin' comment '创建人',
    created_time   datetime    not null default CURRENT_TIMESTAMP comment '创建时间',
    updated_by     varchar(32) not null default 'admin' comment '更新人',
    updated_time   datetime    not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment '更新时间',
    is_deleted     char        not null default '0' comment '删除标志',
    constraint uk_container_code unique key (container_code)
) comment '容器' row_format = DYNAMIC;
