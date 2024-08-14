package day01.train.scr.main.java.com.test;

import java.util.Scanner;

public class Calculate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("=====计算器程序开始执行=====");
            System.out.println("输入任意符号开始程序(输入0结束程序)");
            String start = sc.next();
            if (start.equals("0")){
                System.out.println("=====计算器程序结束=====");
                break;
            }
            System.out.println("请输入对应计算的第一位数字");
            double a = sc.nextDouble();
            System.out.println("请输入对应计算的第二位数字");
            double b = sc.nextDouble();
            System.out.println("请输入对应运算符");
            String c = sc.next();
            switch (c){
                case "+":
                    System.out.println(a + "+" + b + "=" + add(a, b));
                    break;
                case "-":
                    System.out.println(a + "-" + b + "=" + sub(a, b));
                    break;
                case "*":
                    System.out.println(a + "*" + b + "=" + multi(a, b));
                    break;
                case "/":
                    if (b==0.0){
                        System.out.println("0不可以做除数");
                    }else {
                        System.out.println(a + "/" + b + "=" + div(a, b));
                    }
                    break;
                default:
                    System.out.println("输入的运算符有误");
            }

        }

        // 调用其他方法

    }

    // 在主程序前定义的方法
    public static double add(double a, double b) {
        return a+b;
    }

    public static double sub(double a, double b) {
        return a - b;
    }

    public static double multi(double a, double b) {
        return a * b;
    }

    public static double div(double a, double b) {
        // "=="是用来比较变量的值是否相等
        // "==="比较变量所引用的对象地址是否相等
        // ".equals"也可以用来判断字符串值是否相等
            return a / b;
    }




}
