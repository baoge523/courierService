package com.px.test;/* *
 * @ Author: LJH
 * @ Date: 2019/6/12 11:29
 */

import com.px.dao.UserMapper;
import com.px.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppTest {
    public static void main(String[] args){
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
        UserMapper userMapper = ac.getBean("userMapper", UserMapper.class);

        User u = new User();
//        u.setEamil("237729650@qq.com");
//        u.setPassword("45");
        u.setUsername("张三");
        u.setPassword("123456");
        u.setEmail("110@qq.com");
        u.setTel("13657634315");
        userMapper.register(u);
//        User login = userMapper.login(u);

//        System.out.println(login);
    }
}
