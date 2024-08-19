package com.example.builddemo2;

public class PhoneBuilder {
    private final Phone phone = new Phone();
    public PhoneBuilder buildCpu(String cpu){
        phone.setCpu(cpu);
        return this;
    }
    public PhoneBuilder buildCamera(String camera){
        phone.setCamera(camera);
        return this;
    }
    public PhoneBuilder buildColor(String color){
        phone.setColor(color);
        return this;
    }
    public PhoneBuilder buildMemory(int memory){
        phone.setMemory(memory);
        return this;
    }
    public PhoneBuilder buildPower(int power){
        phone.setPower(power);
        return this;
    }
    public PhoneBuilder buildSize(double size){
        phone.setSize(size);
        return this;
    }
    public PhoneBuilder buildSound(String sound){
        phone.setSound(sound);
        return this;
    }
    public PhoneBuilder buildName(String name){
        phone.setName(name);
        return this;
    }
    public Phone build(){
        return phone;
    }


}
