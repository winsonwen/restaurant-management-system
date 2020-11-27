package com.project.restaurant.controller;

import com.project.restaurant.R;
import com.project.restaurant.config.RestaurantInterceptor;
import com.project.restaurant.constant.MemberConstant;
import com.project.restaurant.service.MemberService;
import com.project.restaurant.service.OrderService;
import com.project.restaurant.vo.EmployeeVo;
import com.project.restaurant.vo.LocationVo;
import com.project.restaurant.vo.MemberInfoVo;
import com.project.restaurant.vo.OrderEntity;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * @author: Junxiang Wen
 * @date: 11/22/2020 5:28 PM
 * @description:
 */
@RestController
public class OrderController {


    @Resource
    OrderService orderService;

    @PostMapping("/getOrderInfo")
    public R getOrderInfo(){

//        EmployeeVo existVo = (EmployeeVo) request.getSession().getAttribute(MemberConstant.LOGIN_USER);
        EmployeeVo employeeVo = RestaurantInterceptor.staffThreadLocal.get();
        System.out.println(employeeVo);
        System.out.println("?????");
        ArrayList<OrderEntity> orderEntities = orderService.getOrderInfo(employeeVo);

        System.out.println("???" + orderEntities);
        return R.ok().put("orderEntities", orderEntities);
//        return R.ok();
    }
}
