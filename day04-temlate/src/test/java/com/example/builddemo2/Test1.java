package com.example.builddemo2;

public class Test1 {
    public static void main(String[] args) {
//        类型是Phone 但是在建造者创建然后再用build方法就可以返回Phone类型
        Phone OnePlus = new PhoneBuilder().buildPower(4000)
                .buildSize(6.5)
                .buildSound("sound")
                .buildMemory(16)
                .buildCpu("骁龙888")
                .buildColor("black")
                .buildCamera("双摄")
                .buildName("一加").build();
        System.out.println(OnePlus);

    }
}
