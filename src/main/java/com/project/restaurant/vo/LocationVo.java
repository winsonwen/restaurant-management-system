package com.project.restaurant.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @author: Junxiang Wen
 * @date: 11/22/2020 2:29 PM
 * @description:
 */
@Data
@ToString
@TableName("delivery_order")
public class LocationVo {
    @TableId
    int id;
    int staff_id;
    String latitude;
    String  longitude;
    Date timestamp;


}
