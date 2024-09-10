package com.example.day15template.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.day15template.mapper.SetmealMapper;
import com.example.day15template.pojo.Setmeal;
import com.example.day15template.service.SetmealService;
import org.springframework.stereotype.Service;

@Service
public class SetmealServiceImpl extends ServiceImpl<SetmealMapper, Setmeal> implements SetmealService {
}
