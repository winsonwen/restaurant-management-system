package com.project.restaurant.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.project.restaurant.vo.MemberInfoVo;
import com.project.restaurant.vo.UserRegistVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MemberDao extends BaseMapper<MemberInfoVo> {



    int getMaxID();

}
