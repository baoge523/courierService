package com.px.controller;/* *
 * @ Author: LJH
 * @ Date: 2019/6/12 9:04
 */

import com.px.entity.Horseman;
import com.px.service.HorsemanService;
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
import java.util.*;

@Controller
@RequestMapping("horse")
public class HorsemanController {
    @Autowired
    private HorsemanService horsemanService;
    /**
     * 登录
     * @param horseman
     * @return
     */
   @ResponseBody
    @RequestMapping("horsemanlogin")
    public JsonResult horsemanlogin(Horseman horseman,HttpSession session){
        System.out.println(horseman);
        System.out.println("======");
        horseman = horsemanService.login(horseman);
        System.out.println(horseman);
        JsonResult jsonResult=new JsonResult();
        if(horseman!=null){
            session.setAttribute("horsemanuname",horseman.getUsername());
            System.out.println(horseman);
         jsonResult.addData("code",1);
         jsonResult.addData("horsemanuname",horseman.getUsername());
        }else{
            jsonResult.addData("code",2);
        }
        return jsonResult;
    }

    @ResponseBody
    @RequestMapping("horseregister")
    public JsonResult horseregister(Horseman horseman){
        horsemanService.register(horseman);
        return new JsonResult(200,"");
    }

    /**
     * 更换头像
     * @param file
     * @return
     */
    @ResponseBody
    @RequestMapping("upload")
    public JsonResult registerUser(@RequestParam(value = "file", required = false) MultipartFile file,HttpSession session) {
       String code;
        // 获取文件路径
        String path = "E:\\IdeaProjects\\courierService\\src\\main\\webapp\\upload";
        System.out.println(path);
        String fileName = file.getOriginalFilename();// 文件原名称
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
        // 修改文件名
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
        // 将数据存入数据库
        String horsemanuname =(String) session.getAttribute("horsemanuname");
        Horseman horseman=new Horseman();
        horseman.setUsername(horsemanuname);
        JsonResult jsonResult=new JsonResult();
        String pathimg="upload/"+newFileName;
        horseman.setImg(pathimg);
        horsemanService.upload(horseman);
        code="1";
        jsonResult.addData("code",code);
        jsonResult.addData("pathimg",pathimg);

        Map<String, Object> datas = jsonResult.getDatas();
        for(String s:datas.keySet()){
            Object o = datas.get(s);
            System.out.println(s+o);
        }
        return jsonResult;
    }

    /**
     * 将骑手的信息全部回显到页面上
     * @return
     */
    @RequestMapping("echo")
    @ResponseBody
    public JsonResult echo(){
        JsonResult jsonResult=new JsonResult();
        List<Horseman> echo = horsemanService.echo();
        jsonResult.addData("echo",echo);
        return jsonResult;
    }
}
