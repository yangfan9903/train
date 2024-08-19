package com.example.reflectdemo;

import java.security.PublicKey;

public class Dog {
    private String name;
    private int age;
    private String sex;

    public Dog() {
    }
    private Dog(String name) {
        System.out.println("一个参数的构造器执行了");
        this.name = name;
    }

    public Dog(String name, int age) {
        System.out.println("两个参数的构造器执行了");
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
