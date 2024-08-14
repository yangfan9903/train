package day01.StudentTrain;

public class Student {
    private String name;
    private int mathscore;
    private int chinesescore;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMathscore() {
        return mathscore;
    }

    public void setMathscore(int mathscore) {
        this.mathscore = mathscore;
    }

    public int getChinesescore() {
        return chinesescore;
    }

    public void setChinesescore(int chinesescore) {
        this.chinesescore = chinesescore;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", mathscore=" + mathscore +
                ", chinesescore=" + chinesescore +
                '}';
    }
    public void printgetAverage(){
        System.out.println(this.name+"的平均成绩为:"+(this.mathscore + this.chinesescore) / 2.0);
    }
    public void printgetTotal(){
        System.out.println(this.name+"的总成绩为:"+(this.mathscore + this.chinesescore));
    }
}
