package com.example.fileinputdemo1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class FileInputStreamDemo {
    public static void main(String[] args) throws Exception {
        InputStream is = new FileInputStream("day05-template\\src\\test\\java\\com\\example\\a.txt");
        int b;
        while ((b = is.read()) != -1) {
            System.out.print((char) b);
        }
        is.close();
    }
}
