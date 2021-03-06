package ru.sbt.edu.concurrency.locks.theory;

import ru.sbt.edu.concurrency.locks.ILock;
import ru.sbt.edu.concurrency.util.TwoThreadIds;


public class LockOne implements ILock {
    private final boolean[] flag = new boolean[2];

    @Override
    public void lock() {
        int i = TwoThreadIds.me();
        flag[i] = true;
        while (flag[TwoThreadIds.not(i)]){

        }

    }


    @Override
    public void unlock() {
        int i = TwoThreadIds.me();
        flag[i] = false;
    }
}