package com.px.dao;/* *
 * @ Author: LJH
 * @ Date: 2019/6/14 20:06
 */

import com.px.entity.Order;

import java.util.List;

public interface OrderMapper {
   /**
    * 发布信息
    * @param order
    */
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

   /**
    * 通过id去查找账单的状态
    * @param orderid
    * @return
    */
   Order findById(int orderid);
}
