package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SmartFurnitureSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Furniture> furnitures = new ArrayList<>();
        furnitures.add(new Tv("Tv", Location.BEDROOM, true, 10));
        furnitures.add(new Fan("Fan", Location.BATHROOM, true, 2));
        furnitures.add(new Fan("Fan", Location.KITCHEN, false, 3));
        ;
        furnitures.add(new Tv("Tv", Location.LIVINGROOM, false, 5));
        System.out.println("====家庭智能家具操作系统启动====");
        System.out.println("下面显示全部的家电信息");
        int i = 1;
        for (Furniture furniture : furnitures) {
            System.out.print(i + ".");
            System.out.println(furniture);
            i++;
        }
        while (true) {
            System.out.println("请输入要操作的家具编号(输入0退出程序)：");
            int index = sc.nextInt();
            switch (index) {
                case 1:
                    System.out.println("输入1调整设备状态");
                    System.out.println("输入2操作设备");
                    switch (sc.nextInt()) {
                        case 1:
                            furnitures.get(0).furnitureSwitch();
                            break;
                        case 2:
                            furnitures.get(0).furnitureOperation();
                            break;
                    }
                    break;
                case 2:
                    System.out.println("输入1调整设备状态");
                    System.out.println("输入2操作设备");
                    switch (sc.nextInt()) {
                        case 1:
                            furnitures.get(1).furnitureSwitch();
                            break;
                        case 2:
                            furnitures.get(1).furnitureOperation();
                            break;
                    }
                    break;
                case 3:
                    System.out.println("输入1调整设备状态");
                    System.out.println("输入2操作设备");
                    switch (sc.nextInt()) {
                        case 1:
                            furnitures.get(2).furnitureSwitch();
                            break;
                        case 2:
                            furnitures.get(2).furnitureOperation();
                            break;
                    }
                    break;
                case 4:
                    System.out.println("输入1调整设备状态");
                    System.out.println("输入2操作设备");
                    switch (sc.nextInt()) {
                        case 1:
                            furnitures.get(3).furnitureSwitch();
                            break;
                        case 2:
                            furnitures.get(3).furnitureOperation();
                            break;
                    }
                    break;
                case 0:
                    System.out.println("====程序退出====");
                    return;
                    default:
                        System.out.println("输入错误，请重新输入");
                        break;

            }

        }

    }
}
