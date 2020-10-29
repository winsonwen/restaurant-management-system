package com.project.restaurant.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;



@ToString
@Data
@TableName("login")
public class UserRegistVo {


    public UserRegistVo(String userName, String passwords) {
        this.userName = userName;
        this.passwords = passwords;
    }

    @TableId
    private int id;

    private String userName;

    private String passwords;

    private int memberId;
    private int employeeId;

}
