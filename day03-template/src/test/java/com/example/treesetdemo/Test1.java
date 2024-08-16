package com.example.treesetdemo;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Test1 {
    public static void main(String[] args) {
        Set<Teacher> teachers = new TreeSet<>(new Comparator<Teacher>() {
            @Override
            public int compare(Teacher o1, Teacher o2) {
                if (o1.getAge() >= o2.getAge()) return 1;
                else return -1;
            }
        });
        teachers.add(new Teacher("张三", 20, 10000));
        teachers.add(new Teacher("李四", 30, 20000));
        teachers.add(new Teacher("王五", 40, 30000));
        teachers.add(new Teacher("赵六", 30, 20000));
        // 第一种在类中定义比较方法,实现接口
        // 第二种可以通过匿名内部类的方法改写
        System.out.println(teachers);


    }
}
