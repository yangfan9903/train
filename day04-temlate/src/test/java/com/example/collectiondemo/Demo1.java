package com.example.collectiondemo;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Slf4j
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
        String list2 = list.toString();
        log.info(list2);
        log.info("=========================");

        Collections.shuffle(list);
        log.info(list.toString());
        log.info("=========================");

        String a = "dasdas";
        String b = "weqdas";


//        Collections.sort(list,(o1, o2) -> compareTo(o1,o2));
        Collections.sort(list);
        log.info(list.toString());
        log.info("=========================");

        List<Teacher> teacherList = new ArrayList<>();
        teacherList.add(new Teacher("张三", 20, 10000));
        teacherList.add(new Teacher("赵六", 50, 40000));
        teacherList.add(new Teacher("李四", 30, 20000));
        teacherList.add(new Teacher("王五", 40, 30000));
        log.info(teacherList.toString());
        log.info("=========================");
        Collections.sort(teacherList, (o1, o2) -> o1.getAge() - o2.getAge());
        log.info(teacherList.toString());
        log.info("=========================");


    }
}
