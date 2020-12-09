package com.project.restaurant.service;

import com.project.restaurant.R;
import com.project.restaurant.vo.*;

public interface UserService {
    R signUp(UserRegistVo vo, MemberInfoVo mvo) throws Exception;

    R loginRequest(UserLoginVo vo);

    /**
     * Update delivery man  info
     * @param updateVo
     * @param existVo
     * @return
     */
    int updateDeliveryInfo(EmployeeVo updateVo, EmployeeVo existVo);

    /**
     * Update customer  info
     * @param updateVo
     * @param existVo
     * @return
     */
    int updateUserInfo(MemberInfoVo updateVo, MemberInfoVo existVo);

    int  updateDeliveryManLocation(LocationVo locationVo, EmployeeVo existVo);
}
