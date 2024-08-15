package com.test.train.innerclass1;
// 运用匿名内部类创建
public class Test1 {
    public static void main(String[] args) {
        // 调用抽象子类
//        cat a = new cat();
//        a.cry();
        // 使用匿名内部类创建
        // 匿名内部类本质是一个子类，同时会立即构建一个子类对象
        Animal cat = new Animal() {
            @Override
            public void cry(){
                System.out.println("喵喵喵");
            }
        };
        cat.cry();
    }

}
// 不使用匿名内部类地创建方法
class cat extends Animal{
    @Override
    public void cry()
    {
        System.out.println("喵喵喵");
    }
}