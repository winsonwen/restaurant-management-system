package com.project.restaurant.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * @author: Junxiang Wen
 * @date: 11/22/2020 6:16 PM
 * @description:
 */
@ToString
@Data
@TableName("order_table")
public class OrderVo {
    @TableId
    int orderId;
    String foodItems;
    int quantity;
    BigDecimal orderTotal;
    int customerId;
    int  orderStatus;
    int orderType;
    int staffId;

}
