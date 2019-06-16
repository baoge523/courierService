package com.px.test;/* *
 * @ Author: LJH
 * @ Date: 2019/6/12 11:29
 */

import com.px.dao.OrderMapper;
import com.px.dao.UserMapper;
import com.px.entity.Order;
import com.px.entity.User;
import com.px.utils.JsonResult;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;

public class AppTest {
    public static void main(String[] args){
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
//        UserMapper userMapper = ac.getBean("userMapper", UserMapper.class);
//
//        User u = new User();
////        u.setEamil("237729650@qq.com");
////        u.setPassword("45");
//        u.setUsername("张三");
//        u.setPassword("123456");
//        u.setEmail("110@qq.com");
//        u.setTel("13657634315");
//        userMapper.register(u);
////        User login = userMapper.login(u);
//
////        System.out.println(login);
//        Date date=new Date();
//        System.out.println(date);
        OrderMapper orderMapper = ac.getBean("orderMapper", OrderMapper.class);
        List<Order> order = orderMapper.findAll();
        Iterator<Order> iterator = order.iterator();
        while (iterator.hasNext()){
            Order next = iterator.next();
            if(next.getStatus()==2){
                iterator.remove();
            }
        }
        System.out.println(order);
        JsonResult jsonResult=new JsonResult();
            jsonResult.addData("order",order);

        for(String s:jsonResult.getDatas().keySet()){
            System.out.println(s+"::::"+jsonResult.getDatas().get(s));
        }
    }
}
