package com.px.test;/* *
 * @ Author: LJH
 * @ Date: 2019/6/12 11:29
 */

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
//        OrderMapper orderMapper = ac.getBean("orderMapper", OrderMapper.class);
//        PageHelper.startPage(1 , 4);
//        List<Order> personList = orderMapper.check("56565");
//        //得到分页的结果对象
//        PageInfo<Order> pageInfo=new PageInfo<>(personList);
//        //得到分页中的person条目对象
//        List<Order> pageList = pageInfo.getList();
//        System.out.println(pageList);
//        for(Order l:pageList){
//            System.out.println(l.getCompanyName()+l.getNumber()+l.getTargetAddr()+l.getMoney());
//        }
        UserMapper userMapper = ac.getBean("userMapper", UserMapper.class);
        User user=new User();
        user.setUsername("张三");
//        User byName = userMapper.findByName(user);
//        System.out.println(byName.toString());
        User byName = userMapper.findByName(user);
        System.out.println(byName);

    }
}
