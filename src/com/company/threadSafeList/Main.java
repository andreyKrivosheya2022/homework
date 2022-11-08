package com.company.threadSafeList;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new ArraySafeList(0,1));
        Thread thread2 = new Thread(new ArraySafeList(0,1));
        Thread thread3 = new Thread(new ArraySafeList(0,1));

        thread1.start();
        thread1.join();

        thread2.start();
        thread2.join();

        thread3.start();
    }
}
