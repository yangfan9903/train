package com.example.hashmapdemo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Test1 {
    public static void main(String[] args) {
        Map<String,Integer> people = new HashMap<>();
        people.put("张三", 18);
        people.put("李四", 19);
        people.put("王五", 20);
        System.out.println(people);
        // 第一种遍历方式通过取出其中的键值然后遍历
//        Set<String> keySet = people.keySet();
//        for (String key : keySet) {
//            System.out.println(people.get(key));
//        }
        // 第二种通过键值对遍历
        Set<Map.Entry<String, Integer>> entrySet = people.entrySet();
        for (Map.Entry<String, Integer> entry : entrySet) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        // 第三种遍历方式Lambda
        people.forEach((k, v) -> System.out.println(k + ":" + v));

    }
}
