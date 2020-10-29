package com.project.restaurant.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

/**
 * @description: saving the information of employees who work in restaurants.
 */
@ToString
@Data
@TableName("staff_info")
public class EmployeeVo implements Serializable {

    @TableId
    String id;


    @NotEmpty(message = "First Name should be submitted")
    @Length(min=1, max=18,message = "password should be 1-20 character")
    @Pattern(regexp = "([a-zA-Z]*)", message = "must be all letter ")
    String firstName;

    @NotEmpty(message = "Last Name should be submitted")
    @Length(min=1, max=20,message = "Last Name should be 1-20 character")
    @Pattern(regexp = "([a-zA-Z]*)", message = "must be all letter ")
    String lastName;

    String addressId;

//    String position;    //0->Manager 1->Waiter 2->Delivery Man

    Date birthday;
    String title;
    int parentId;
    String gender;

    @NotEmpty(message = "Phone Number should be submitted")
    @Pattern(regexp = "([\\d]{10})", message = "must be Valid Phone number ")
    private String phone;

    @NotEmpty(message = "Email should be submitted")
    @Email(message = "Email is not valid")
    String email;

    String ssn;
}
