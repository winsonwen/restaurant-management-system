package com.project.restaurant.service;

import com.project.restaurant.R;
import com.project.restaurant.vo.EmployeeVo;
import com.project.restaurant.vo.MemberInfoVo;
import com.project.restaurant.vo.UserLoginVo;
import com.project.restaurant.vo.UserRegistVo;

public interface UserService {
    public R signUp(UserRegistVo vo, MemberInfoVo mvo) throws Exception;

    R loginRequest(UserLoginVo vo);

    int updateDeliveryInfo(EmployeeVo updateVo, EmployeeVo existVo);
}
