package me.zodiakk.spigotjs.commands.spigotjs;

import java.util.concurrent.CountDownLatch;

public class TimedCountDown {
    private long startTime;
    private long endTime;
    private int start;
    private CountDownLatch latch;

    public TimedCountDown(int amount) {
        latch = new CountDownLatch(amount);
    }

    public void countDown() {
        if (latch.getCount() == start) {
            startTime = System.currentTimeMillis();
        } else if (latch.getCount() == 1) {
            endTime = System.currentTimeMillis();
        }
    }

    public void await() throws InterruptedException {
        latch.await();
    }

    public long getCount() {
        return latch.getCount();
    }

    public long getTime() {
        return endTime - startTime;
    }
}
