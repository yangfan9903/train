package com.example.lambdaDemo;

public class Demo1 {
    public static void main(String[] args) {
        Animal a = new Animal() {
            @Override
            void eat(){
                System.out.println("吃东西");
            }
        };
        // Lambda不能用在重写抽象方法的匿名内部类中，只能用在函数式接口中
//        Anima a = ()->{System.out.println("吃东西");};
        Swim b = new Swim() {
            @Override
            public void swimming(){
                System.out.println("游泳");
            }
        };
        Swim b1 = ()->{
            System.out.println("游泳");
        };
        a.eat();
        b1.swimming();
    }
}
abstract class Animal{
    abstract void eat();
}
@FunctionalInterface
interface Swim{
    void swimming();
}
