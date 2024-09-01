package com.example.controller;

import com.example.pojo.Emp;
import com.example.pojo.Result;
import com.example.service.EmpService;
import com.example.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class LoginController {
    @Autowired
    private EmpService empService;

    @Autowired
    private JwtUtils jwtUtils;
    @PostMapping("/login")
    public Result login(@RequestBody Emp emp){
        log.info("正在进行用户名密码登录操作:{},{}",emp.getUsername(),emp.getPassword());
        Emp e = empService.login(emp);

        // 登录校验下发令牌
        if (e!=null){
            Map<String, Object> claims = new HashMap<>();
            claims.put("id",emp.getId());
            claims.put("name", emp.getName());
            claims.put("username", emp.getUsername());
            String jwt = JwtUtils.generateJwt(claims);
            return Result.success(jwt);
        }
        return Result.error("用户名或密码错误");
    }

}
