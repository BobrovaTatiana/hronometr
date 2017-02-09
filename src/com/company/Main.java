package com.company;

public class Main {
    public static void main(String[] args) {
        Times times = new Times();
        int stopTimer = 20;
        Thread thread1 = new Thread(new StopWatch(times, stopTimer));
        Thread thread2 = new Thread(new ShowMsg(times, 5, stopTimer));
        Thread thread3 = new Thread(new ShowMsg(times, 7, stopTimer));

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
