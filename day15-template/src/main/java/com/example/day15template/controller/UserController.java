package com.example.day15template.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.day15template.common.R;
import com.example.day15template.pojo.User;
import com.example.day15template.service.UserService;
import com.example.day15template.utils.JwtUtils;
import com.example.day15template.utils.MsgUtils;
import com.example.day15template.utils.ValidateCodeUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.HttpRequest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private UserService userService;

    @PostMapping("/sendMsg")
    public R<String> sendMsg(@RequestBody User user){
        String code = ValidateCodeUtils.generateValidateCode(4).toString();
        MsgUtils msgUtils = new MsgUtils();
        msgUtils.sendMsg(user.getPhone(),code);
        stringRedisTemplate.opsForValue().set(user.getPhone(), code,5, TimeUnit.MINUTES);
        return R.success("成功发送验证码到手机");
    }

    @Transactional
    @PostMapping("/login")
    public R<String> login(HttpServletRequest request, @RequestBody User user){
        ValueOperations valueOperations = stringRedisTemplate.opsForValue();
        String code = valueOperations.get(user.getPhone()).toString();
        String phone = user.getPhone();
        if (StringUtils.isNotEmpty(code)&&  (code.equals(user.getCode()))   ) {
            // 判断是否为新用户
            LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
            userLambdaQueryWrapper.eq(User::getPhone,phone);
            if (userService.count(userLambdaQueryWrapper)==0){
                user.setStatus(1);
                userService.save(user);
            }
            Map<String, Object> claims = new HashMap<>();
            claims.put("phone", phone);
            String jwt = JwtUtils.generateJwt(claims);
            request.getSession().setAttribute("user",jwt);
            log.info(jwt);
            return R.success("登录成功");
        }else {
            return R.error("该手机号未得到有效验证码");
        }


    }


}
