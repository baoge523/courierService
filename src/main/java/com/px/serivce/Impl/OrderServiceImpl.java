package com.px.serivce.Impl;/* *
 * @ Author: LJH
 * @ Date: 2019/6/14 20:26
 */

import com.px.dao.OrderMapper;
import com.px.entity.Order;
import com.px.serivce.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper mapper;
    @Override
    public void insertpublish(Order order) {
        mapper.insertpublish(order);
    }
}
