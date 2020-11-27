package com.project.restaurant.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.project.restaurant.vo.OrderVo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: Junxiang Wen
 * @date: 11/22/2020 6:25 PM
 * @description:
 */
@Mapper
public interface OrderVoDao extends BaseMapper<OrderVo> {
}
