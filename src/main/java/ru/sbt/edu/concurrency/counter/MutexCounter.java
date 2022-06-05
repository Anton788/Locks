package ru.sbt.edu.concurrency.counter;

public class MutexCounter implements Counter{
    int count = 0;
    @Override
    public synchronized void increment() {
        count += 1;
    }

    @Override
    public long getValue() {
        return count;
    }
}
