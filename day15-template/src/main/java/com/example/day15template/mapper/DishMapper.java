package com.example.day15template.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.day15template.pojo.Dish;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DishMapper extends BaseMapper<Dish> {
}
