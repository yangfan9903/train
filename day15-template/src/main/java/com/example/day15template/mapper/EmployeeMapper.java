package com.example.day15template.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.day15template.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
    @Select("select * from employee where username=#{username} and password=#{password}")
    Employee SelectByUsernameAndPass(Employee employee);
}
