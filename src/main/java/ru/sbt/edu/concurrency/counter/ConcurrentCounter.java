package ru.sbt.edu.concurrency.counter;


import java.util.concurrent.ConcurrentLinkedQueue;


public class ConcurrentCounter implements Counter{
    private ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue();

    @Override
    public void increment() {
        queue.add(1);
    }

    @Override
    public long getValue() {
        return queue.size();
    }
}
