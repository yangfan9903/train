package com.example.day15template.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.day15template.common.R;
import com.example.day15template.pojo.Employee;

import javax.servlet.http.HttpServletRequest;

public interface EmployeeService extends IService<Employee> {

    R<Employee> login(HttpServletRequest request, Employee employee);
}
