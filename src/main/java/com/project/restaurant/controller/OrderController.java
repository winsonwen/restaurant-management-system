package com.project.restaurant.controller;

import com.project.restaurant.R;
import com.project.restaurant.config.RestaurantInterceptor;
import com.project.restaurant.constant.MemberConstant;
import com.project.restaurant.service.MemberService;
import com.project.restaurant.service.OrderService;
import com.project.restaurant.vo.*;
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

    /**
     * get list of order information for deliveryman
     * @return
     */
    @PostMapping("/getOrderInfo")
    public R getOrderInfo(){
        EmployeeVo employeeVo = RestaurantInterceptor.staffThreadLocal.get();
        ArrayList<OrderEntity> orderEntities = orderService.getOrderInfo(employeeVo);
        return R.ok().put("orderEntities", orderEntities);
    }

    /**
     * get list of order information for customer
     * @return
     */
    @PostMapping("/getUserOrderInfo")
    public R getUserOrderInfo(){

        MemberInfoVo memberInfoVo = RestaurantInterceptor.memberThreadLocal.get();
        ArrayList<OrderEntity> orderEntities = orderService.getUserOrderInfo(memberInfoVo);
        return R.ok().put("orderEntities", orderEntities);

    }

    /**
     * Return deliver man location for the specified order
     * @param orderIdVo
     * @return
     */
    @PostMapping("/getDeliveryLocation")
    public R getDeliveryLocation(@RequestBody OrderIdVo orderIdVo){

        LocationVo locationVo = orderService.getDeliveryLocation(orderIdVo.getOrderId());
        return R.ok().put("locationInfo", locationVo);

    }


    /**
     * delivery man pick up the order for delivery
     * @param orderIdVo order id
     * @return
     */
    @PostMapping("/takeOrder")
    public R takeOrder(@RequestBody OrderIdVo orderIdVo){

        EmployeeVo employeeVo = RestaurantInterceptor.staffThreadLocal.get();
        int i =  orderService.takeOrder( orderIdVo.getOrderId(),employeeVo);
        if(i ==1 ){
            return R.ok();
        }

       return R.error(300,"Update order state Error");
    }

    /**
     * delivery man the order
     * @param orderIdVo
     * @return
     */
    @PostMapping("/orderFinished")
    public R orderFinished(@RequestBody OrderIdVo orderIdVo){

        int i =  orderService.orderFinished( orderIdVo.getOrderId());
        if(i ==1 ){
            return R.ok();
        }

        return R.error(300,"Update order state Error");
    }
}
