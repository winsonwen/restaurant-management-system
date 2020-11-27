package com.project.restaurant.service;

import com.project.restaurant.vo.EmployeeVo;
import com.project.restaurant.vo.OrderEntity;

import java.util.ArrayList;

/**
 * @author: Junxiang Wen
 * @date: 11/22/2020 6:20 PM
 * @description:
 */
public interface OrderService {
    ArrayList<OrderEntity> getOrderInfo(EmployeeVo employeeVo);
}
