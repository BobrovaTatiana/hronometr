package com.company;

import static java.lang.StrictMath.round;

/**
 * Created by Tanusha on 09/02/2017.
 */
public class ShowMsg implements Runnable {
    public int delay;
    public Times times;
    private int stopTimerAfter;


    public ShowMsg(Times times, int delay, int stopTimerAfter) {
        this.delay = delay;
        this.times = times;
        this.stopTimerAfter = stopTimerAfter;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (times) {
                try {
                    int timeInt = times.getTime();
                    if (timeInt > stopTimerAfter) return;
                    if((timeInt % delay == 0) && (timeInt != 0)) {
                        System.out.println("Сообщение " + delay + " секунд");
                    }
                    times.wait();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
