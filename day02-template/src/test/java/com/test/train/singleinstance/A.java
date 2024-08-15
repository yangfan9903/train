package com.test.train.singleinstance;
// 设计单例设计模式
// 确保某个类只能创建一个对象
public class A {
    // 1.私有化构造器，防止外部创建过多对象,单例才有可能
    // 防止A a = new A(); A a1 = new A();创建过多对象
    private A(){

    }
    // 2.需要对外提供一个对象
    // 定义一个静态变量用于记住本类的唯一对象
    // public static A a = new A();可以用来定义但是有不足
    // 不能防止外部对该对象修改 比如说外部可以操作 A.a = null 唯一对象就被丢了
    // a.所以需要私有化对象,私有化对象，外界就不可以再修改了
    private static A a = new A();
    // b.使用final 关键字修饰变量，防止外界修改
    // public static final A a = new A();
    // 让外界可以获取对象
    public static A getInstance(){
        return a;
    }

}
