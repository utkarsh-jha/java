package com.myapp.java.concurrency;

import sun.nio.ch.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizedMethodDemo {
    private int a = 0;

    public synchronized void incrementAndPrint() {

        try {
            Thread.sleep(5000);
            a = a + 1;
            System.out.println(a);
        } catch (InterruptedException e) {
            System.out.println("interruped");
        }
    }

    public void decrementAndPrint() {
        a = a - 1;
        System.out.println(a);
    }

    public void unsafeIncrementAndPrint() {
        a = a + 1;
        System.out.println(a);
    }
    static class incrTask implements Runnable {
        SynchronizedMethodDemo d;

        incrTask(SynchronizedMethodDemo d) {
            this.d = d;
        }

        @Override
        public void run() {
            d.incrementAndPrint();
        }
    }
    static class decrTask implements Runnable {
        SynchronizedMethodDemo d;

        decrTask(SynchronizedMethodDemo d) {
            this.d = d;
        }

        @Override
        public void run() {
            d.decrementAndPrint();
        }
    }

    static class TaskSync implements Runnable {
        SynchronizedMethodDemo d;

        TaskSync(SynchronizedMethodDemo d) {
            this.d = d;
        }

        @Override
        public void run() {
            d.incrementAndPrint();
        }
    }

    static class Task implements Runnable {
        SynchronizedMethodDemo d;

        Task(SynchronizedMethodDemo d) {
            this.d = d;
        }

        @Override
        public void run() {
            d.unsafeIncrementAndPrint();
        }
    }

    public static void main(String[] args) {
        ExecutorService s = Executors.newFixedThreadPool(2);
        SynchronizedMethodDemo d = new SynchronizedMethodDemo();
//        for (int i = 0; i < 100; i++) {
//            s.submit(new TaskSync(d));
//        }
//
//        for (int i = 0; i < 100; i++) {
//            s.submit(new Task(d));
//        }
        s.submit(new incrTask(d));
//        s.submit(new incrTask(d));
        s.submit(new decrTask(d));

    }
}
