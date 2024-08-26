package com.example.streamDemo2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo3 {
    public static void main(String[] args) {
        List<String> manList = new ArrayList<>();
        List<String> womanList = new ArrayList<>();
        manList.add("杨帆,18");
        manList.add("李四一,22");
        manList.add("张三,19");
        manList.add("王五,21");
        manList.add("刘桓瑜,42");
        manList.add("王五是,21");
        womanList.add("杨四二,20");
        womanList.add("王五,21");
        womanList.add("王五八,22");
        womanList.add("杨四,20");
        womanList.add("杨五流,21");
        womanList.add("王五说,42");
        Stream<String> stream1 = manList.stream()
                .filter(x -> x.split(",")[0].length() == 3)
                .limit(2);
        Stream<String> stream2 = womanList.stream()
                .filter(x -> x.split(",")[0].startsWith("杨"))
                //不要第一个
                .skip(1);
        Stream.concat(stream1, stream2).map(x->{
            return new Actor(x.split(",")[0], Integer.parseInt(x.split(",")[1]));
        }).forEach(System.out::println);


    }
}
