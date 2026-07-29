package com.crodi.sevice;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.crodi.base.BusinessTicketApi;
import com.crodi.mapper.BusinessTicketMapper;
import com.crodi.model.task.BusinessTicket;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: crodi.zhang
 * @Date: 2026/7/28 11:00
 * @Description: TODO
 **/
@Service
@RequiredArgsConstructor
public class BusinessTicketService implements BusinessTicketApi {

    private final BusinessTicketMapper businessTicketMapper;

    @Override
    public void saveBusinessTicket(BusinessTicket businessTicket) {
        businessTicketMapper.insert(businessTicket);
    }

    @Override
    public void updateBusinessTicket(BusinessTicket businessTicket) {
        LambdaQueryWrapper<BusinessTicket> wrapper = new LambdaQueryWrapper<BusinessTicket>()
                .eq(BusinessTicket::getBusinessId, businessTicket.getBusinessId());
        businessTicketMapper.update(businessTicket, wrapper);
    }

    @Override
    public void deleteBusinessTicket(BusinessTicket businessTicket) {
        LambdaQueryWrapper<BusinessTicket> wrapper = new LambdaQueryWrapper<BusinessTicket>()
                .eq(BusinessTicket::getBusinessId, businessTicket.getBusinessId());
        businessTicketMapper.update(businessTicket, wrapper);
    }

    @Override
    public BusinessTicket getBusinessTicket(String businessTicketId) {
        LambdaQueryWrapper<BusinessTicket> wrapper = new LambdaQueryWrapper<BusinessTicket>()
                .eq(BusinessTicket::getBusinessId, businessTicketId);
        return businessTicketMapper.selectOne(wrapper);
    }

    @Override
    public List<BusinessTicket> getBusinessTicketList(String source) {
        LambdaQueryWrapper<BusinessTicket> wrapper = new LambdaQueryWrapper<BusinessTicket>()
                .eq(BusinessTicket::getSource, source);
        return businessTicketMapper.selectList(wrapper);
    }
}
