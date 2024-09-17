package com.example.day15template.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.day15template.mapper.UserMapper;
import com.example.day15template.pojo.User;
import com.example.day15template.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
