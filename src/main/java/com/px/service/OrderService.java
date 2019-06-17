package com.px.service;/* *
 * @ Author: LJH
 * @ Date: 2019/6/14 20:26
 */

import com.px.entity.Order;

import java.util.List;

public interface OrderService {
    void insertpublish (Order order);
    /**
     * 查询所有的发布信息
     * @return
     */
    List<Order> findAll();

    /**
     * 更新状态码
     * @param num
     */
    void update(int num);
    /**
     * user查询账单
     * @param username
     * @return
     */
    List<Order> check(String username);
}
