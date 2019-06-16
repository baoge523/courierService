package com.px.controller;/* *
 * @ Author: LJH
 * @ Date: 2019/6/16 15:53
 */

import com.px.entity.Detail;
import com.px.entity.Horseman;
import com.px.serivce.DetailService;
import com.px.serivce.HorsemanService;
import com.px.serivce.OrderService;
import com.px.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("detail")
public class DetailController {
    @Autowired
    private DetailService detailService;
    @Autowired
    private HorsemanService horsemanService;
    @Autowired
    private OrderService orderService;

    /**
     * 骑手接单
     * @param detail
     * @param session
     * @return
     */
    @RequestMapping("receiver")
    @ResponseBody
   public JsonResult receiver(Detail detail, HttpSession session){
        System.out.println(detail.toString());
        String horsemanuname = (String) session.getAttribute("horsemanuname");
        Horseman horseman = horsemanService.findByName(horsemanuname);
        detail.setHorsemanId(horseman.getId());
        System.out.println("===================================");
        System.out.println(detail);
        detailService.receiver(detail);
        JsonResult jsonResult=new JsonResult();
        orderService.update(detail.getOrderId());//接单成功就修改用户的状态码
        jsonResult.setStatusCode(200);
       return jsonResult;
   }
}
