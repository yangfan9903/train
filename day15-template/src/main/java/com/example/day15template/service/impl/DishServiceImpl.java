package com.example.day15template.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.day15template.mapper.DishMapper;
import com.example.day15template.pojo.Dish;
import com.example.day15template.service.DishService;
import org.springframework.stereotype.Service;

@Service
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish> implements DishService {
}
