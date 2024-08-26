package com.example.streamDemo1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Demo1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            list.add(i);
        }
        List<Integer> newList = list.stream().filter(x-> x%2 == 0).collect(Collectors.toList());
    }
}
