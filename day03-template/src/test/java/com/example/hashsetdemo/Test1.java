package com.example.hashsetdemo;

import java.util.HashSet;

public class Test1 {
    public static void main(String[] args) {
        HashSet<Student> students = new HashSet<>();
        students.add(new Student("张三", 18, "男","123123"));
        students.add(new Student("李四", 19, "男","312341"));
        students.add(new Student("张三", 18, "男","123123"));
        students.add(new Student("赵六", 21, "男","4214512"));
        System.out.println(students);
    }
}
