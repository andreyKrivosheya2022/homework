package com.company.petrolStation;

public class Main {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new CustomerReplenish(100f));
        Thread thread2 = new Thread(new CustomerReplenish(100f));
        Thread thread3 = new Thread(new CustomerReplenish(100f));
        Thread thread4 = new Thread(new CustomerReplenish(400f));
        Thread thread5 = new Thread(new CustomerReplenish(100f));

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
}
