package com.project.restaurant.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Data
@TableName("member")
public class MemberInfoVo implements Serializable {

    @TableId
    private int memberId;

    public MemberInfoVo(String firstName, String lastName, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String membershipCatagory;
    private String membershipExpiration;
    private String token;

}
