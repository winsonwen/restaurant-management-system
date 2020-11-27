package com.project.restaurant.config;

import com.project.restaurant.constant.MemberConstant;
import com.project.restaurant.vo.EmployeeVo;
import com.project.restaurant.vo.MemberInfoVo;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * @author: Junxiang Wen
 * @date: 11/22/2020 5:30 PM
 * @description:
 */
public class RestaurantInterceptor implements HandlerInterceptor {

    //用于传递数据
    public static ThreadLocal<EmployeeVo> staffThreadLocal = new ThreadLocal<>();
    public static ThreadLocal<MemberInfoVo> memberThreadLocal = new ThreadLocal<>();

    // Checking the login state first, then transfer to Controller
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String type = request.getHeader("type");
        System.out.println(type);
        try {
            if ("staff".equals(type)) {
                EmployeeVo existVo = (EmployeeVo) request.getSession().getAttribute(MemberConstant.LOGIN_USER);
//                System.out.println(existVo.toString());
                staffThreadLocal.set(existVo);
            } else {

                MemberInfoVo existVo = (MemberInfoVo) request.getSession().getAttribute(MemberConstant.LOGIN_USER);
//                System.out.println(existVo.toString());
                memberThreadLocal.set(existVo);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }


    }


}
