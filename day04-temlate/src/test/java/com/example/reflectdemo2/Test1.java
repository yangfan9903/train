package com.example.reflectdemo2;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class Test1 {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        //只能添加String类型其他类型会报错
//        list.add(12);
        // 使用反射绕过泛型
        Class a1 = list.getClass();
        Method add = a1.getDeclaredMethod("add", Object.class);
        add.invoke(list,12);
        System.out.println(list);
    }
}
