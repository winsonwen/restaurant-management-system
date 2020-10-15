package com.project.restaurant.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Table;
import java.io.Serializable;

/**
 * @description: saving the information of employees who work in restaurants.
 */
@ToString
@Data
@TableName("employee")
public class EmployeeVo implements Serializable {

    @TableId
    String employeeId;

    String firstName;
    String lastName;
    String position;    //0->Manager 1->Waiter 2->Delivery Man
    private String phoneNumber;
    String email;
    String ssn;
    String token;
}
