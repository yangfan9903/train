package com.example.demo;

public class FurnitureOperationInterImpl1 implements FurnitureOperation{
    Furniture furniture = new Furniture();
    public FurnitureOperationInterImpl1(Furniture furniture) {
        this.furniture = furniture;
    }
    @Override
    public void open() {

    }

    @Override
    public void close() {

    }
}
