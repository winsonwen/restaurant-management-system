
package com.project.restaurant.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.project.restaurant.R;
import com.project.restaurant.constant.MemberConstant;
import com.project.restaurant.service.UserService;
import com.project.restaurant.vo.*;
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

        R result = userService.loginRequest(vo);
        if(result==null)
            return R.error(402,"Account Not Exists");

        int resultNum = (int)result.get("result");   // 2->employee   1->customer

        if (resultNum==1){
            MemberInfoVo memberInfoVo = result.getData(new TypeReference<MemberInfoVo>(){});
            if(memberInfoVo!=null){
                R r = new R();
//                String uuid = UUID.randomUUID().toString().replace("-", "");
//                memberInfoVo.setToken(uuid);
//                stringRedisTemplate.opsForValue().set(MemberConstant.LOGIN_USER+uuid,JSON.toJSONString(memberInfoVo),1440,TimeUnit.MINUTES);
//               stringRedisTemplate.opsForValue().set("1111","2222",1440,TimeUnit.MINUTES);
                session.setAttribute(MemberConstant.LOGIN_USER, memberInfoVo);   //set session
                return R.ok().put("type","1").put("memberInfo", memberInfoVo);
            }

        }else if(resultNum==2){
            EmployeeVo employeeVo = result.getData(new TypeReference<EmployeeVo>(){});

            if(employeeVo!=null){
//                String uuid = UUID.randomUUID().toString().replace("-", "");
                employeeVo.setEmployeeId("");
//                employeeVo.setToken(uuid);
//              stringRedisTemplate.opsForValue().set(MemberConstant.LOGIN_USER+uuid, JSON.toJSONString(employeeVo),1440,TimeUnit.MINUTES);
                session.setAttribute(MemberConstant.LOGIN_USER, employeeVo);   //set session
                return R.ok().put("type","2").put("employeeInfo", employeeVo);
            }
        }
        return R.error(402,"Account Not Exists");
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

            return r.error(501,"Unknown");
        }
        return r;
    }

    @GetMapping("/")
    public String userLogin3() {
        return "Hello";
    }

    @PostMapping("/logout")
    public R userLogOut(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute(MemberConstant.LOGIN_USER);
//        MemberInfoVo memberInfoVo = (MemberInfoVo) session.getAttribute(MemberConstant.LOGIN_USER);

        R r = new R();
        return r.ok();
    }


}
