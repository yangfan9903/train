package com.test.train.interface1;

public class ClassDataInterImpl2 implements ClassDataInfo {
    private Student[] students;

    public ClassDataInterImpl2(Student[] students) {
        this.students = students;
    }

    @Override
    public void printAllStudentInfos() {
        int sex1Number = 0;
        int sex2Number = 0;
        for (Student student : students) {
            System.out.println(student);
            if (student.getSex().equals("男")) {
                sex1Number += 1;
            } else {
                sex2Number += 1;
            }
        }
        System.out.println("班级中男生有" + sex1Number + "人, 女生有" + sex2Number + "人。");
    }

    @Override
    public void printAverageScore() {
        Student s1 = students[0];
        double maxscore = s1.getScore();
        double minscore = s1.getScore();
        double sum = 0;
        for (Student student : students) {
            sum += student.getScore();
            if (student.getScore() > maxscore) {
                maxscore = student.getScore();
            }
            if (student.getScore() < minscore) {
                minscore = student.getScore();
            }

        }
        sum = sum - maxscore - minscore;
        System.out.println("班级的平均成绩为：" + (sum / (students.length - 2)));
    }
}
