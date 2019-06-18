package com.px.service.impl;/* *
 * @ Author: LJH
 * @ Date: 2019/6/14 20:26
 */

import com.px.dao.OrderMapper;
import com.px.entity.Order;
import com.px.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper mapper;
    @Override
    public void insertpublish(Order order) {
        mapper.insertpublish(order);
    }

    /**
     * 查询所有的发布信息
     * @return
     */
    @Override
    public List<Order> findAll() {
        return mapper.findAll();
    }
    @Override
    public void update(int num) {
        mapper.update(num);
    }
}
