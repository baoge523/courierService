package com.px.controller;


import com.px.entity.User;
import com.px.serivce.UserService;
import com.px.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
     * 上传图片
     * @param file
     * @param map
     * @return
     */
    @RequestMapping("upload")
    public String testUpload(@RequestParam("file") MultipartFile file, Map<String ,Object> map) throws IOException {
        String code;
            InputStream inputStream = file.getInputStream();
            String filename = file.getOriginalFilename();
            OutputStream out=new FileOutputStream("img");//文件夹名
            byte[] bs=new byte[1024];
            int len=-1;
            while ((len=inputStream.read())!=-1){
                out.write(bs,0,len);
            }
            System.out.println("上传成功");
            String path="..//img//"+filename;
            System.out.println(path);
            userService.upload(path);
            map.put("path",path);
            System.out.println("上传成功"+filename);
            code="1";
            out.close();
            inputStream.close();
        return code;
    }
}
