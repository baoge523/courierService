package com.px.controller;

import com.px.dao.UserMapper;
import com.px.entity.User;
import com.px.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 宝哥
 * @date 2019/6/11
 * TODO
 */
@Controller
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value="/login",method = RequestMethod.POST)
    public String login(String username, String password, HttpServletRequest request){
        User user = userMapper.login(username);
        if (user == null) {
            request.setAttribute("message","用户不存在");
            return "hello";
        }
        if(!user.getPassword().equals(password)){
            request.setAttribute("message","密码错误");
            return "hello";
        }
        request.setAttribute("message","登录成功");
        return "hello";
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
