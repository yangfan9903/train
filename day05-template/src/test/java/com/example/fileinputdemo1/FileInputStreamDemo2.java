package com.example.fileinputdemo1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class FileInputStreamDemo2 {
    public static void main(String[] args) throws Exception {
        InputStream is = new FileInputStream("day05-template\\src\\test\\java\\com\\example\\b.txt");
        byte[] buffer = new byte[3];
        int len;
        while ((len = is.read(buffer)) != -1) {
            String str = new String(buffer, 0, len);
            System.out.print(str);
        }
        is.close();
    }
}
