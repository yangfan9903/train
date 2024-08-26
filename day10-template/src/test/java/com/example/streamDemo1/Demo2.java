package com.example.streamDemo1;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Demo2 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("zhangsan, 23");
        list.add("lisi, 24");
        list.add("wangwu, 25");
        Map<String, Integer> roles = new HashMap<>();

        roles = list.stream()
                .filter(x-> Integer.parseInt(x.split(", ")[1])>=24)
                .collect(Collectors.toMap(x-> x.split(", ")[0], x-> Integer.parseInt(x.split(", ")[1])));
        System.out.println(roles);
    }
}
