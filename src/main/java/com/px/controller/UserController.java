package com.px.controller;


import com.px.entity.Horseman;
import com.px.entity.User;
import com.px.serivce.UserService;
import com.px.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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

    /**
     * 上传头像
     * @param file
     * @return
     */
    @ResponseBody
    @RequestMapping("upload")
    public Map<String,Object> registerUser(@RequestParam(value = "file", required = false) MultipartFile file) {
        String code;
        // 获取文件路径
        String path = "E:\\IdeaProjects\\courierService\\src\\main\\webapp\\upload";
        String fileName = file.getOriginalFilename();// 文件原名称
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
        // ͨ修改文件名
        String newFileName = sdf.format(new Date()) + fileName.substring(fileName.lastIndexOf("."));// 获得文件后缀名
        File myFile = new File(path, newFileName);
        // 判断文件是否存在
        if (!myFile.exists()) {
            myFile.mkdirs();// 创建一个新的文文
        }

        try {
            // 转存文件到指定的路径
            file.transferTo(myFile);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String path1=path+"\\"+newFileName;
        // 将数据存入数据库
        userService.upload(path1);
        String pathimg="upload/"+newFileName;
        code="1";
        Map<String,Object> map=new HashMap<>();
        map.put("pathimg",pathimg);
        map.put("code",code);
        return map;
    }


}
