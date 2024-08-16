package com.example.streamdemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Test1 {
    public static void main(String[] args) {
        List<Teacher> teacherList = new ArrayList<>();
        teacherList.add(new Teacher("张三", 20, 10000));
        teacherList.add(new Teacher("赵六", 50, 40000));
        teacherList.add(new Teacher("李四", 30, 20000));
        teacherList.add(new Teacher("王五", 40, 30000));

        teacherList.stream().filter(s->s.getSalary()>20000).forEach(System.out::println);

        Optional<Teacher> max = teacherList.stream().max((o1, o2)->Double.compare(o1.getSalary(), o2.getSalary()));
        Teacher maxTeacher = max.get();
        System.out.println(maxTeacher);

        // 流的收集操作
        System.out.println("============流收集操作如下==================");
        List<Teacher> teacher1 = teacherList.stream().sorted((o1, o2)->Double.compare(o1.getSalary(), o2.getSalary())).collect(Collectors.toList());
        System.out.println(teacher1);
        System.out.println("============流收集为map操作如下==================");
        Map<String, Double> teacherMap = teacherList.stream().collect(Collectors.toMap(Teacher::getName, Teacher::getSalary));
        System.out.println(teacherMap);
    }
}
