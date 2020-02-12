package Concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author Honghan Zhu
 * @leetcode 1114
 * @grade medium
 * @solution lock & condition
 */
public class Foo1 {
    Lock lock;
    Condition condition2;
    Condition condition3;
    int state;

    public Foo1() {
        state = 1;
        lock = new ReentrantLock();
        condition2 = lock.newCondition();
        condition3 = lock.newCondition();
    }


    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock();
        try {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            state = 2;
            condition2.signal();
        } finally {
            lock.unlock();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock.lock();
        try {
            if (state != 2) {
                condition2.await();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            state = 3;
            printSecond.run();
            condition3.signal();
        } finally {
            lock.unlock();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        lock.lock();
        try {
            if (state != 3) {
                condition3.await();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        } finally {
            lock.unlock();
        }
    }

}
