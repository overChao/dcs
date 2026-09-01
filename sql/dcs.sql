create database if not exists dcs;

create table dcs_project
(
    id           int auto_increment comment '主键标识'
        primary key,

    project_id   varchar(32)                           not null comment '项目id',
    project_name varchar(32)                           null comment '项目名称',
    project_desc text                                  null comment '项目描述',

    is_active    char        default '0'               not null comment '是否激活',
    created_by   varchar(32) default 'admin'           not null comment '创建人',
    created_time datetime    default CURRENT_TIMESTAMP not null comment '创建时间',
    updated_by   varchar(32) default 'admin'           not null comment '更新人',
    updated_time datetime    default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    is_deleted   char        default '0'               not null comment '删除标志',

    constraint uk_project_id unique key (project_id)
) comment '项目' row_format = DYNAMIC;


-- dcs 基础数据
create table dcs_warehouse
(
    id             int auto_increment comment '主键标识'
        primary key,

    warehouse_id   varchar(32)                           not null comment '仓库id',
    warehouse_name varchar(32)                           null comment '仓库名称',
    is_active      char        default '0'               not null comment '是否激活',

    project_id     varchar(32)                           not null comment '项目id',

    created_by     varchar(32) default 'admin'           not null comment '创建人',
    created_time   datetime    default CURRENT_TIMESTAMP not null comment '创建时间',
    updated_by     varchar(32) default 'admin'           not null comment '更新人',
    updated_time   datetime    default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    is_deleted     char        default '0'               not null comment '删除标志',

    constraint uk_warehouse_id unique key (warehouse_id)
) comment '仓库' row_format = DYNAMIC;


create table dcs_map
(
    id           int auto_increment comment '主键标识'
        primary key,

    warehouse_id varchar(32)                           not null comment '仓库id',
    map_code     varchar(32)                           not null comment '地图编码',
    map_name     varchar(32)                           null comment '地图名称',
    layer_code   varchar(32)                           not null default '1' comment '地图层',

    is_active    char        default '1'               not null comment '是否激活',
    created_by   varchar(32) default 'admin'           not null comment '创建人',
    created_time datetime    default CURRENT_TIMESTAMP not null comment '创建时间',
    updated_by   varchar(32) default 'admin'           not null comment '更新人',
    updated_time datetime    default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    is_deleted   char        default '0'               not null comment '删除标志',
    constraint uk_map_code unique key (map_code)
) comment '地图' row_format = DYNAMIC;

create table dcs_node
(
    id           int auto_increment comment '主键标识'
        primary key,

    warehouse_id varchar(32)                           not null comment '仓库id',
    map_code     varchar(32)                           not null comment '地图编码',

    node_code    varchar(32)                           not null comment '节点编码',
    node_type    varchar(32)                           not null default 1 comment '节点类型',
    x            varchar(32)                           null comment 'x坐标',
    y            varchar(32)                           null comment 'y坐标',
    z            varchar(32)                           null comment 'z坐标',

    is_active    char        default '1'               not null comment '是否激活',
    created_by   varchar(32) default 'admin'           not null comment '创建人',
    created_time datetime    default CURRENT_TIMESTAMP not null comment '创建时间',
    updated_by   varchar(32) default 'admin'           not null comment '更新人',
    updated_time datetime    default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    is_deleted   char        default '0'               not null comment '删除标志',
    constraint uk_node_code unique key (node_code)
) comment '节点' row_format = DYNAMIC;


create table dcs_edge
(
    id           int auto_increment comment '主键标识'
        primary key,

    map_code     varchar(32)                           not null comment '地图编码',

    edge_id      varchar(32)                           not null comment '边id',
    from_node    varchar(32)                           not null comment '起点',
    to_node      varchar(32)                           not null comment '终点',

    is_active    char        default '1'               not null comment '是否激活',
    created_by   varchar(32) default 'admin'           not null comment '创建人',
    created_time datetime    default CURRENT_TIMESTAMP not null comment '创建时间',
    updated_by   varchar(32) default 'admin'           not null comment '更新人',
    updated_time datetime    default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    is_deleted   char        default '0'               not null comment '删除标志',

    constraint uk_edge_id unique key (edge_id)

) comment '边' row_format = DYNAMIC;

create table dcs_container
(
    id             int auto_increment comment '主键标识'
        primary key,

    container_code varchar(32)                           not null comment '容器编码',
    node_code      varchar(32)                           not null comment '节点编码',
    map_code       varchar(32)                           not null comment '地图编码',

    device_code    varchar(32) default -1                not null comment '设备编码',
    length         varchar(32) default -1                not null comment '长',
    width          varchar(32) default -1                not null comment '宽',
    height         varchar(32) default -1                not null comment '高',
    weight         varchar(32) default -1                not null comment '重量',

    is_active      char        default '1'               not null comment '是否激活',
    created_by     varchar(32) default 'admin'           not null comment '创建人',
    created_time   datetime    default CURRENT_TIMESTAMP not null comment '创建时间',
    updated_by     varchar(32) default 'admin'           not null comment '更新人',
    updated_time   datetime    default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    is_deleted     char        default '0'               not null comment '删除标志',

    constraint uk_container_code unique key (container_code)
) comment '容器' row_format = DYNAMIC;
