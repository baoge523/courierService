package com.px.controller;/* *
 * @ Author: LJH
 * @ Date: 2019/6/12 9:04
 */

import com.px.entity.Horseman;
import com.px.serivce.HorsemanService;
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

@Controller
@RequestMapping("horse")
public class HorsemanController {
    @Autowired
    private HorsemanService horsemanService;

   @ResponseBody
    @RequestMapping("horsemanlogin")
    public String horsemanlogin(Horseman horseman){
        System.out.println(horseman);
        System.out.println("======");
        horseman = horsemanService.login(horseman);
        System.out.println(horseman);
        String code;
        if(horseman!=null){
            System.out.println(horseman);
            code="1";
        }else{
            code="2";
        }
        return code;
    }

    @ResponseBody
    @RequestMapping("horseregister")
    public String horseregister(Horseman horseman){
        horsemanService.register(horseman);
        String code="1";
        return code;
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
        String path1=path+"\\"+newFileName;
        // 将数据存入数据库
        horsemanService.upload(path1);
        Map<String,Object> map=new HashMap<>();
        String pathimg="upload/"+newFileName;
        code="1";
        map.put("pathimg",pathimg);
        map.put("code",code);
        return map;
    }

}