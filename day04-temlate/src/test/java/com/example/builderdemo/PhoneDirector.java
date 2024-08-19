package com.example.builderdemo;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PhoneDirector {
    private PhoneBuilder phoneBuilder;
    public Phone construct() {
        phoneBuilder.buildCpu();
        phoneBuilder.buildCamera();
        phoneBuilder.buildColor();
        phoneBuilder.buildMemory();
        phoneBuilder.buildName();
        phoneBuilder.buildPower();
        phoneBuilder.buildSize();
        phoneBuilder.buildSound();
        return phoneBuilder.build();

    }
}
