package com.px.controller;/* *
 * @ Author: LJH
 * @ Date: 2019/6/12 9:04
 */

import com.px.entity.Horseman;
import com.px.serivce.HorsemanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
