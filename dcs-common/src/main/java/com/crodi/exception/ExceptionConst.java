package com.crodi.exception;

/**
 * @Author: crodi.zhang
 * @Date: 2026/9/2 15:05
 * @Description: 异常常量
 **/
public interface ExceptionConst {

    // projectManage
    String PROJECT_NOT_EXIST = "项目不存在";

    String PROJECT_LIST_EMPTY = "项目列表为空";

    String PROJECT_CREATE_FAILED = "项目创建失败";

    String PROJECT_ID_NOT_NULL = "项目ID不能为空";

    String PROJECT_DELETE_FAILED = "项目删除失败";

    String PROJECT_UPDATE_FAILED = "项目更新失败";

    // warehouseManage
    String WAREHOUSE_SELECT_FAILED = "仓库查询失败";

    String WAREHOUSE_NOT_EXIST = "仓库不存在";

    String WAREHOUSE_CREATE_FAILED = "仓库创建失败";

    String WAREHOUSE_ID_NOT_NULL = "仓库ID不能为空";

    String WAREHOUSE_UPDATE_FAILED = "仓库更新失败";

    String WAREHOUSE_DELETE_FAILED = "仓库删除失败";

    String MULTIPLE_ACTIVE_WAREHOUSE_FOUND = "存在多个激活仓库";


    // common
    String REQUEST_PARAM_NOT_NULL = "请求参数不能为空";

}
