package com.myapp.java.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProducerConsumerWaitNotifyDemo {
    static class SharedResource {
        Object e = new Object();
        boolean isLocked = false;
        private final int[] numbers;
        int count = 0;
        final int total;

        SharedResource(int count) {
            this.total = count;
            this.numbers = new int[total];
        }

        public void produce() {
            synchronized (e) {
                try {
                    while (count == total) e.wait();
                } catch (InterruptedException e) {
                    System.out.println("Interruped on producer");
                }
                System.out.println("Producer : count " + count);
                int num = (int) (Math.random() * 100);
                System.out.println("Producing num " + num);
                numbers[count]= num;
                count = count + 1;
                e.notify();
            }
        }

        public void consume() {
            synchronized (e) {
                try {
                    while (count == 0) e.wait();
                } catch (InterruptedException e) {
                    System.out.println("Interrupted on consumer");
                }
                count -= 1;
                System.out.println("Consumer : count " + count);
                System.out.println("Consuming " + numbers[count]);
                e.notify();
            }
        }
    }


    public static void main(String[] args) {

        class Producer extends Thread {
            SharedResource resource;

            Producer(SharedResource r) {
                this.resource = r;
            }

            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Main Interruped");
                }
                resource.produce();
            }
        }

        class Consumer extends Thread {
            SharedResource resource;

            Consumer(SharedResource r) {
                this.resource = r;
            }

            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.out.println("Main Interruped");
                }
                resource.consume();
            }
        }

        SharedResource resource = new SharedResource(2);

        Producer p1 = new Producer(resource);
        Producer p2 = new Producer(resource);
        Producer p3 = new Producer(resource);
        p1.start();
        p2.start();
        p3.start();
        Scanner s = new Scanner(System.in);
        s.nextLine();
        Consumer c1 = new Consumer(resource);
        Consumer c2 = new Consumer(resource);
        c1.start();
        c2.start();
    }
}
