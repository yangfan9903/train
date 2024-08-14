package day01;

import java.util.Random;
import java.util.Scanner;

public class verifycode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        System.out.println("=====验证码生成程序启动=====");
        while (true){
            System.out.println("输入任意字符开始程序(输入0结束程序)");
            String start = sc.next();
            if (start.equals("0")){
                System.out.println("=====程序结束=====");
                break;
            }
            System.out.println("请输入要生成的验证码位数");
            int num = sc.nextInt();
            String code = "";
            for (int i = 0; i < num; i++) {
                int randomtype = random.nextInt(3);
                switch (randomtype){
                    case 0:
                        code = code + random.nextInt(10);
                        break;
                    case 1:
                        code = code + getRandomBigLetter();
                        break;
                    case 2:
                        code = code + getRandomSmallLetter();
                        break;
                }

            }
            System.out.println("生成的验证码为" + code);

        }

    }
    public static String getRandomBigLetter(){
        Random random = new Random();
        int randomnum = random.nextInt(26)+65;
        return Character.toString((char)randomnum);
    }
    public static String getRandomSmallLetter(){
        Random random = new Random();
        int randomnum = random.nextInt(26)+97;
        return Character.toString((char)randomnum);
    }


}
