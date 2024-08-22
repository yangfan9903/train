package com.example;

public class test {
    public static void main(String[] args) {
        String k = "000000000000000000000000000000000000000000000000001";
        System.out.println(k);
        for(int n=0;n<k.length();n++){
            if(k.startsWith("0")){
                k = k.substring(1);
            }
        }
        System.out.println(k);
    }
}
