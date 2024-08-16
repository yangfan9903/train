package com.example.demo;

import java.util.Scanner;

public class Fan extends Furniture{
    Scanner sc = new Scanner(System.in);
    private int funSpeed;
    public Fan(String name, Location location, boolean status, int speed) {
        super(name, location, status);
        this.funSpeed = funSpeed;
    }

    @Override
    public void furnitureOperation() {
        System.out.println("*" + this.getLocation() + "的" + "当前风力的大小为：" + this.funSpeed);
        System.out.println("切换风力强度操作如下：");
        System.out.println("输入1增强一级风力");
        System.out.println("输入2减少一级风力");
        System.out.println("请输入操作指令");
        int order = sc.nextInt();
        switch (order) {
            case 1:
                this.funSpeed = this.funSpeed + 1;
                break;
            case 2:
                this.funSpeed = this.funSpeed - 1;
                break;
            default:
                System.out.println("输入操作错误");
        }
        System.out.println("Now*" + this.getLocation() + "的" + "当前风力的大小为：" + this.funSpeed);

    }
    public String toString() {
        return this.getLocation()+"的"+this.getName()+"风力强度的状态为："+this.funSpeed+"\t设备开关状态为："+this.isStatus();
    }
}
