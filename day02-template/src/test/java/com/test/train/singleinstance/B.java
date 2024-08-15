package com.test.train.singleinstance;
// 单例类2
// 用对象的时候才创建对象
public class B {
    //1.私有化构造器
    private B(){

    }
    //2.定义类变量存储对象
    private static B b;
    //3.提供一个类方法返回对象
    //要求创建对现象
    public static B getInstance(){
        if (b==null){
            b = new B();
        }
        return b;
    }
}
