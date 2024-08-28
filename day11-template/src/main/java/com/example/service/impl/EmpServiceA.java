package com.example.service.impl;

import com.example.dao.EmpDao;
import com.example.dao.impl.EmpDaoA;
import com.example.pojo.Emp;
import com.example.pojo.Result;
import com.example.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class EmpServiceA implements EmpService {
    @Autowired
    private EmpDao empDao;
    @Override
    public List<Emp> listEmp() {
        List<Emp> empList =  empDao.listEmp();
        empList.stream().forEach(s->{
            if ("1".equals(s.getGender())){
                s.setGender("男");
            }else {
                s.setGender("女121");
            }
            if ("1".equals(s.getJob())){
                s.setJob("讲师");
            }else if ("2".equals(s.getJob())){
                s.setJob("班主任");
            }else {
                s.setJob("就业指导");
            }
        });
        return empList;
    }
}
