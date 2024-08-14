package day01.train.scr.main.java.com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindPrimeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=====寻找质数程序启动=====");
        System.out.println("请输入您想找的素数范围的最大值");
        int maxnum = sc.nextInt();
        System.out.println("请输入您想要找的素数范围的最小值");
        int minnum = sc.nextInt();
        List<Integer> primeNumberList = findPrimeNumber(maxnum,minnum);
        System.out.println("您要找的素数列如下：");
        System.out.println(primeNumberList);


    }
    public static List<Integer> findPrimeNumber(int maxnum,int minnum){
        List<Integer> primeNumberList = new ArrayList<>();
        for (int i = minnum; i <= maxnum; i++) {
            for (int j = 2; j < i/2; j++) {
                if (i % j == 0){
                    break;
                }
                if (j == i/2-1){
                    primeNumberList.add(i);
                }
            }
        }
        return primeNumberList;
    }
}
