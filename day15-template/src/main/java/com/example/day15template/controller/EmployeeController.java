package com.example.day15template.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.day15template.common.BaseContext;
import com.example.day15template.common.R;
import com.example.day15template.pojo.Employee;
import com.example.day15template.service.EmployeeService;
import com.example.day15template.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

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

    @PostMapping
    public R<String> save(HttpServletRequest request,@RequestBody Employee emp){
        emp.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));
//        emp.setUpdateTime(LocalDateTime.now());
//        emp.setCreateTime(LocalDateTime.now());
        String jwt = (String)request.getSession().getAttribute("employee");
        try {
            JwtUtils.parseJwt(jwt);
//            log.info(claims.get("id").toString());

        } catch (Exception e) {
            return R.error("非法修改员工信息");
        }
        Claims claims = JwtUtils.parseJwt(jwt);
        Long empId = Long.parseLong(claims.get("id").toString());
//        employee.setUpdateUser(empId);
        BaseContext.setCurrentId(empId);
//        Claims claims = JwtUtils.parseJwt(jwt);
//        Long empId = Long.parseLong(claims.get("id").toString());
////            Long empId = (Long) claims.get("id");
//        emp.setCreateUser(empId);
//        emp.setUpdateUser(empId);
        employeeService.save(emp);
        return R.success("成功添加员工信息");


    }

    /**
     * 员工信息分页查询
     * @param page
     * @param pageSize
     * @param name
     * @return
     */
    @GetMapping("/page")
    public R<Page> page(int page,int pageSize,String name){
        // 构造分页构造器
        Page<Employee> pageInfo = new Page<>(page,pageSize);
        // 构造条件构造器
        LambdaQueryWrapper<Employee> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        // 添加查询条件
        lambdaQueryWrapper.like(StringUtils.isNotEmpty(name),Employee::getName,name);
        // 添加排序条件
        lambdaQueryWrapper.orderByDesc(Employee::getUpdateTime);
//        System.out.println(pageInfo);
        employeeService.page(pageInfo,lambdaQueryWrapper);
//        System.out.println(pageInfo);
        return R.success(pageInfo);
    }

    /**
     * 根据id修改员工信息
     * @param employee
     * @return
     */
    @PutMapping
    public R<String> update(HttpServletRequest request, @RequestBody Employee employee){
        log.info("=========线程id{}",Thread.currentThread().getId());
        String jwt = (String)request.getSession().getAttribute("employee");
        log.info(jwt);
        try {
            JwtUtils.parseJwt(jwt);
//            log.info(claims.get("id").toString());

        } catch (Exception e) {
            return R.error("非法修改员工信息");
        }
        Claims claims = JwtUtils.parseJwt(jwt);
        Long empId = Long.parseLong(claims.get("id").toString());
//        employee.setUpdateUser(empId);
        BaseContext.setCurrentId(empId);
//        employee.setUpdateTime(LocalDateTime.now());
        employeeService.updateById(employee);
        return R.success("成功修改");
    }

    /**
     * 根据id查询员工信息
     * @param empId
     * @return
     */
    @GetMapping("/{id}")
    public R<Employee> getById(@PathVariable(name = "id") Long empId){
        Employee emp = employeeService.getById(empId);
        if (emp!=null){
            return R.success(emp);
        }else{
            return R.error("没有查询到对应得员工信息");
        }

    }


}
