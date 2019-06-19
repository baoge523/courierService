package com.px.test;/* *
 * @ Author: LJH
 * @ Date: 2019/6/12 11:29
 */

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.px.dao.OrderMapper;
import com.px.entity.Order;
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
        PageHelper.startPage(1 , 3);
//        List<Order> personList = orderMapper.check("56565");
//        //得到分页的结果对象
//        PageInfo<Order> pageInfo=new PageInfo<>(personList);
//        //得到分页中的order条目对象
//        List<Order> pageList = pageInfo.getList();
//        System.out.println(pageInfo);
//        for(Order page:pageList){
//            System.out.println(page.getUsername()+page.getTargetAddr()+page.getPublishTime()+"========="+page.getHorseman().getUsername()+page.getMoney());
//        }
//
//        System.out.println(pageInfo);
        OrderMapper userMapper =  ac.getBean("orderMapper", OrderMapper.class);
//        User user=new User();
//        user.setUsername("张三");
//        User byName = userMapper.findByName(user);
//        System.out.println(byName.toString());
//        User byName = userMapper.findByName(user);
//        System.out.println(byName);
//        PageHelper.startPage(1 , 3);//分页
//        List<Order> list = orderMapper.check("LIUHONG");
//        //得到分页的结果对象
//        PageInfo<Order> pageInfo=new PageInfo<Order>(list);
          //使用分页插件,核心代码就这一行，页数、每页行数
        PageHelper.startPage(1,4);
//        List<Order> liuhong = orderMapper.check("LIUHONG");//在 mapper.xml 中不要加 limit 分页，插件会自动拦截和添加 limit 分页
        List<Order> all = orderMapper.findAll();
        PageInfo<Order> pageInfo=new PageInfo<>(all);
        System.out.println(pageInfo);
    }
}
