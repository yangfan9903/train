package com.test.train.interface1;

public class Student {
    private String name;
    private String sex;
    private double score;

    public Student(String name, String sex, double score) {
        this.name = name;
        this.sex = sex;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "学生姓名为："  + name +
                ", 性别：" + sex +
                ", 分数：" + score;
    }
}
