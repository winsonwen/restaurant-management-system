
package com.project.restaurant.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.project.restaurant.R;
import com.project.restaurant.constant.MemberConstant;
import com.project.restaurant.service.UserService;
import com.project.restaurant.vo.*;
import org.springframework.beans.BeanUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.lang.reflect.Member;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.TimeUnit;



@RestController
public class UserController {

    public static final String RESTAURANT_SESSION_ID = "restaurantSessionID";

    @Resource
    UserService userService;
    @Resource
    StringRedisTemplate stringRedisTemplate;

    @PostMapping("/login")
    public R userLogin(@RequestBody UserLoginVo vo, HttpSession session) {
        System.out.println(111);
        R result = userService.loginRequest(vo);
        if(result==null)
            return R.error(402,"Account Not Exists");

        int resultNum = (int)result.get("result");   // 2->employee   1->customer
        System.out.println(resultNum);
        if (resultNum==1){
            MemberInfoVo memberInfoVo = result.getData(new TypeReference<MemberInfoVo>(){});
            if(memberInfoVo!=null){

                session.setAttribute(MemberConstant.LOGIN_USER, memberInfoVo);   //set session
                MemberInfoVo memberInfoVo1 = new MemberInfoVo();
                BeanUtils.copyProperties(memberInfoVo,memberInfoVo1);
                memberInfoVo1.setId(0);
                memberInfoVo1.setParentId(0);
                return R.ok().put("type","1").put("memberInfo", memberInfoVo1);
            }

        }else if(resultNum==2){
            EmployeeVo employeeVo = result.getData(new TypeReference<EmployeeVo>(){});

            if(employeeVo!=null){
                session.setAttribute(MemberConstant.LOGIN_USER, employeeVo);   //set session
                EmployeeVo employeeVo1 = new EmployeeVo();
                BeanUtils.copyProperties(employeeVo,employeeVo1);
                employeeVo1.setId("");
                employeeVo1.setSsn("");
                employeeVo1.setParentId(0);
                return R.ok().put("type","2").put("employeeInfo", employeeVo1);
            }
        }else if(resultNum==3){

            return R.error(402,"Account or password Not correct");
        }
        return R.error(402,"Ple contact Admin");
    }


    @GetMapping("/")
    public String userLogin3() {
        return "Hello";
    }

    @PostMapping("/logout")
    public R userLogOut(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute(MemberConstant.LOGIN_USER);
//        MemberInfoVo memberInfoVo = (MemberInfoVo) session.getAttribute(MemberConstant.LOGIN_USER)
        R r = new R();
        return r.ok();
    }

    /**
     * Member Registration
     * @param signUpVo
     * @param result
     * @return
     */
    @PostMapping("/signUp")
    public R userLogin2(@Valid @RequestBody SignUpVo signUpVo, BindingResult result ) {

        if (result.hasErrors()) {
            Map<String, String> error = new HashMap<>();
            List<FieldError> fieldErrors = result.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                if (!error.containsKey(fieldError.getField())) {
                    error.put(fieldError.getField(), fieldError.getDefaultMessage());
                }
            }
            return R.error(401,"Error").setData(error);
        }

        UserRegistVo userRegistVo = new UserRegistVo(signUpVo.getUserName(), signUpVo.getPasswords());
        MemberInfoVo memberInfoVo = new MemberInfoVo(signUpVo.getFirstName(), signUpVo.getLastName(), signUpVo.getPhoneNumber(), signUpVo.getEmail());
        R r = new R();
        try {
            r = userService.signUp(userRegistVo, memberInfoVo);
        } catch (Exception e) {

            return r.error(501,"Unknown Error. Ple contact with admin");
        }
        return r;
    }

    @PostMapping("/update_delivery_info")
    public R deliveryUpdate(@Valid @RequestBody EmployeeVo updateVo, BindingResult result,HttpServletRequest request ) {

        if (result.hasErrors()) {
            Map<String, String> error = new HashMap<>();
            List<FieldError> fieldErrors = result.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                if (!error.containsKey(fieldError.getField())) {
                    error.put(fieldError.getField(), fieldError.getDefaultMessage());
                }
            }
            System.out.println(error);
            return R.error(101,"Error").setData(error);
        }

        EmployeeVo existVo = (EmployeeVo) request.getSession().getAttribute(MemberConstant.LOGIN_USER);

        int i = userService.updateDeliveryInfo(updateVo, existVo);

        R r = new R();
        if(i==1)
            return r.ok().setData(updateVo);
        else
            return R.error(102,"Update fail. Ple contact to admin");
    }

}
