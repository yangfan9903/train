package com.example.builderdemo;

public interface PhoneBuilder {
    Phone phone = new Phone();

    void buildName();
    void buildCpu();
    void buildCamera();
    void buildMemory();
    void buildPower();
    void buildSound();
    void buildSize();
    void buildColor();
    Phone build();
}
