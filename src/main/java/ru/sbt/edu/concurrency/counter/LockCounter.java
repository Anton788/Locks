package ru.sbt.edu.concurrency.counter;

import java.util.concurrent.locks.ReentrantLock;

public class LockCounter implements Counter{
    private ReentrantLock locker = new ReentrantLock();
    private int count = 0;

    @Override
    public void increment() {
        locker.lock();
        count += 1;
        locker.unlock();
    }

    @Override
    public long getValue() {
        return count;
    }
}
