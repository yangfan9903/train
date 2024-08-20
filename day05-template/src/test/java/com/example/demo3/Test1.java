package com.example.demo3;

public class Test1 {
    public static void main(String[] args) {
        BankUser bankUser = new BankUser("123",5000);
        Thread t1 = new Thread2("小明", bankUser);
        Thread t2 = new Thread2("小红", bankUser);

            t1.start();
            t2.start();

    }
}

class Thread2 extends Thread {
    private BankUser bankUser;
    public Thread2(String name, BankUser bankUser) {
        super(name);
        this.bankUser = bankUser;
    }
    public void run() {
        bankUser.drawMoney(5000);

    }


}