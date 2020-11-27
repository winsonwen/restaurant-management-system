package com.project.restaurant.service;

import com.project.restaurant.R;
import com.project.restaurant.vo.*;

public interface UserService {
    public R signUp(UserRegistVo vo, MemberInfoVo mvo) throws Exception;

    R loginRequest(UserLoginVo vo);

    int updateDeliveryInfo(EmployeeVo updateVo, EmployeeVo existVo);

    int updateUserInfo(MemberInfoVo updateVo, MemberInfoVo existVo);

    int  updateDeliveryManLocation(LocationVo locationVo, EmployeeVo existVo);
}
