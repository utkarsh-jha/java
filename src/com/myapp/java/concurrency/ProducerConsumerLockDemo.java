package com.myapp.java.concurrency;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerLockDemo {
    static class SharedResource {
        Object e = new Object();

        Lock l = new ReentrantLock();
        Condition push = l.newCondition();
        Condition pull = l.newCondition();
        private final int[] numbers;
        int count = 0;
        final int total;

        SharedResource(int count) {
            this.total = count;
            this.numbers = new int[total];
        }

        public void produce() throws InterruptedException {
            l.lock();
            try {
                while (count == total) push.await();
                System.out.println("Producer : count " + count);
                int num = (int) (Math.random() * 100);
                System.out.println("Producing num " + num);
                numbers[count] = num;
                count = count + 1;
                pull.signal();
            } finally {
                l.unlock();
            }


        }

        public void consume() throws InterruptedException{
            l.lock();
            try {
                while (count == 0) pull.await();
                count -= 1;
                System.out.println("Consumer : count " + count);
                System.out.println("Consuming " + numbers[count]);
                push.signal();
            } finally {
                l.unlock();
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
                    resource.produce();
                } catch (InterruptedException e) {
                    System.out.println("Main Interruped");
                }
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
                    resource.consume();
                } catch (InterruptedException e) {
                    System.out.println("Main Interruped");
                }
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
