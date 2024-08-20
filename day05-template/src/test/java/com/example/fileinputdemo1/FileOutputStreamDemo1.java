package com.example.fileinputdemo1;

import java.io.*;

public class FileOutputStreamDemo1 {
    public static void main(String[] args) throws Exception {
        OutputStream os = new FileOutputStream("day05-template/src/test/java/com/example/fileinputdemo1/write.txt", true);
        byte[] bytes = "我爱你中国casdad66".getBytes();
        os.write(bytes);
        os.close();

    }
}
