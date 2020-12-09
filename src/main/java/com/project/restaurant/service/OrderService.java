package com.project.restaurant.service;

import com.project.restaurant.vo.*;

import java.util.ArrayList;

/**
 * @author: Junxiang Wen
 * @date: 11/22/2020 6:20 PM
 * @description:
 */
public interface OrderService {
    /**
     * return order info for the specified deliveryman
     * @param employeeVo
     * @return
     */
    ArrayList<OrderEntity> getOrderInfo(EmployeeVo employeeVo);

    /**
     * Change order state while delivery man picked up the order
     * @param orderId
     * @param employeeVo
     * @return
     */
    int takeOrder(int orderId, EmployeeVo employeeVo);

    /**
     * Change order state while delivery man delivered the order
     * @param orderId
     * @return
     */
    int orderFinished(int orderId);

    /**
     * return order info for the specified customer
     * @param memberInfoVo
     * @return
     */
    ArrayList<OrderEntity> getUserOrderInfo(MemberInfoVo memberInfoVo);

    /**
     * return delivery man location for the specified order
     * @param orderId
     * @return
     */
    LocationVo getDeliveryLocation(int orderId);
}
