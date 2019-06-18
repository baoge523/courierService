package com.px.controller;/* *
 * @ Author: LJH
 * @ Date: 2019/6/14 20:01
 */

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

    /**
     * user查询账单
     * @param session
     * @return
     */

    @ResponseBody
    @RequestMapping("checkuser")
    public JsonResult checkuser(HttpSession session){
        JsonResult jsonResult=new JsonResult();
        String  username = (String) session.getAttribute("username");
        List<Order> list = orderService.check(username);
        PageHelper.startPage(1 , 4);//分页
        //得到分页的结果对象
        PageInfo<Order> pageInfo=new PageInfo<>(list);
        //得到分页中的person条目对象
        List<Order> pageList = pageInfo.getList();
        System.out.println(pageList);
        for(Order l:pageList){
            System.out.println(l.getCompanyName()+l.getNumber()+l.getTargetAddr()+l.getMoney());
        }
        return jsonResult;
    }
//
//
//    @ResponseBody
//    @RequestMapping("checkuser")
//    public JsonResult checkhorse(HttpSession session){
//        JsonResult jsonResult=new JsonResult();
//        String  username = (String) session.getAttribute("username");
//        List<Order> list = orderService.check(username);
//        PageHelper.startPage(1 , 4);//分页
//        //得到分页的结果对象
//        PageInfo<Order> pageInfo=new PageInfo<>(list);
//        //得到分页中的person条目对象
//        List<Order> pageList = pageInfo.getList();
//        System.out.println(pageList);
//        for(Order l:pageList){
//            System.out.println(l.getCompanyName()+l.getNumber()+l.getTargetAddr()+l.getMoney());
//        }
//        return jsonResult;
//    }

}
