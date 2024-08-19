package com.example.collectiondemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Demo1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
//        list.add("hello");
//        list.add("world");
//        list.add("java");
//        list.add("人头马");
//        list.add("青花瓷");
        // 批量添加数据
        Collections.addAll(list,"hello","world","java","人头马","青花瓷");
        System.out.println(list);

        Collections.shuffle(list);
        System.out.println(list);

        String a = "dasdas";
        String b = "weqdas";


//        Collections.sort(list,(o1, o2) -> compareTo(o1,o2));
        Collections.sort(list);
        System.out.println(list);

        List<Teacher> teacherList = new ArrayList<>();
        teacherList.add(new Teacher("张三", 20, 10000));
        teacherList.add(new Teacher("赵六", 50, 40000));
        teacherList.add(new Teacher("李四", 30, 20000));
        teacherList.add(new Teacher("王五", 40, 30000));
        System.out.println(teacherList);
        Collections.sort(teacherList, (o1, o2) -> o1.getAge() - o2.getAge());
        System.out.println(teacherList);


    }
}
