package com.px.controller;/* *
 * @ Author: LJH
 * @ Date: 2019/6/14 20:01
 */

import com.px.entity.Order;
import com.px.entity.User;
import com.px.service.OrderService;
import com.px.service.UserService;
import com.px.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


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
        jsonResult.setStatusCode(200);
        return jsonResult;
    }

    /**
     * 查询所有发布的信息
     * @return
     */

    @ResponseBody
    @RequestMapping("findAll")
        public JsonResult findAll(){
        List<Order> order = orderService.findAll();
        //排除接单的，页面展示未接单
        Iterator<Order> iterator = order.iterator();
        while (iterator.hasNext()){
            Order next = iterator.next();
            if(next.getStatus()==2){
                iterator.remove();
            }
        }
        System.out.println(order);
        JsonResult jsonResult=new JsonResult();
        jsonResult.addData("order",order);
       return jsonResult;
    }
}
