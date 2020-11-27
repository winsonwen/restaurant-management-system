package com.project.restaurant.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.project.restaurant.vo.LocationVo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: Junxiang Wen
 * @date: 11/22/2020 2:53 PM
 * @description:
 */
@Mapper
public interface DeliverOrderDao  extends BaseMapper<LocationVo> {
}
