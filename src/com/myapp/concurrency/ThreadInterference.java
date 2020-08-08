/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.concurrency;

/**
 *
 * @author utkarshj
 */
class CounterManager {

    private int counter = 0;

    public void increment() {
        System.out.println("incrementing " + counter);
        counter++;
        System.out.println("incremented " + counter);
    }

    public void decrement() {
        System.out.println("decrementing " + counter);
        counter--;
        System.out.println("decremented " + counter);
    }

    public int getCounter() {
        return counter;
    }
}

public class ThreadInterference {

    public static void main(String[] args) throws InterruptedException {
        CounterManager c = new CounterManager();

        int i = 0;
        while (i < 5) {
            System.out.println("-----------------------" + i);
            Thread t1 = new Thread(() -> {
                try {
                    c.increment();
                } catch (Exception e) {
                    System.out.println("Exception");
                }
            });
            Thread t2 = new Thread(() -> {
                try {
                    c.increment();
                } catch (Exception e) {
                    System.out.println("Exception");
                }
            });
            Thread t4 = new Thread(() -> {
                try {
                    c.decrement();
                } catch (Exception e) {
                    System.out.println("Exception");
                }
            });
            Thread t5 = new Thread(() -> {
                try {
                    c.decrement();
                } catch (Exception e) {
                    System.out.println("Exception");
                }
            });
            t1.start();
            t2.start();
            t4.start();
            t5.start();
            t1.join();
            t2.join();
            t4.join();
            t5.join();
            System.out.println("-----------------------" + i);
            i++;
        }

        System.out.println(c.getCounter());
    }
}
