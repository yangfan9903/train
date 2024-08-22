package com.example.lambdaDemo2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Demo1 {
    public static void main(String[] args) {
        Student[] students = new Student[5];
        students[0] = new Student("张三", 18, 100.0);
        students[1] = new Student("李四", 19, 80.0);
        students[2] = new Student("王五", 20, 70.0);
        students[3] = new Student("赵六", 21, 120.0);
        students[4] = new Student("钱七", 22, 110.0);
        for (Student student : students) {
            System.out.println(student);
        }
//        Arrays.sort(students, new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                return (int) (o1.getSalary()-o2.getSalary());
//            }
//        });
        Arrays.sort(students, (Student o1, Student o2)-> {
            return (int) (o1.getSalary()-o2.getSalary());
        });
        // 1. 参数类型可以全部省略不写
        // 2. 如果参数只有一个，参数的括号也可以删掉省略
        // 3. 如果Lambda表达式中只有一行代码，大括号可以不写，同时要省略分号";" 如果这一行代码式return语句 return也需要取消
        for (Student student : students) {
            System.out.println(student);
        }

    }
}
