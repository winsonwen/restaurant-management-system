package com.project.restaurant.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.project.restaurant.vo.EmployeeVo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: Junxiang Wen
 * @date: 10/8/2020 4:10 PM
 * @description:
 */
@Mapper
public interface EmployeeDao extends BaseMapper<EmployeeVo> {
}
