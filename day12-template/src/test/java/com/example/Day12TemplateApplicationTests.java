package com.example;

import com.example.mapper.EmpMapper;
import com.example.mapper.UserMapper;
import com.example.pojo.Emp;
import com.example.pojo.User;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class Day12TemplateApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private EmpMapper empMapper;
    @Test
    public void testEmpInsert(){
        Emp emp = new Emp();
        emp.setUsername("admin");
        emp.setName("杨帆");
        emp.setGender(1);
        emp.setImage("1.jpg");
        emp.setEntrydate(LocalDate.of(2020,1,1));
        emp.setDeptId(1);
        emp.setJob(1);
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.insert(emp);

    }
    @Test
    public void testEmpUpdate(){
        Emp emp = new Emp();
        emp.setUsername("admin1");
        emp.setName("杨帆1");
        emp.setGender(2);
        emp.setImage("2.jpg");
        emp.setEntrydate(LocalDate.of(2020,1,1));
        emp.setDeptId(1);
        emp.setJob(1);
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        emp.setId(18);
        empMapper.update(emp);

    }
    @Test
    public void testEmpUpdate2(){
        Emp emp = new Emp();
        emp.setUsername("dasdasdasd");
        emp.setGender(2);
        emp.setImage("2.jpg");
        emp.setEntrydate(LocalDate.of(2020,1,1));
        emp.setDeptId(1);
        emp.setJob(1);
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        emp.setId(18);
        empMapper.update2(emp);

    }

    @Test
    public void testSelectEmpById(){
        Emp emp = new Emp();
        emp.setId(18);
        System.out.println(empMapper.selectById(18));
    }

    @Test
    public void testSelectConditionEmp(){
//         List<Emp> list = empMapper.selectCondition("张",1,LocalDate.of(2010,1,1),LocalDate.of(2020,1,1));
         List<Emp> list = empMapper.selectCondition("张",1,null,null);
         list.stream().forEach(System.out::println);
    }
//    public void testListEmp(){
//        empMapper.deleteEmpById(17);
//    }

    @Test
    public void testListUser(){
        List<User> list1 = userMapper.list();
        list1.stream().forEach(System.out::println);
    }

    @Test
    public void testDeleteEmpByIds(){
        List<Integer> ids = Arrays.asList(15,18);
        empMapper.deleteEmpByIds(ids);
    }

}
