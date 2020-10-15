package com.project.restaurant.service.UserServiceImpl;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.project.restaurant.R;
import com.project.restaurant.dao.EmployeeDao;
import com.project.restaurant.dao.MemberDao;
import com.project.restaurant.dao.UserDao;
import com.project.restaurant.service.UserService;
import com.project.restaurant.vo.EmployeeVo;
import com.project.restaurant.vo.MemberInfoVo;
import com.project.restaurant.vo.UserLoginVo;
import com.project.restaurant.vo.UserRegistVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;


@Service
public class UserServiceImpl extends ServiceImpl<UserDao, UserRegistVo> implements UserService {

    @Resource
    MemberDao memberDao;
    @Resource
    UserDao userDao;
    @Resource
    EmployeeDao employeeDao;

    /**
     * Update new User infomation
     *
     * @param vo
     * @param mvo
     * @return
     * @throws Exception When MySql's insertion failure
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public synchronized R signUp(UserRegistVo vo, MemberInfoVo mvo) throws Exception {

        Integer mobile = baseMapper.selectCount(new QueryWrapper<UserRegistVo>().eq("user_name", vo.getUserName()));

        if (mobile != 0) {
            Map<String, String> error = new HashMap<>();
            error.put("userName","User Name exist");
            return R.error(401,"Error").setData(error);
        }

        int result;
        memberDao.insert(mvo);
        result = memberDao.getMaxID();
        if (result == 0) {
            throw new Exception();
        }
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        String encode = passwordEncoder.encode(vo.getPasswords());
        vo.setMemberId(result);
        vo.setPasswords(vo.getPasswords());

        result = userDao.insert(vo);
        if (result == 0) {
            throw new Exception();
        }
        return R.ok();

    }

    @Override
    public R loginRequest(UserLoginVo vo) {

        UserRegistVo userRegistVo = baseMapper.selectOne(new QueryWrapper<UserRegistVo>().eq("user_name", vo.getUserName()));
        if (userRegistVo == null) {
            return null;
        } else {
            String password1 = userRegistVo.getPasswords();
//            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//            if (bCryptPasswordEncoder.matches(vo.getPasswords(), password1)) {

            if (vo.getPasswords().equals(password1)) {
                if(userRegistVo.getEmployeeId()!=0){

                    EmployeeVo employeeVo = employeeDao.selectById(userRegistVo.getEmployeeId());
                    if(employeeVo!=null)
                        return R.ok().setData(employeeVo).put("result", 2);

                }else if(userRegistVo.getMemberId()!=0){
                    MemberInfoVo memberInfoVo = memberDao.selectById(userRegistVo.getMemberId());
                    if(memberInfoVo!=null)
                        return R.ok().setData(memberInfoVo).put("result", 1);
                }
            }
        }


        return null;
    }
}
