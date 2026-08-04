package com.crodi.base;

import com.crodi.model.task.BusinessTicket;

import java.util.List;

/**
 * @Author: crodi.zhang
 * @Date: 2026/7/28 11:01
 * @Description: TODO
 **/

public interface BusinessTicketApi {

    /**
     * 保存业务单
     *
     * @param businessTicket 业务单
     */
    void saveBusinessTicket(BusinessTicket businessTicket);

    /**
     * 更新业务单
     *
     * @param businessTicket 业务单
     */
    void updateBusinessTicket(BusinessTicket businessTicket);

    /**
     * 删除业务单
     *
     * @param businessTicket 业务单
     */
    void deleteBusinessTicket(BusinessTicket businessTicket);

    /**
     * 获取业务单
     *
     * @param businessTicketId 业务单ID
     * @return 业务单
     */
    BusinessTicket getBusinessTicket(String businessTicketId);

    /**
     * 获取业务单列表
     *
     * @return 业务单列表
     */
    List<BusinessTicket> getBusinessTicketList(String source);


}
