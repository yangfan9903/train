package com.example.day15template.controller;

import com.example.day15template.common.R;
import com.example.day15template.pojo.Employee;
import com.example.day15template.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    /**
     * 员工登录
     * @param request
     * @param employee
     * @return
     */
    @PostMapping("/login")
    public R<Employee> login(HttpServletRequest request,@RequestBody Employee employee){
        log.info("正在登录的用户名为{},密码为{}",employee.getUsername(),employee.getPassword());
        return employeeService.login(request,employee);
    }
    
    @PostMapping("/logout")
    public R<String> loginout(HttpServletRequest request){
        request.getSession().removeAttribute("employee");
        return R.success("成功清除session");
    }


}
