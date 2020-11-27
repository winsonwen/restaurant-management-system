package com.project.restaurant.service.ServiceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.project.restaurant.dao.MemberDao;
import com.project.restaurant.service.MemberService;
import com.project.restaurant.vo.MemberInfoVo;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl extends ServiceImpl<MemberDao, MemberInfoVo> implements MemberService {


}

