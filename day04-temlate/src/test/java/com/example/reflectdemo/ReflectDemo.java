package com.example.reflectdemo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
@Slf4j
public class ReflectDemo {
    @Test
    void getConstructInfo() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
//        Dog dog = new Dog("小黑", 3);
//        以上内容会报错，因为构造器是私有的，不能被外部访问,所以可以使用暴力反射
        // 获取Dog类
        Class dogClass = Dog.class;
        // 打印类名
        System.out.println(dogClass.getSimpleName());


        // 获取构造器对象
        Constructor[] con0 = dogClass.getDeclaredConstructors();
        for (Constructor con : con0) {
            System.out.println(con.getName() + "(" + con.getParameterCount() + ")");
        }
        // 获取无参构造器
        Constructor con = dogClass.getDeclaredConstructor();
        System.out.println(con.getName() + "(" + con.getParameterCount() + ")");
        // 获取单个构造器
        Constructor con1 = dogClass.getDeclaredConstructor(String.class);
        System.out.println(con1.getName() + "(" + con1.getParameterCount() + ")");
        // 获取构造器得作用仍然是创建对象
        con1.setAccessible(true);
        Dog d1 = (Dog) con1.newInstance("小狗");

    }
    @Test
    void getFieldInfo() throws NoSuchFieldException, IllegalAccessException {
        Class dog = Dog.class;
        // 获取全部的成员变量
        Field[] fields = dog.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName() + "(" + field.getType() + ")");
        }
        // 获取单个的成员变量
        Field field = dog.getDeclaredField("name");
        System.out.println(field.getName() + "(" + field.getType() + ")");
        Dog d1 = new Dog("金毛",3);
        // 获取性别成员变量
        Field field1 = dog.getDeclaredField("sex");
        // 操作性别成员变量
        field1.setAccessible(true);
        field1.set(d1,"公");
        field.setAccessible(true);
        System.out.println(field.get(d1));

    }
}
