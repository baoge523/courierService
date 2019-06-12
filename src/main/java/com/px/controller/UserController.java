package com.px.controller;


import com.px.entity.User;
import com.px.serivce.UserService;
import com.px.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 宝哥
 * @date 2019/6/11
 * TODO
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 登录
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping("userlogin")
    public String userlogin(User user){
        System.out.println(user);
        System.out.println("======");
        user = userService.login(user);
        System.out.println(user);
        String code;
        if(user!=null){
            System.out.println(user);
            code="1";
        }else{
            code="2";
        }
        return code;
    }

    /**
     * 注册
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping("userregister")
    public String userregister(User user){
        userService.register(user);
        String code="1";
        return code;
    }



    /**
     * 注册
     *
     *  JsonResult 封装了我们需要传递给HTML页面的数据
     *
     * @return
     */
    @ResponseBody
    public JsonResult regist(User user){

        return new JsonResult();
    }

}
