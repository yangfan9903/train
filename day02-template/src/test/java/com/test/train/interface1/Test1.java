package com.test.train.interface1;

public class Test1 {
    public static void main(String[] args) {
        Student[] students = new Student[5];
        students[0] = new Student("张三", "男", 90 );
        students[1] = new Student("李四", "女", 80 );
        students[2] = new Student("王五", "男", 70 );
        students[3] = new Student("赵六", "女", 60 );
        students[4] = new Student("钱七", "男", 50 );
        ClassDataInfo classDataInfo = new ClassDataInterImpl2(students);
        classDataInfo.printAllStudentInfos();
        classDataInfo.printAverageScore();

    }
}
