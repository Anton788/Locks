package ru.sbt.edu.concurrency.counter;

import ru.sbt.edu.concurrency.util.ThreadID;

import java.util.concurrent.CopyOnWriteArrayList;

public class MagicCounter implements Counter{

    private final CopyOnWriteArrayList<Integer> level = new CopyOnWriteArrayList<>();
    private final CopyOnWriteArrayList<Integer> victim = new CopyOnWriteArrayList<>();
    private int count = 0;

    public MagicCounter(int count){
        for (int i = 0; i < count; ++i){
            level.add(0);
            victim.add(0);
        }
    }
    public boolean check_wait(int thread_id, int i){
        for (int k = 0; k < level.size(); ++k){
            if (k != thread_id && level.get(k) >= i && victim.get(i) == thread_id) {
                return true;
            }
        }
        return false;
    }
    public void lock() {
        int thread_id = ThreadID.get();
        for (int i = 1; i < level.size(); i++) {
            level.set(thread_id, i);
            victim.set(i, thread_id);
            while (check_wait(thread_id, i)){};
        }
    }

    public void unlock() {
        int me = ThreadID.get();
        level.set(me, 0);
    }

    @Override
    public void increment() {
        lock();
        count += 1;
        unlock();
    }

    @Override
    public long getValue() {
        return count;
    }
}
