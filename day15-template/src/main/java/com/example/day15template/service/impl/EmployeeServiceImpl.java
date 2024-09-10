package com.example.day15template.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.day15template.common.R;
import com.example.day15template.mapper.EmployeeMapper;
import com.example.day15template.pojo.Employee;
import com.example.day15template.service.EmployeeService;
import com.example.day15template.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private JwtUtils jwtUtils;

    /**
     * 新增员工ijj
     * @param emp
     */


    @Override
    public R<Employee> login(HttpServletRequest request,Employee employee) {
        // 1.将密码进行反加密
        String password = employee.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());

        // 2.查询对应用户名在数据库中是否存在若不存在则返回 “用户名不存在”错误信息
        QueryWrapper<Employee> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",employee.getUsername());
        Employee e = employeeMapper.selectOne(queryWrapper);
        if (e==null){
            return R.error("用户名不存在");
        }

        // 3.若用户名存在则判断密码是否相等若不相等则返回 "密码错误"
        if(!e.getPassword().equals(password)){
            return R.error("密码错误");
        }

        // 4.若正确判断用户的状态是否被禁用若被禁用返回 "账号已禁用"
        if(e.getStatus().equals(0)){
            return R.error("该用户已被禁用");
        }
        // 5.登录成功则返回，则将员工Id存在session中
        Map<String, Object> claims = new HashMap<>();
        claims.put("id",e.getId());
        claims.put("name", e.getName());
        claims.put("username",e.getUsername());
        String jwt = JwtUtils.generateJwt(claims);
        log.info(jwt);
        request.getSession().setAttribute("employee",jwt);
//        log.info(request.getRequestURI());
//        log.info(JSON.toJSONString(request.getSession().getAttribute("employee")));
        return R.success(e);

    }
}
