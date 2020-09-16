package com.myapp.java.core;

class fieldClass implements Cloneable{
    int a;
    int b;

    public fieldClass(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public Object clone(){
        Object es = new Object();
        try {
            es = super.clone();
        }catch (CloneNotSupportedException e){
            System.out.println("Clone not supported");
        }
        return es;
    }
}
public final class ImmutableClass {
    final fieldClass member;

    ImmutableClass(fieldClass c){
        fieldClass temp = c;

        member = new fieldClass(c.getA(), c.getB());
    }

    public fieldClass getMember() {
        return (fieldClass) member.clone();
    }
}
