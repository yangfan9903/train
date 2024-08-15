package com.test.train.interface1;

public class ClassDataInterImpl1 implements ClassDataInfo{
    private Student[] students;
    public ClassDataInterImpl1(Student[] students) {
        this.students = students;
    }

    @Override
    public void printAllStudentInfos() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Override
    public void printAverageScore() {
        double sum = 0;
        for (Student student : students) {
            sum+=student.getScore();
        }
        System.out.println("班级平均成绩为："+sum/students.length);
    }
}
