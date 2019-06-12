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

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
     * 上传图片
     * @param file
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("upload")
    public String testUpload(@RequestParam("file") MultipartFile file, Map<String ,Object> map) throws IOException {
        String code ;
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
        horsemanService.upload(path);
        map.put("path",path);
        System.out.println("上传成功"+filename);
        code="1";
        out.close();
        inputStream.close();
        return code ;
    }
}
