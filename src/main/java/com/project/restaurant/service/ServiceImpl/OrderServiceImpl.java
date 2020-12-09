package com.project.restaurant.service.ServiceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.project.restaurant.dao.DeliverOrderDao;
import com.project.restaurant.dao.MemberDao;
import com.project.restaurant.dao.OrderVoDao;
import com.project.restaurant.service.OrderService;
import com.project.restaurant.vo.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Junxiang Wen
 * @date: 11/22/2020 6:20 PM
 * @description:
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    OrderVoDao orderVoDao;
    @Resource
    MemberDao memberDao;
    @Resource
    DeliverOrderDao deliverOrderDao;

    @Override
    public ArrayList<OrderEntity> getOrderInfo(EmployeeVo employeeVo) {
        List<OrderVo> order = orderVoDao.selectList(new QueryWrapper<OrderVo>().eq("order_type", 1));

        ArrayList<OrderEntity> orderEntities = new ArrayList<>();

        for (OrderVo obj : order) {
            OrderEntity orderEntity = new OrderEntity();

            MemberInfoVo memberInfoVo = memberDao.selectById(obj.getCustomerId());
            CustomerEntity customerEntity = new CustomerEntity();
            BeanUtils.copyProperties(memberInfoVo, customerEntity);


            BeanUtils.copyProperties(obj, orderEntity);
            orderEntity.setCustomerEntity(customerEntity);
            orderEntities.add(orderEntity);
        }
        return orderEntities;
    }

    @Override
    public int takeOrder(int orderId, EmployeeVo employeeVo) {
        OrderVo orderVo = orderVoDao.selectById(orderId);
        orderVo.setOrderStatus(5);
        orderVo.setStaffId(employeeVo.getId());
        int i = orderVoDao.updateById(orderVo);

        return i;
    }

    @Override
    public int orderFinished(int orderId) {
        OrderVo orderVo = orderVoDao.selectById(orderId);
        orderVo.setOrderStatus(2);
        orderVo.setStaffId(0);
        int i = orderVoDao.updateById(orderVo);

        return i;
    }

    @Override
    public ArrayList<OrderEntity> getUserOrderInfo(MemberInfoVo memberInfoVo) {
        List<OrderVo> order = orderVoDao.selectList(new QueryWrapper<OrderVo>().eq("customer_id", memberInfoVo.getId()));

        ArrayList<OrderEntity> orderEntities = new ArrayList<>();

        for (OrderVo obj : order) {
            OrderEntity orderEntity = new OrderEntity();
            BeanUtils.copyProperties(obj, orderEntity);
            orderEntities.add(orderEntity);
        }
        return orderEntities;
    }

    @Override
    public LocationVo getDeliveryLocation(int orderId) {
        OrderVo orderVo = orderVoDao.selectById(orderId);
        return deliverOrderDao.selectOne(new QueryWrapper<LocationVo>().eq("staff_id", orderVo.getStaffId()));
    }
}
