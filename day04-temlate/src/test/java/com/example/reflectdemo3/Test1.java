package com.example.reflectdemo3;

public class Test1 {
    public static void main(String[] args) throws Exception {
        Dog d = new Dog("金毛", 2, "公");
        Teacher t = new Teacher("张三", 20, 10000);
        SaveObjectFrameWork.saveObject(d);
        SaveObjectFrameWork.saveObject(t);

    }
}
