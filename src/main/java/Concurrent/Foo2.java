package Concurrent;

/**
 * @Author Honghan Zhu
 * @leetcode 1114
 * @grade medium
 * @solution synchronized
 */
public class Foo2 {
    Object o = new Object();
    int state = 1;

    public Foo2() {

    }


    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (o) {
            while(state != 1)
                o.wait();
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            state = 2;
            o.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (o) {
            while(state != 2)
                o.wait();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            state = 3;
            o.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (o) {
            while(state != 3)
                o.wait();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }
}
