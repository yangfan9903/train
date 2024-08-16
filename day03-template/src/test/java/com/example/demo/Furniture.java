package com.example.demo;

public abstract class Furniture implements FurnitureOperation{
    private String name;
    private Location location;
    private boolean status;

    public Furniture(String name, Location location, boolean status) {
        this.name = name;
        this.location = location;
        this.status = status;
    }

    public void furnitureSwitch(){
        System.out.println("*"+ this.location + "的" + this.name + "设备的开关状态为：" + (this.status ? "开启状态" : "关闭状态"));
        this.status = !this.status;
        System.out.println("Now*"+ this.location + "的" + this.name + "设备的开关状态为：" + (this.status ? "开启状态" : "关闭状态"));
    }

    @Override
    public abstract void furnitureOperation();

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
