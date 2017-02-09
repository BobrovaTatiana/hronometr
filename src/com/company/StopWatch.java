package com.company;

/**
 * Created by Tanusha on 09/02/2017.
 */
public class StopWatch implements Runnable {
    private long start = System.currentTimeMillis();
    private int stopTimerAfter;
    private Times times;

    public StopWatch(Times times, int stopTimerAfter) {
        this.times = times;
        this.stopTimerAfter = stopTimerAfter;
    }

    @Override
    public void run() {
        int countUp = 0;
        try {
            while(stopTimerAfter >= countUp) {
                Thread.sleep(1000);
                synchronized (times) {
                    countUp = (int)((System.currentTimeMillis() - start)/1000);
                    times.setTime(countUp);
                    times.notifyAll();
                    System.out.println("Прошло " + countUp + " сек");
                }
            }
        } catch (InterruptedException e) {
                e.printStackTrace();
        }

    }
}
