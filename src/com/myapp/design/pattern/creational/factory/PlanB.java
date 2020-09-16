package com.myapp.design.pattern.creational.factory;

public class PlanB extends Plan {
    static {
        PlanFactory.registerPlan("PlanB", new PlanC());
    }
    @Override
    public int generateBill() {
        return this.rate * 200;
    }

}
