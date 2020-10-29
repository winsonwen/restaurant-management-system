package com.project.restaurant.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@ToString
@Data
@TableName("customer_info")
public class MemberInfoVo implements Serializable {

    @TableId
    private int id;

//    public MemberInfoVo(String firstName, String lastName, String phoneNumber, String email) {
//        this.staffFirstName = firstName;
//        this.staffLastName = lastName;
//        this.phone = phoneNumber;
//        this.email = email;
//    }
    private Date birthday;

    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private int parentId = 1;
    private String title;
    private String gender;

    public MemberInfoVo() {
    }

    public MemberInfoVo(String firstName, String lastName, String phoneNumber, String email) {
        this.firstName=firstName;
        this.lastName=lastName;
        this.phone = phoneNumber;
        this.email = email;

    }
}
