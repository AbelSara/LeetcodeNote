package Concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * @Author Honghan Zhu
 * @leetcode 1116
 * @grade medium
 */
public class ZeroEvenOdd {
    private int n;
    Lock lock = new ReentrantLock();
    Condition evenCondition = lock.newCondition();
    Condition oddCondition = lock.newCondition();
    Condition zeroCondition = lock.newCondition();
    private int state;
    private int i;

    public ZeroEvenOdd(int n) {
        this.n = n;
        state = 0;
        i = 1;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            while (i <= n) {
                if (state != 0)
                    zeroCondition.await();
                if(i > n) {
                    oddCondition.signal();
                    evenCondition.signal();
                    return;
                }
                printNumber.accept(0);
                if (i % 2 == 1) {
                    state = 1;
                    oddCondition.signal();
                } else if (i % 2 == 0) {
                    state = 2;
                    evenCondition.signal();
                }
            }
        } finally {
            lock.unlock();
        }

    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            while (i <= n) {
                if (state != 2)
                    evenCondition.await();
                if(i > n){
                    zeroCondition.signal();
                    oddCondition.signal();
                    return;
                }
                printNumber.accept(i++);
                state = 0;
                zeroCondition.signal();
            }
        } finally {
            lock.unlock();
        }

    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            while (i <= n) {
                if (state != 1)
                    oddCondition.await();
                if(i > n){
                    zeroCondition.signal();
                    evenCondition.signal();
                    return;
                }
                state = 0;
                printNumber.accept(i++);
                zeroCondition.signal();
            }
        } finally {
            lock.unlock();

        }
    }

    public static void main(String[] args) throws Exception {
        IntConsumer intConsumer = value -> System.out.println(value);
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(2);
        new Thread(() -> {
            try {
                zeroEvenOdd.zero(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                zeroEvenOdd.odd(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                zeroEvenOdd.even(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
