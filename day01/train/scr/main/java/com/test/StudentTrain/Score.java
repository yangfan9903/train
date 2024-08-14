package day01.train.scr.main.java.com.test.StudentTrain;

public class Score {
    public static void main(String[] args) {
        Student student1 = new Student();
        student1.setName("播妞");
        student1.setMathscore(100);
        student1.setChinesescore(100);
        student1.printgetTotal();
        student1.printgetAverage();

        Student student2 = new Student();
        student2.setName("播崽");
        student2.setMathscore(60);
        student2.setChinesescore(70);
        student2.printgetTotal();
        student2.printgetAverage();


    }
}
