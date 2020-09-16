package com.myapp.design.pattern.creational.Singleton;

class Singleton {
    private static Singleton singletonBean;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if (singletonBean == null) {
            synchronized (Singleton.class) {
                if (singletonBean == null) {
                    singletonBean = new Singleton();
                }
            }
        }
        return singletonBean;
    }


}

class SingletonLazyInitInner {
    private SingletonLazyInitInner(){
        System.out.println("called");
    }

    private static class InnerClass {
        InnerClass() {
            System.out.println("inner class created");
        }
        private static final SingletonLazyInitInner INSTANCE = new SingletonLazyInitInner();
    }

    public static SingletonLazyInitInner getInstance(){
        return InnerClass.INSTANCE;
    }
}

public class SingletonDemo {

    public static void main(String[] args) {
        SingletonLazyInitInner p,c;
        System.out.println("This is executed");
        System.out.println("This is executed");
        System.out.println("This is executed");
        System.out.println("This is executed");
        System.out.println("This is executed");
        System.out.println("This is executed");
        System.out.println("This is executed");
        System.out.println("This is executed");
        System.out.println("This is executed");
        System.out.println("This is executed");
        System.out.println("This is executed");
        System.out.println("This is executed");
        System.out.println("This is executed");
        System.out.println("This is executed");
        System.out.println("getting instance");
        p= SingletonLazyInitInner.getInstance();
        System.out.println("getting instance");
        c = SingletonLazyInitInner.getInstance();
        if(p==c) System.out.println("SAME");
    }
}
