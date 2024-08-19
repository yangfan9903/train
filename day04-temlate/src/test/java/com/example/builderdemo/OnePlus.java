package com.example.builderdemo;

public class OnePlus implements PhoneBuilder{
    @Override
    public void buildName() {
        phone.setName("一加");
    }

    @Override
    public void buildCpu() {
        phone.setCpu("骁龙855");
    }

    @Override
    public void buildCamera() {
        phone.setCamera("四摄1w");
    }

    @Override
    public void buildMemory() {
        phone.setMemory(16);
    }

    @Override
    public void buildPower() {
        phone.setPower(4000);
    }

    @Override
    public void buildSound() {
        phone.setSound("双音响");
    }

    @Override
    public void buildSize() {
        phone.setSize(4);
    }

    @Override
    public void buildColor() {
        phone.setColor("black");
    }

    @Override
    public Phone build() {
        return phone;
    }
}
