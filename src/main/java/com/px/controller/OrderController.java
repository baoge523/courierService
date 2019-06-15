package com.px.controller;/* *
 * @ Author: LJH
 * @ Date: 2019/6/14 20:01
 */

import com.px.entity.Order;
import com.px.entity.User;
import com.px.serivce.OrderService;
import com.px.serivce.UserService;
import com.px.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping("order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;

    /**
     * user发布
     * @param order
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping("publish")
    public JsonResult publish(Order order, HttpSession session){
        System.out.println(order.toString());
        String  username = (String) session.getAttribute("username");
        User user=new User();
        user.setUsername(username);
        User byName = userService.findByName(user);
        order.setUsername(username);
        order.setUserId(byName.getId());
        order.setPublishTime(new Date());
        order.setStatus(1);
        System.out.println(order.toString());
        orderService.insertpublish(order);
        JsonResult jsonResult=new JsonResult();
        jsonResult.addData("username",username);
        jsonResult.addData("companyname",order.getCompanyName());
        jsonResult.addData("number",order.getNumber());
        jsonResult.addData("targetaddr",order.getTargetAddr());
        jsonResult.addData("money",order.getMoney());
        jsonResult.addData("date",order.getPublishTime());
        for(String s:jsonResult.getDatas().keySet()){
            System.out.println(s+"::::"+jsonResult.getDatas().get(s));
        }
        return jsonResult;
    }
}
