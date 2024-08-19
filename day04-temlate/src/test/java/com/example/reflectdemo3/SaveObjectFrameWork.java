package com.example.reflectdemo3;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;

public class SaveObjectFrameWork {
    public static void saveObject(Object obj) throws Exception {
        PrintStream ps = new PrintStream(new FileOutputStream("day04-temlate/src/test/java/com/example/reflectdemo3/adasd.txt",true));
        Class clazz = obj.getClass();
        String simpleName = clazz.getSimpleName();
        ps.println("=========="+simpleName+"==========");

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            String fieldName = field.getName();
            field.setAccessible(true);
            Object fieldValue = field.get(obj);
            ps.println(fieldName+"="+fieldValue);
        }
        ps.close();
    }
}
