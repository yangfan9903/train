package com.example.demo;

import java.util.Scanner;

public class Tv extends Furniture{
    Scanner sc = new Scanner(System.in);
    private int channelStatus;

    public Tv(String name, Location location, boolean status, int channelStatus) {
        super(name, location, status);
        this.channelStatus = channelStatus;
    }

    @Override
    public void furnitureOperation() {
        System.out.println("*" + this.getLocation() + "的" + this.getName() + "频道的状态为：" + this.channelStatus);
        System.out.println("切换频道操作如下：");
        System.out.println("输入1增加一个频道");
        System.out.println("输入2减少一个频道");
        System.out.println("请输入操作指令");
        int order = sc.nextInt();
        switch (order) {
            case 1:
                this.channelStatus = this.channelStatus + 1;
                break;
            case 2:
                this.channelStatus = this.channelStatus - 1;
                break;
            default:
                System.out.println("输入操作错误");
        }
        System.out.println("Now*" + this.getLocation() + "的" + this.getName() + "频道的状态为：" + this.channelStatus);

    }

    @Override
    public String toString() {
        return this.getLocation()+"的"+this.getName()+"频道的状态为："+this.channelStatus+"\t设备开关状态为："+this.isStatus();
    }
}
