package com.myapp.design.pattern.creational.factory;

public abstract class Plan {
    int rate;

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public abstract int generateBill();
}
