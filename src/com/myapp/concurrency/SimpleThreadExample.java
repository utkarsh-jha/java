package com.myapp.concurrency;

class ThreadLogic extends Thread {

    String list[];

    public void setList(String[] list) {
        this.list = list;
    }

    @Override
    public void run() {
        System.out.println(System.currentTimeMillis() + " STARTED");
        for (int i = 0; i < list.length; i++) {
            System.out.println(System.currentTimeMillis() + " INLOOP");
            if (Thread.currentThread().isInterrupted()) {
                System.out.println(System.currentTimeMillis() + " INTURRUPTED AND RETURNING");
                return;
            }
//            try {
//                System.out.println(i + " BEFORE SLEEP");
//                Thread.sleep(4000);
//                System.out.println(i + " AFTER SLEEP");
            System.out.println(list[i]);
//            } catch (InterruptedException e) {
//                System.out.println(System.currentTimeMillis() + " :" +Thread.currentThread().getName() + " INTERRUPTED");
//                return;
//            }
        }
    }

}

public class SimpleThreadExample {

    public static void main(String[] args) throws InterruptedException {
        ThreadLogic l = new ThreadLogic();
        String[] p = {"utkarsh", "test01", "test02"};
        l.setList(p);
        long st = System.currentTimeMillis();
        l.setName("UtkarshThread");

        l.start();
        l.interrupt();
        Thread.sleep(1);

//        System.out.println(System.currentTimeMillis() + " WAITING 3900 millis and executed this");
//        l.join(3900);
//        System.out.println(System.currentTimeMillis() + " INTERRUPT INITIATED");
    }

}
