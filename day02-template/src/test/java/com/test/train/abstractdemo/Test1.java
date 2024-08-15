package com.test.train.abstractdemo;
// 抽象类编程思想是为了简化不必要的步骤
// 如果两个对象都有同样相同的操作，但是中间步骤不是很一样可以根据抽象类方法
// 来进一步修改中间的过程
public class Test1 {
    public static void main(String[] args) {
        People student1 = new Student();
        People teacher1 = new Teacher();
        student1.write();
        teacher1.write();
    }
}
