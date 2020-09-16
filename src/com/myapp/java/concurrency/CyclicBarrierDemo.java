package com.myapp.java.concurrency;

import java.util.Scanner;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

public class CyclicBarrierDemo {
    CyclicBarrier barrier;
    AtomicInteger count = new AtomicInteger(0);
    class PrintRandomNumberThread implements Runnable {
        @Override
        public void run() {
            try {
                System.out.println(count.addAndGet(1));
                barrier.await();
                System.out.println(Thread.currentThread().getName() + " " + (int) (Math.random() * 100));
            } catch (InterruptedException e) {
                System.out.println("Interrupted Exception");
            } catch (BrokenBarrierException b) {
                System.out.println("Broken Barrier Exception");
            }
        }
    }

    public void runSimulation(int p) {
        barrier = new CyclicBarrier(p);
        Scanner test = new Scanner(System.in);
        for (int i = 0; i < p; i++) {
            Thread run = new Thread(new PrintRandomNumberThread());
            run.setName("Utkarsh_" + i);
            if (i == p - 1) {
                test.nextLine();
            }
            run.start();
        }
        System.out.println("latch left");
    }

    public static void main(String[] args) {
        CyclicBarrierDemo d = new CyclicBarrierDemo();
        d.runSimulation(8);
    }

}
