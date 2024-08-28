package com.example.dao.impl;

import com.example.dao.EmpDao;
import com.example.pojo.Emp;
import com.example.utils.XmlParserUtils;

import java.util.List;

public class EmpDaoA implements EmpDao {
    @Override
    public List<Emp> listEmp() {
        // 动态代理
        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
        List<Emp> empList = XmlParserUtils.parse(file, Emp.class);
        return empList;
    }
}
