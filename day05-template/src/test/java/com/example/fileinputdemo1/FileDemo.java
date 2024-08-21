package com.example.fileinputdemo1;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;


public class FileDemo {
    public static void main(String[] args) throws Exception {
        FileUtils.copyFile(new File("day05-template/src/test/java/com/example/fileinputdemo1/write.txt"), new File("day05-template/src/test/java/com/example/fileinputdemo1/read.txt"));
    }
}
