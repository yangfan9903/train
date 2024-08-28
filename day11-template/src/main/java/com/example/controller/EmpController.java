package com.example.controller;

import com.example.pojo.Emp;
import com.example.pojo.Result;
import com.example.utils.XmlParserUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmpController {
    @RequestMapping("/listEmp")
    public Result list(){
        // 动态代理
        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
        List<Emp> empList = XmlParserUtils.parse(file, Emp.class);
        empList.stream().forEach(s->{
            if ("1".equals(s.getGender())){
                s.setGender("男");
            }else {
                s.setGender("女");
            }
            if ("1".equals(s.getJob())){
                s.setJob("讲师");
            }else if ("2".equals(s.getJob())){
                s.setJob("班主任");
            }else {
                s.setJob("就业指导");
            }
        });
        return Result.success(empList);
    }
}
