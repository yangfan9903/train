package com.test.train;

import java.util.Random;
import java.util.Scanner;

public class guessNumber {
    public static void main(String[] args) {
        //生成1-100的随机整数
        System.out.println("=====随机数游戏开始=====");
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        int randomInt = random.nextInt(100)+1;
        while (true) {
            System.out.println("请输入您猜测的数");
            int guess = sc.nextInt();
            if (guess > randomInt){
                System.out.println("您猜测的数过大");
            }else if (guess < randomInt){
                System.out.println("您猜测的数过小");
            }else{
                System.out.println("恭喜您猜对了");
                break;
            }
        }


    }
}
