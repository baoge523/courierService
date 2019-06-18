package com.px.controller;



import com.px.entity.User;
import com.px.service.UserService;
import com.px.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;


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
    public JsonResult userlogin(User user,HttpSession session){
        System.out.println(user);
        System.out.println("======");
        user = userService.login(user);
        System.out.println(user);
        JsonResult jsonResult=new JsonResult();
        if(user!=null){
            System.out.println(user);
            jsonResult.addData("code",1);
            session.setAttribute("username",user.getUsername());
            jsonResult.addData("username",user.getUsername());
        }else{
            jsonResult.addData("code",2);
        }
        return jsonResult;
    }

    /**
     * 注册
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping("userregister")
    public JsonResult userregister(User user){
        userService.register(user);
        return new JsonResult(200,"");
    }

    /**
     * 更换头像
     * @param file
     * @return
     */
    @ResponseBody
    @RequestMapping("upload")
    public JsonResult registerUser(@RequestParam(value = "file", required = false) MultipartFile file ,HttpSession session) {
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
        String username = (String) session.getAttribute("username");
        User user=new User();
        user.setUsername(username);
        user.setImg(path1);
        userService.upload(user);
        String pathimg="upload/"+newFileName;
        code="1";
        JsonResult jsonResult=new JsonResult();
        jsonResult.addData("code",code);
        jsonResult.addData("pathimg",pathimg);
        return jsonResult;
    }

}
