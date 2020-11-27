package com.project.restaurant.service.ServiceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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

    @Override
    public ArrayList<OrderEntity> getOrderInfo(EmployeeVo employeeVo) {
        List<OrderVo> order = orderVoDao.selectList(new QueryWrapper<OrderVo>().eq("order_type", 2));

        ArrayList<OrderEntity> orderEntities = new ArrayList<>();

        for (OrderVo obj: order ) {
            OrderEntity orderEntity = new OrderEntity();

            MemberInfoVo memberInfoVo = memberDao.selectById(obj.getCustomerId());
            CustomerEntity customerEntity = new CustomerEntity();
            BeanUtils.copyProperties(memberInfoVo, customerEntity);


            BeanUtils.copyProperties(obj, orderEntity);
            orderEntity.setCustomerEntity(customerEntity);
            orderEntities.add(orderEntity);
        }

//        for (OrderEntity or: orderEntities   ) {
//            System.out.println(or.toString());
//        }


        return orderEntities;
    }
}
