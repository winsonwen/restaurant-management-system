package com.project.restaurant.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class UserLoginVo {

    @TableId
    private int id;

    private String userName;
    private String passwords;
}
